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
		this.parser = new EMParser();
		this.assetRepo = assetRepo;
	}
	
	//Get asset by id if not found return exception
	@Override
	public AssetModel getAssetById(long assetId) throws AssetNotFoundException {
		if (!assetRepo.existsById(assetId)) {
			throw new AssetNotFoundException("No Asset present with the given ID");
		}
		return parser.parse((assetRepo.findById(assetId).orElse(null)));
	}
	
	//Get all assets if not found return exception
	@Override
	public List<AssetModel> getAssetList() {
		return assetRepo.findAll().stream().map(parser::parse).collect(Collectors.toList());
	}


}
