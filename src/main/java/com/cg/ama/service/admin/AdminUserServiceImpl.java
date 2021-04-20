package com.cg.ama.service.admin;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ama.exception.DuplicateEntryException;
import com.cg.ama.exception.LoginFailedException;
import com.cg.ama.exception.UserNotFoundException;
import com.cg.ama.model.UserModel;
import com.cg.ama.repo.UserRepo;
import com.cg.ama.service.EMParser;


@Service
public class AdminUserServiceImpl implements IAdminUserService {

	@Autowired
	private EMParser parser;
	
	@Autowired
	private UserRepo userRepo;
	
	public AdminUserServiceImpl() {
		super();
	}

	public AdminUserServiceImpl(UserRepo userRepo) {
		super();
		this.parser = new EMParser();
		this.userRepo = userRepo;
	}

	@Override
	public UserModel getUserById(Long userId) throws UserNotFoundException {
		if (!userRepo.existsById(userId)) {
			throw new UserNotFoundException("No user present with the given ID");
		}
		return parser.parse((userRepo.findById(userId).get()));
	}
	
	@Transactional
	@Override
	public UserModel addUser(UserModel userModel) throws DuplicateEntryException {
		
		if(userModel != null) {
			if (userRepo.existsById(userModel.getUserId())) {
				throw new DuplicateEntryException("User already present in DB.");
			}
			userModel = parser.parse((userRepo.save(parser.parse(userModel))));
		}
		return userModel;
	}

	@Override
	public List<UserModel> getUsers()  {
		return userRepo.findAll().stream().map(parser::parse).collect(Collectors.toList());
	}

	@Override
	public String deleteUserById(Long userId) throws UserNotFoundException {
		if (!userRepo.existsById(userId)) {
			throw new UserNotFoundException("No user present with the given ID");
		}
		userRepo.deleteById(userId);
		return "User Deleted";
	}
	
	@Transactional
	@Override
	public UserModel modifyUser(Long userId, UserModel userModel) throws UserNotFoundException {
		if(userModel != null) {
			if (!userRepo.existsById(userId)) {
				throw new UserNotFoundException("User Not present in DB.");
			}			
		}
		
		UserModel user = parser.parse(userRepo.getOne(userId));
		user.setUserName(userModel.getUserName());
		user.setUserPassword(userModel.getUserPassword());
		user.setUserType(userModel.getUserType());
		return parser.parse(userRepo.save(parser.parse(user)));
				
	}

	@Override
	public UserModel userLogin(String userName, String userPass) throws LoginFailedException, UserNotFoundException{
		if(!userRepo.existsByUserName(userName)) {
			throw new UserNotFoundException("User Not present in DB.");
		}
		
		UserModel userFromDb = parser.parse(userRepo.findByUserName(userName));
		
		if(!userFromDb.getUserPassword().equals(userPass)) {
			throw new LoginFailedException("Username / Password is wrong.");
		}

		
		return userFromDb;
	}

}
