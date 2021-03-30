package com.cg.ama.service;

import static org.junit.Assert.assertNull;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.cg.ama.entity.AddressEntity;
import com.cg.ama.entity.WarehouseEntity;
import com.cg.ama.exception.AssetNotFoundException;
import com.cg.ama.exception.WarehouseNotFoundException;
import com.cg.ama.model.AddressModel;
import com.cg.ama.model.WarehouseModel;
import com.cg.ama.repo.WarehouseRepo;
import com.cg.ama.service.admin.AdminWarehouseServiceImpl;

public class AdminWarehouseServiceImplTest {
	
//	@Mock
//	private WarehouseRepo warehouseRepo;
//
//	@InjectMocks
//	private AdminWarehouseServiceImpl service;
//	
//	@Test
//	@DisplayName("AdminWarehouseServiceImpl::getById should return an existing WarehouseModel given existing id")
//	void testgetAssetById() throws AssetNotFoundException, WarehouseNotFoundException {
//		
//		AddressEntity address=new AddressEntity("Chennai","Velacherry","Tamil Nadu","India");
//		AddressModel address1=new AddressModel("Chennai","Velacherry","Tamil Nadu","India");
//		
//		WarehouseEntity testdata=new WarehouseEntity(1L,1,address);
//		WarehouseModel expected=new WarehouseModel(1L,1,address1);
//
//		
//		Mockito.when(warehouseRepo.existsById(1L)).thenReturn(true);
//		Mockito.when(warehouseRepo.findById(1L)).thenReturn(Optional.of(testdata));
//		
//		WarehouseModel actual= service.getWareHouseById(1L);
//		Assertions.assertEquals(expected, actual);
//	}
//	
//	@Test
//	@DisplayName("AdminWarehouseServiceImpl::get by id return null")
//	void testGetByIdNull()  {		
//		
//		
//		WarehouseModel actual = null;
//		try {
//			actual = service.getWareHouseById(9L);
//		} catch (WarehouseNotFoundException e) {
//			e.printStackTrace();
//		}
//		assertNull(actual);
//	}
}
