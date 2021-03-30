package com.cg.ama.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AddressModel {
	
	@NotEmpty(message="Location cannot be empty")
    @NotNull(message="Location  cannot be omitted")
	private String location;
	
	@NotEmpty(message="subLocation cannot be empty")
    @NotNull(message="subLocation  cannot be omitted")
	private String subLocation;
	
	@NotEmpty(message="State cannot be empty")
    @NotNull(message="State cannot be omitted")
	private String state;
	
	@NotEmpty(message="Country cannot be empty")
    @NotNull(message="Country cannot be omitted")
	private String country;	
	
	public AddressModel() {
		super();
	}

	public AddressModel(String location, String subLocation, String state, String country) {
		super();
		this.location = location;
		this.subLocation = subLocation;
		this.state = state;
		this.country = country;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSubLocation() {
		return subLocation;
	}

	public void setSubLocation(String subLocation) {
		this.subLocation = subLocation;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((subLocation == null) ? 0 : subLocation.hashCode());
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
		AddressModel other = (AddressModel) obj;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (subLocation == null) {
			if (other.subLocation != null)
				return false;
		} else if (!subLocation.equals(other.subLocation))
			return false;
		return true;
	}
	
	
	
	
}
