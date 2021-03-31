package com.cg.ama.model;

import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import com.cg.ama.entity.ShipmentStatus;


public class ShipmentModel {
	
	private Long shipmentId;
	
	@NotNull(message="Asset ID cannot be null")	
	private Long assetId;
	
	@NotNull(message="User ID cannot be null")	
	private Long userId;
	
	@Enumerated(EnumType.STRING)
	private ShipmentStatus status;
	
	@NotNull(message="Source Warehouse ID cannot be null")	
	private Long sourceWhId;
	
	@NotNull(message="Destination Warehouse ID cannot be null")	
	private Long destWhId;
	
	@PastOrPresent(message="Enter a valid date")
	@NotNull(message="Shipment Date cannot be null")	
	private LocalDate shipmentDate;
	
	private LocalDate deliveryDate;
	
	public ShipmentModel() {
		super();
	}

	
	public ShipmentModel(long shipmentId, long assetId, long userId, ShipmentStatus status, 
			long sourceWhId,long destWhId, LocalDate shipmentDate, LocalDate deliveryDate) {
		super();
		this.shipmentId = shipmentId;
		this.assetId = assetId;
		this.userId = userId;
		this.status = status;
		this.sourceWhId = sourceWhId;
		this.destWhId = destWhId;
		this.shipmentDate = shipmentDate;
		this.deliveryDate = deliveryDate;
	}


	public ShipmentModel(
			long assetId, long userId, ShipmentStatus status, long sourceWhId,long destWhId, 
			LocalDate shipmentDate, LocalDate deliveryDate) {
		super();
		this.assetId = assetId;
		this.userId = userId;
		this.status = status;
		this.sourceWhId = sourceWhId;
		this.destWhId = destWhId;
		this.shipmentDate = shipmentDate;
		this.deliveryDate = deliveryDate;
	}

	public Long getAssetId() {
		return assetId;
	}

	public void setAssetId(long assetId) {
		this.assetId = assetId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public ShipmentStatus getStatus() {
		return status;
	}

	public void setStatus(ShipmentStatus status) {
		this.status = status;
	}

	public Long getSourceWhId() {
		return sourceWhId;
	}

	public void setSourceWhId(long sourceWhId) {
		this.sourceWhId = sourceWhId;
	}

	public Long getDestWhId() {
		return destWhId;
	}

	public void setDestWhId(long destWhId) {
		this.destWhId = destWhId;
	}

	public LocalDate getShipmentDate() {
		return shipmentDate;
	}

	public void setShipmentDate(LocalDate shipmentDate) {
		this.shipmentDate = shipmentDate;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Long getShipmentId() {
		return shipmentId;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assetId == null) ? 0 : assetId.hashCode());
		result = prime * result + ((deliveryDate == null) ? 0 : deliveryDate.hashCode());
		result = prime * result + ((destWhId == null) ? 0 : destWhId.hashCode());
		result = prime * result + ((shipmentDate == null) ? 0 : shipmentDate.hashCode());
		result = prime * result + ((shipmentId == null) ? 0 : shipmentId.hashCode());
		result = prime * result + ((sourceWhId == null) ? 0 : sourceWhId.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		ShipmentModel other = (ShipmentModel) obj;
		if (assetId == null) {
			if (other.assetId != null)
				return false;
		} else if (!assetId.equals(other.assetId))
			return false;
		if (deliveryDate == null) {
			if (other.deliveryDate != null)
				return false;
		} else if (!deliveryDate.equals(other.deliveryDate))
			return false;
		if (destWhId == null) {
			if (other.destWhId != null)
				return false;
		} else if (!destWhId.equals(other.destWhId))
			return false;
		if (shipmentDate == null) {
			if (other.shipmentDate != null)
				return false;
		} else if (!shipmentDate.equals(other.shipmentDate))
			return false;
		if (shipmentId == null) {
			if (other.shipmentId != null)
				return false;
		} else if (!shipmentId.equals(other.shipmentId))
			return false;
		if (sourceWhId == null) {
			if (other.sourceWhId != null)
				return false;
		} else if (!sourceWhId.equals(other.sourceWhId))
			return false;
		if (status != other.status)
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "ShipmentModel [shipmentId=" + shipmentId + ", assetId=" + assetId + ", userId=" + userId + ", status="
				+ status + ", sourceWhId=" + sourceWhId + ", destWhId=" + destWhId + ", shipmentDate=" + shipmentDate
				+ ", deliveryDate=" + deliveryDate + "]";
	}


	

}
