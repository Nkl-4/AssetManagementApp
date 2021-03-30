package com.cg.ama.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="shipments")
public class ShipmentEntity {
	
	@Id
	@Column(name="shipment_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long shipmentId;
	
	@Column(name="asset_id")
	private long assetId;
	
	@Column(name="user_id")
	private long userId;
	
	@Enumerated(EnumType.STRING)
	private ShipmentStatus status;
	
	@Column(name="source_wh_id")
	private long sourceWhId;
	
	@Column(name="dest_wh_id")
	private long destWhId;
	
	@Column(name="ship_date")
	private LocalDate shipmentDate;
	
	@Column(name="delivery_date")
	private LocalDate deliveryDate;

	
	public ShipmentEntity() {
		super();
	}
	
	
	public ShipmentEntity(long shipmentId, long assetId, long userId, ShipmentStatus status, long sourceWhId,
			long destWhId, LocalDate shipmentDate, LocalDate deliveryDate) {
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


	public ShipmentEntity(long assetId, long userId, ShipmentStatus status, long sourceWhId, long destWhId, LocalDate shipmentDate,
			LocalDate deliveryDate) {
		super();
		this.assetId = assetId;
		this.userId = userId;
		this.status = status;
		this.sourceWhId = sourceWhId;
		this.destWhId = destWhId;
		this.shipmentDate = shipmentDate;
		this.deliveryDate = deliveryDate;
	}

	public long getShipmentId() {
		return shipmentId;
	}

	public void setShipmentId(long shipmentId) {
		this.shipmentId = shipmentId;
	}

	public long getUserId() {
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

	public long getSourceWhId() {
		return sourceWhId;
	}

	public void setSourceWhId(long sourceWhId) {
		this.sourceWhId = sourceWhId;
	}

	public long getDestWhId() {
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

	public long getAssetId() {
		return assetId;
	}

	public void setAssetId(long assetId) {
		this.assetId = assetId;
	}


	@Override
	public String toString() {
		return "ShipmentEntity [shipmentId=" + shipmentId + ", assetId=" + assetId + ", userId=" + userId + ", status="
				+ status + ", sourceWhId=" + sourceWhId + ", destWhId=" + destWhId + ", shipmentDate=" + shipmentDate
				+ ", deliveryDate=" + deliveryDate + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (assetId ^ (assetId >>> 32));
		result = prime * result + ((deliveryDate == null) ? 0 : deliveryDate.hashCode());
		result = prime * result + (int) (destWhId ^ (destWhId >>> 32));
		result = prime * result + ((shipmentDate == null) ? 0 : shipmentDate.hashCode());
		result = prime * result + (int) (shipmentId ^ (shipmentId >>> 32));
		result = prime * result + (int) (sourceWhId ^ (sourceWhId >>> 32));
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + (int) (userId ^ (userId >>> 32));
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
		ShipmentEntity other = (ShipmentEntity) obj;
		if (assetId != other.assetId)
			return false;
		if (deliveryDate == null) {
			if (other.deliveryDate != null)
				return false;
		} else if (!deliveryDate.equals(other.deliveryDate))
			return false;
		if (destWhId != other.destWhId)
			return false;
		if (shipmentDate == null) {
			if (other.shipmentDate != null)
				return false;
		} else if (!shipmentDate.equals(other.shipmentDate))
			return false;
		if (shipmentId != other.shipmentId)
			return false;
		if (sourceWhId != other.sourceWhId)
			return false;
		if (status != other.status)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	
	
	
	
}
