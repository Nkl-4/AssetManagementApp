package com.cg.ama.service.admin;

import java.util.List;

import com.cg.ama.exception.AssetNotFoundException;
import com.cg.ama.exception.DuplicateEntryException;
import com.cg.ama.model.AssetModel;


public interface IAdminAssetService {
	
	AssetModel getAssetById(Long assetId) throws AssetNotFoundException;
	
	AssetModel addAsset(AssetModel assetModel) throws DuplicateEntryException;
	
	List<AssetModel> getAssetList();
	
	AssetModel modifyAsset(Long assetId, AssetModel assetModel) throws AssetNotFoundException;
	
	String deleteAssetById(Long assetId) throws AssetNotFoundException;
	
}
