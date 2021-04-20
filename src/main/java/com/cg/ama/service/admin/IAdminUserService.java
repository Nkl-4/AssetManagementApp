package com.cg.ama.service.admin;

import java.util.List;

import com.cg.ama.exception.DuplicateEntryException;
import com.cg.ama.exception.LoginFailedException;
import com.cg.ama.exception.UserNotFoundException;
import com.cg.ama.model.UserModel;

public interface IAdminUserService {
	
	UserModel getUserById(Long userId) throws UserNotFoundException;
	
	UserModel addUser(UserModel userModel) throws DuplicateEntryException;
	
	List<UserModel> getUsers();
	
	UserModel modifyUser(Long userId, UserModel userModel) throws UserNotFoundException;
	
	String deleteUserById(Long userId) throws UserNotFoundException;
	
	UserModel userLogin(String userId, String userPass) throws LoginFailedException, UserNotFoundException;
}
