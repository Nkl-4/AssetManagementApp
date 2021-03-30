package com.cg.ama.model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.cg.ama.entity.AssetType;

public class AssetModel {

	private Long assetId;
	
	@NotNull(message="Warehouse ID cannot be null")	
	private WarehouseModel warehouse;
	
	@NotNull(message="Asset ID cannot be null")	
	@NotBlank(message="Asset ID cannot be blank")
	private String model;
	
	@Enumerated(EnumType.STRING)
	private AssetType type;
	
	@NotNull(message="Asset ID cannot be null")	
	@NotBlank(message="Asset ID cannot be blank")
	private String manufacturer;

	public AssetModel() {
		super();
	}
	
	public AssetModel(Long assetId, WarehouseModel warehouse, String model, AssetType type, String manufacturer) {
		super();
		this.assetId = assetId;
		this.warehouse = warehouse;
		this.model = model;
		this.type = type;
		this.manufacturer = manufacturer;
	}


	public AssetModel(WarehouseModel warehouse, String model, AssetType type, String manufacturer) {
		super();
		this.warehouse = warehouse;
		this.model = model;
		this.type = type;
		this.manufacturer = manufacturer;
	}



	public WarehouseModel getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(WarehouseModel warehouse) {
		this.warehouse = warehouse;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public AssetType getType() {
		return type;
	}

	public void setType(AssetType type) {
		this.type = type;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Long getAssetId() {
		return assetId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assetId == null) ? 0 : assetId.hashCode());
		result = prime * result + ((manufacturer == null) ? 0 : manufacturer.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((warehouse == null) ? 0 : warehouse.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AssetModel other = (AssetModel) obj;
		if (assetId == null) {
			if (other.assetId != null)
				return false;
		} else if (!assetId.equals(other.assetId))
			return false;
		if (manufacturer == null) {
			if (other.manufacturer != null)
				return false;
		} else if (!manufacturer.equals(other.manufacturer))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (type != other.type)
			return false;
		if (warehouse == null) {
			if (other.warehouse != null)
				return false;
		} else if (!warehouse.equals(other.warehouse))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AssetModel [assetId=" + assetId + ", warehouse=" + warehouse + ", model=" + model + ", type=" + type
				+ ", manufacturer=" + manufacturer + "]";
	}
	
	
	
}
