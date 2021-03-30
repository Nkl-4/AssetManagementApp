package com.cg.ama.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.ama.entity.UserEntity;
import com.cg.ama.entity.UserType;
import com.cg.ama.exception.UserNotFoundException;
import com.cg.ama.model.UserModel;
import com.cg.ama.repo.UserRepo;
import com.cg.ama.service.admin.AdminUserServiceImpl;


@ExtendWith(MockitoExtension.class)
public class AdminUserServiceImplTest {
	
	@Mock
	private UserRepo userRepo;
	
	@InjectMocks
	private AdminUserServiceImpl service;
	
	
	@Test
	void testGetAll() throws UserNotFoundException {
		
		UserEntity user1 = new UserEntity(10L, "ADMIN", "12345", UserType.ADMIN);
		UserEntity user2 = new UserEntity(11L, "ADMIN", "12345", UserType.ADMIN);
		List<UserEntity> testdata = new ArrayList<UserEntity>();
		testdata.add(user1);
		testdata.add(user2);
		
		Mockito.when(userRepo.findAll()).thenReturn(testdata);
		
		
		UserModel user3 = new UserModel(10L, "ADMIN", "12345", UserType.ADMIN);
		UserModel user4 = new UserModel(11L, "ADMIN", "12345", UserType.ADMIN);
		List<UserModel> expected = new ArrayList<UserModel>();
		expected.add(user3);
		expected.add(user4);
		
		List<UserModel> actual = service.getUsers();
		
		assertEquals(expected, actual);
	}
	
//	@Test
//	@DisplayName("Get By Id")
//	void testGetById() throws UserNotFoundException {
//		UserEntity testdata = new UserEntity(1, "ADMIN", "12345", UserType.ADMIN);
//		UserModel expected = new UserModel(1, "ADMIN", "12345", UserType.ADMIN);
//		
//		Mockito.when(userRepo.findById(testdata.getUserId())).thenReturn(Optional.of(testdata));
//		
//		UserModel actual = service.getUserById(testdata.getUserId());
//		Assertions.assertEquals(expected, actual);
//	}
//	
	
	@Test
	@DisplayName("get by id return null")
	void testGetByIdNull()  {		
		
		UserModel actual = null;
		try {
			actual = service.getUserById(9L);
		} catch (UserNotFoundException e) {
		}
		assertNull(actual);
	}
	
}