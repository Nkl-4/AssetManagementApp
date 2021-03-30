package com.cg.ama.model;

import javax.validation.constraints.NotNull;

public class WarehouseModel {
	
	private long whId;
	
    @NotNull(message="Warehouse manager ID  cannot be omitted")
	private long mgrId;
	
    @NotNull(message="address  cannot be omitted")
	private AddressModel address;

	
	public WarehouseModel() {
		super();
	}


	public WarehouseModel(long whId, long mgrId, AddressModel address) {
		super();
		this.whId = whId;
		this.mgrId = mgrId;
		this.address = address;
	}

	public WarehouseModel(long mgrId, AddressModel address) {
		super();
		this.mgrId = mgrId;
		this.address = address;
	}

	public long getMgrId() {
		return mgrId;
	}

	public void setMgrId(long mgrId) {
		this.mgrId = mgrId;
	}

	public AddressModel getAddress() {
		return address;
	}

	public void setAddress(AddressModel address) {
		this.address = address;
	}

	public long getWhId() {
		return whId;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + (int) (mgrId ^ (mgrId >>> 32));
		result = prime * result + (int) (whId ^ (whId >>> 32));
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
		WarehouseModel other = (WarehouseModel) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (mgrId != other.mgrId)
			return false;
		if (whId != other.whId)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "WarehouseModel [whId=" + whId + ", mgrId=" + mgrId + ", address=" + address + "]";
	}
	
	
}
