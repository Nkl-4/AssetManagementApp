package com.cg.ama.service.manager;

import java.util.List;

import com.cg.ama.exception.AssetNotFoundException;
import com.cg.ama.exception.WarehouseNotFoundException;
import com.cg.ama.model.AssetModel;

public interface IManagerAssetService {

	AssetModel getAssetById(long assetId) throws AssetNotFoundException;
	List<AssetModel> getAssetList();
	AssetModel modifyAsset(Long assetId, AssetModel assetModel) throws AssetNotFoundException;
	List<AssetModel> getAllAssets(Long warehouseId) throws WarehouseNotFoundException;
}
