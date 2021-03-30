package com.cg.ama.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
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

import com.cg.ama.entity.ShipmentEntity;
import com.cg.ama.entity.ShipmentStatus;
import com.cg.ama.exception.DuplicateEntryException;
import com.cg.ama.exception.ShipmentNotFoundException;
import com.cg.ama.model.ShipmentModel;
import com.cg.ama.repo.ShipmentRepo;
import com.cg.ama.service.admin.AdminShipmentServiceImpl;

@ExtendWith(MockitoExtension.class)
public class AdminShipmentServiceImplTest {
	
	@Mock
	private ShipmentRepo adminshipmentrepo;

	@InjectMocks
	private AdminShipmentServiceImpl asImpl;
	
	
	
	@Test
	@DisplayName("AdminShipmentServiceImpl::getById should return an existing ShipmentModel given existing id")
	void testgetAssetById() throws ShipmentNotFoundException {
		
		ShipmentEntity testdata = new ShipmentEntity(1L,1L,1L,ShipmentStatus.DISPATCHED,3L,1L,LocalDate.parse("2021-09-01"),LocalDate.parse("2021-08-27"));
		ShipmentModel expected = new ShipmentModel(1L,1L,1L,ShipmentStatus.DISPATCHED,3L,1L,LocalDate.parse("2021-09-01"),LocalDate.parse("2021-08-27"));
		
		Mockito.when(adminshipmentrepo.existsById(testdata.getAssetId())).thenReturn(false);
		Mockito.when(adminshipmentrepo.findById(testdata.getAssetId())).thenReturn(Optional.of(testdata));
				
		ShipmentModel actual=asImpl.getShipmentById(testdata.getShipmentId());
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("AdminShipmentServiceImpl::adding shipment should be done")
	void testAddShipment() throws DuplicateEntryException, ShipmentNotFoundException  {
		
		
		ShipmentEntity testdata = new ShipmentEntity(1L,1L,1L,ShipmentStatus.DISPATCHED,3L,1L,LocalDate.parse("2021-09-01"),LocalDate.parse("2021-08-27"));
		ShipmentModel expected = new ShipmentModel(1L,1L,1L,"DISPATCHED",3L,1L,LocalDate.parse("2021-09-01"),LocalDate.parse("2021-08-27"));
		
		Mockito.when(adminshipmentrepo.existsById(testdata.getShipmentId())).thenReturn(false);
//		existsById(testdata.getAssetId())).thenReturn(false);
		Mockito.when(adminshipmentrepo.findById(testdata.getAssetId())).thenReturn(Optional.of(testdata));
				
		ShipmentModel actual=asImpl.addShipment(asImpl.getShipmentById(testdata.getShipmentId()));
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("AdminShipmentServiceImpl::modify shipment should be done")
	void testModifyShipment() throws ShipmentNotFoundException {
		
		ShipmentEntity testdata = new ShipmentEntity(1L,1L,1L,ShipmentStatus.DISPATCHED,3L,1L,LocalDate.parse("2021-09-01"),LocalDate.parse("2021-08-27"));
		ShipmentModel expected = new ShipmentModel(1L,1L,1L,"DISPATCHED",3L,1L,LocalDate.parse("2021-09-01"),LocalDate.parse("2021-08-27"));
		
		Mockito.when(adminshipmentrepo.existsById(testdata.getShipmentId())).thenReturn(false);
//		existsById(testdata.getAssetId())).thenReturn(false);
		Mockito.when(adminshipmentrepo.findById(testdata.getAssetId())).thenReturn(Optional.of(testdata));
				
		ShipmentModel actual=asImpl.modifyShipment(testdata.getShipmentId(), expected);
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("Shipment Details should retrive")
	void testgetAllAsset() throws ShipmentNotFoundException {
		
		List<ShipmentEntity> testdata=Arrays.asList(new ShipmentEntity[] {
				new ShipmentEntity(1L,1L,1L,ShipmentStatus.DISPATCHED,3L,1L,LocalDate.parse("2021-09-01"),LocalDate.parse("2021-08-27")),
				new ShipmentEntity(23L,2L,206L,ShipmentStatus.SHIPPED,907L,501L,LocalDate.parse("2021-04-12"),LocalDate.parse("2021-05-23"))
		});
		
		Mockito.when(adminshipmentrepo.findAll()).thenReturn(testdata);
		
		List<ShipmentModel> expected=Arrays.asList(new ShipmentModel[] {
				new ShipmentModel(1L,1L,1L,"DISPATCHED",3L,1L,LocalDate.parse("2021-09-01"),LocalDate.parse("2021-08-27")),
				new ShipmentModel(23L,2L,206L,"SHIPPED",907L,501L,LocalDate.parse("2021-04-12"),LocalDate.parse("2021-05-23"))
		});
		
		List<ShipmentModel> actual = asImpl.getShipments();
		
		Assertions.assertEquals(expected,actual);

	}
	
	@Test
	@DisplayName("AdminShipmentServiceImpl::delete shipment should be done")
	void testDeleteShipment() throws ShipmentNotFoundException {
		
		ShipmentEntity testdata = new ShipmentEntity(1L,1L,1L,ShipmentStatus.DISPATCHED,3L,1L,LocalDate.parse("2021-09-01"),LocalDate.parse("2021-08-27"));
		ShipmentModel expected = new ShipmentModel(1L,1L,1L,"DISPATCHED",3L,1L,LocalDate.parse("2021-09-01"),LocalDate.parse("2021-08-27"));
		
		Mockito.when(adminshipmentrepo.existsById(testdata.getShipmentId())).thenReturn(false);
//		existsById(testdata.getAssetId())).thenReturn(false);
		Mockito.when(adminshipmentrepo.findById(testdata.getAssetId())).thenReturn(Optional.of(testdata));
				
		String actual=asImpl.deleteShipmentById(testdata.getShipmentId());
		Assertions.assertEquals(expected, actual);
	}
		
		
		
}
