package com.cg.ama.entity;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class AddressEntity {
	
	@NotNull
	@Size(max=50)
	private String location;
	
	@Size(max=50)
	private String subLocation;
	
	@NotNull
	@Size(max=50)
	private String state;
	
	@NotNull
	@Size(max=50)
	private String country;

	public AddressEntity() {
		super();
	}

	public AddressEntity(String location, String subLocation, String state, String country) {
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
	public String toString() {
		return "AddressEntity [location=" + location + ", subLocation=" + subLocation + ", state=" + state
				+ ", country=" + country + "]";
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
		AddressEntity other = (AddressEntity) obj;
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
