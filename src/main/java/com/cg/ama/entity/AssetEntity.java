package com.cg.ama.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="assets")
public class AssetEntity {
	
	@Id
	@Column(name="asset_id", unique=true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long assetId;

	@ManyToOne
	@JoinColumn(name="wh_id")
	private WarehouseEntity warehouse;
	
	private String model;
	
	@Enumerated(EnumType.STRING)
	private AssetType type;
	
	private String manufacturer;

	
	public AssetEntity() {
		super();
	}
	
	
	public AssetEntity(Long assetId, WarehouseEntity warehouse, String model, AssetType type, String manufacturer) {
		super();
		this.assetId = assetId;
		this.warehouse = warehouse;
		this.model = model;
		this.type = type;
		this.manufacturer = manufacturer;
	}


	public AssetEntity(WarehouseEntity warehouse, String model, AssetType type, String manufacturer) {
		super();
		this.warehouse = warehouse;
		this.model = model;
		this.type = type;
		this.manufacturer = manufacturer;
	}

	public WarehouseEntity getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(WarehouseEntity warehouse) {
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
	public String toString() {
		return "AssetEntity [assetId=" + assetId + ", warehouse=" + warehouse + ", model=" + model + ", type=" + type
				+ ", manufacturer=" + manufacturer + "]";
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
		AssetEntity other = (AssetEntity) obj;
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
	
	
	
	
	
}
