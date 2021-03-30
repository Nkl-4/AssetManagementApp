package com.cg.ama.service.manager;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ama.exception.AssetNotFoundException;
import com.cg.ama.exception.WarehouseNotFoundException;
import com.cg.ama.model.AssetModel;
import com.cg.ama.repo.AssetRepo;
import com.cg.ama.repo.WarehouseRepo;
import com.cg.ama.service.EMParser;

@Service
public class ManagerAssetServiceImpl implements IManagerAssetService {
	
	@Autowired
	private EMParser parser;
	
	@Autowired
	private AssetRepo assetRepo;
	
	@Autowired
	private WarehouseRepo warehouseRepo;

	public ManagerAssetServiceImpl() {
		super();
	}

	public ManagerAssetServiceImpl(EMParser parser, AssetRepo assetRepo, WarehouseRepo warehouseRepo) {
		super();
		this.parser = parser;
		this.assetRepo = assetRepo;
		this.warehouseRepo = warehouseRepo;
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

	@Override
	public AssetModel modifyAsset(Long assetId, AssetModel assetModel) throws AssetNotFoundException {
		if(assetModel != null) {
			if (!assetRepo.existsById(assetId)) {
				throw new AssetNotFoundException("Asset Not present in DB.");
			}
			assetModel = parser.parse((assetRepo.save(parser.parse(assetModel))));
		}
		return assetModel;
	}

	@Override
	public List<AssetModel> getAllAssets(Long warehouseId) throws WarehouseNotFoundException {
		if (!warehouseRepo.existsById(warehouseId)) {
			throw new WarehouseNotFoundException("No Warehouse present with the given ID");
		}
		return assetRepo.getAssetsInWarehouse(warehouseId).stream().map(parser::parse).collect(Collectors.toList());
	}


	


}
