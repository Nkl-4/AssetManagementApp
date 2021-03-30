package com.cg.ama.service;

import static org.junit.Assert.assertNull;

import java.util.Arrays;
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

import com.cg.ama.entity.AddressEntity;
import com.cg.ama.entity.AssetEntity;
import com.cg.ama.entity.AssetType;
import com.cg.ama.entity.WarehouseEntity;
import com.cg.ama.exception.AssetNotFoundException;
import com.cg.ama.model.AddressModel;
import com.cg.ama.model.AssetModel;
import com.cg.ama.model.WarehouseModel;
import com.cg.ama.repo.AssetRepo;
import com.cg.ama.service.user.UserAssetServiceImpl;

@ExtendWith(MockitoExtension.class)
public class UserAssetServiceImplTest {
	
	@Mock
	private AssetRepo assetRepo;

	@InjectMocks
	private UserAssetServiceImpl service;
	
	@Test
	@DisplayName("UserAssetServiceImpl::getById should return an existing AssetModel given existing id")
	void testgetAssetById() throws AssetNotFoundException {
		
		AddressEntity address=new AddressEntity("Chennai","Velacherry","Tamil Nadu","India");
		AddressModel address1=new AddressModel("Chennai","Velacherry","Tamil Nadu","India");
		
		WarehouseEntity warehouse=new WarehouseEntity(1,1,address);
		WarehouseModel warehouse1=new WarehouseModel(1,1,address1);

		
		AssetEntity testdata = new AssetEntity(1L,warehouse,"SM-1",AssetType.SOFTWARE,"SAMSUNG");
		AssetModel expected = new AssetModel(1L,warehouse1,"SM-1", AssetType.SOFTWARE,"SAMSUNG");
		
		Mockito.when(assetRepo.existsById(1L)).thenReturn(true);
		Mockito.when(assetRepo.findById(1L)).thenReturn(Optional.of(testdata));
		
		AssetModel actual= service.getAssetById(1L);
		Assertions.assertEquals(expected, actual);
	}

	@Test
	@DisplayName("UserServiceImpl::get by id return null")
	void testGetByIdNull()  {		
		
		AssetModel actual = null;
		try {
			actual = service.getAssetById(9L);
		} catch (AssetNotFoundException e) {
		}
		assertNull(actual);
	}
	
	@Test
	@DisplayName("Asset Details should retrive")
	void testgetAllAssets() throws AssetNotFoundException {
		
		AddressEntity address=new AddressEntity("Chennai","Velacherry","Tamil Nadu","India");
		AddressModel address1=new AddressModel("Chennai","Velacherry","Tamil Nadu","India");
		
		WarehouseEntity warehouse=new WarehouseEntity(1,1,address);
		WarehouseModel warehouse1=new WarehouseModel(1,1,address1);

			List<AssetEntity> testdata= Arrays.asList(new AssetEntity[] {
				new AssetEntity(1L,warehouse,"SM-1",AssetType.SOFTWARE,"SAMSUNG"),
				new AssetEntity(2L,warehouse,"SM-3",AssetType.SOFTWARE,"IPHONE")
		});
		
		Mockito.when(assetRepo.findAll()).thenReturn(testdata);
		
		
		List<AssetModel> expected=Arrays.asList(new AssetModel[] {
				new AssetModel(1L,warehouse1,"SM-1",AssetType.SOFTWARE,"SAMSUNG"),
				new AssetModel(2L,warehouse1,"SM-3",AssetType.SOFTWARE,"IPHONE")
		});
		
		List<AssetModel> actual = service.getAssetList();
		
		Assertions.assertEquals(expected,actual);
		

	}
	
}
