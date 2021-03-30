package com.cg.ama.service;

import org.springframework.stereotype.Service;
import com.cg.ama.entity.AddressEntity;
import com.cg.ama.entity.AssetEntity;
import com.cg.ama.entity.ShipmentEntity;
import com.cg.ama.entity.UserEntity;
import com.cg.ama.entity.WarehouseEntity;
import com.cg.ama.model.AddressModel;
import com.cg.ama.model.AssetModel;
import com.cg.ama.model.ShipmentModel;
import com.cg.ama.model.UserModel;
import com.cg.ama.model.WarehouseModel;


@Service
public class EMParser {
	
	
	public WarehouseEntity parse(WarehouseModel source) {
		return source==null?null:
			new WarehouseEntity( source.getWhId(), source.getMgrId(),
					new AddressEntity(source.getAddress().getLocation(),source.getAddress().getSubLocation()
					, source.getAddress().getState(), source.getAddress().getCountry()));
	}
	
	public WarehouseModel parse(WarehouseEntity source) {
		return source==null?null:
			new WarehouseModel(source.getWhId(), source.getMgrId(),
					new AddressModel(source.getAddress().getLocation(),source.getAddress().getSubLocation()
					, source.getAddress().getState(), source.getAddress().getCountry()));
	}
	
	public UserEntity parse(UserModel source) {
		return source==null?null:
			new UserEntity(source.getUserId(), source.getUserName(),
					source.getUserPassword(), source.getUserType());
	}
	
	public UserModel parse(UserEntity source) {
		return source==null?null:
			new UserModel(source.getUserId(), source.getUserName(), source.getUserPassword(), source.getUserType());
	}
	
	public AssetEntity parse(AssetModel source) {
		return source==null?null:
			new AssetEntity(source.getAssetId(), new WarehouseEntity(source.getWarehouse().getWhId(), source.getWarehouse().getMgrId(),
					new AddressEntity(source.getWarehouse().getAddress().getLocation(),source.getWarehouse().getAddress().getSubLocation(),
							source.getWarehouse().getAddress().getState(), source.getWarehouse().getAddress().getCountry()))
							, source.getModel(), source.getType(), source.getManufacturer());
	}
	
	public AssetModel parse(AssetEntity source) {
		return source==null?null:
			new AssetModel(source.getAssetId(), new WarehouseModel(source.getWarehouse().getWhId(), source.getWarehouse().getMgrId(),
					new AddressModel(source.getWarehouse().getAddress().getLocation(),source.getWarehouse().getAddress().getSubLocation(),
							source.getWarehouse().getAddress().getState(), source.getWarehouse().getAddress().getCountry()))
							, source.getModel(), source.getType(), source.getManufacturer());
	}
	
	public ShipmentEntity parse(ShipmentModel source) {
		return source==null?null:
			new ShipmentEntity(source.getShipmentId(), source.getAssetId(), source.getUserId(),
					source.getStatus(), source.getSourceWhId(),
						source.getDestWhId(), source.getShipmentDate(), source.getDeliveryDate());
	}
	
	public ShipmentModel parse(ShipmentEntity source) {
		return source==null?null:
			new ShipmentModel(source.getShipmentId(), source.getAssetId(), source.getUserId(),
					source.getStatus(), source.getSourceWhId(),
					  source.getDestWhId(), source.getShipmentDate(), source.getDeliveryDate());
	}
	
	
}
