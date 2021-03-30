package com.cg.ama.model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.cg.ama.entity.UserType;

public class UserModel {
	
	private long userId;
	
	@NotNull(message="user name cannot be null")	
	@NotBlank(message="user name cannot be blank")
	private String userName;
	
	@NotNull(message="user password cannot be null")	
	@NotBlank(message="user password cannot be blank")
	private String userPassword;
	
	@Enumerated(EnumType.STRING)
	private UserType userType;

	public UserModel() {
		super();
	}
	
	
	public UserModel(long userId, String userName, String userPassword, UserType userType) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userType = userType;
	}


	public UserModel( String userName, String userPassword, UserType userType) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.userType = userType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
//	@JsonIgnore
	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public long getUserId() {
		return userId;
	}

	@Override
	public String toString() {
		return "UserModel [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword
				+ ", userType=" + userType + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (userId ^ (userId >>> 32));
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((userPassword == null) ? 0 : userPassword.hashCode());
		result = prime * result + ((userType == null) ? 0 : userType.hashCode());
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
		UserModel other = (UserModel) obj;
		if (userId != other.userId)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (userPassword == null) {
			if (other.userPassword != null)
				return false;
		} else if (!userPassword.equals(other.userPassword))
			return false;
		if (userType != other.userType)
			return false;
		return true;
	}

	
}
