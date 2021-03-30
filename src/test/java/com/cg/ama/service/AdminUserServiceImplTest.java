package com.cg.ama.service;

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
	@DisplayName("Get By Id")
	void testGetById() throws UserNotFoundException {
		UserEntity testdata = new UserEntity(1, "ADMIN", "12345", UserType.ADMIN);
		UserModel expected = new UserModel(1, "ADMIN", "12345", UserType.ADMIN);
		
		Mockito.when(userRepo.getOne(1L)).thenReturn(testdata);
		
		UserModel actual = service.getUserById(1L);
		Assertions.assertEquals(expected, actual);
	}
}