package com.cg.ama.service.user;

import java.util.List;

import com.cg.ama.exception.AssetNotFoundException;
import com.cg.ama.model.AssetModel;

public interface IUserAssetService {
	AssetModel getAssetById(long assetId) throws AssetNotFoundException;
	List<AssetModel> getAssetList();
}
