package com.cg.ama.service.user;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ama.exception.AssetNotFoundException;
import com.cg.ama.model.AssetModel;
import com.cg.ama.repo.AssetRepo;
import com.cg.ama.service.EMParser;


@Service
public class UserAssetServiceImpl implements IUserAssetService {
	
	@Autowired
	private EMParser parser;
	
	@Autowired
	private AssetRepo assetRepo;	

	
	public UserAssetServiceImpl() {
		super();
	}

	public UserAssetServiceImpl(EMParser parser, AssetRepo assetRepo) {
		super();
		this.parser = parser;
		this.assetRepo = assetRepo;
	}

	@Override
	public AssetModel getAssetById(long assetId) throws AssetNotFoundException {
		if (!assetRepo.existsById(assetId)) {
			throw new AssetNotFoundException("No Asset present with the given ID");
		}
		return parser.parse((assetRepo.findById(assetId).orElse(null)));
	}
	
	@Override
	public List<AssetModel> getAssetList() throws AssetNotFoundException {
		if (assetRepo.count() == 0) {
			throw new AssetNotFoundException("No asset present with the given ID");
		}
		return assetRepo.findAll().stream().map(parser::parse).collect(Collectors.toList());
	}


}
