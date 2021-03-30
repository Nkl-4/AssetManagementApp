package com.cg.ama.service;

import static org.junit.Assert.assertNull;
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
import com.cg.ama.exception.ShipmentNotFoundException;
import com.cg.ama.model.ShipmentModel;
import com.cg.ama.repo.ShipmentRepo;
import com.cg.ama.service.manager.ManagerShipmentServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ManagerShipmentServiceImplTest {
	
	@Mock
	private ShipmentRepo shipmentRepo;

	@InjectMocks
	private ManagerShipmentServiceImpl service;
	
	
	@Test
	@DisplayName("Shipment Details should retrive")
	void testgetAllAsset() throws ShipmentNotFoundException {
		
		List<ShipmentEntity> testdata=Arrays.asList(new ShipmentEntity[] {
				new ShipmentEntity(1L,1L,1L,ShipmentStatus.DISPATCHED,3L,1L,LocalDate.parse("2021-09-01"),LocalDate.parse("2021-08-27")),
				new ShipmentEntity(23L,2L,206L,ShipmentStatus.DISPATCHED,907L,501L,LocalDate.parse("2021-04-12"),LocalDate.parse("2021-05-23"))
		});
		
		Mockito.when(shipmentRepo.findAll()).thenReturn(testdata);
		
		List<ShipmentModel> expected=Arrays.asList(new ShipmentModel[] {
				new ShipmentModel(1L,1L,1L,ShipmentStatus.DISPATCHED,3L,1L,LocalDate.parse("2021-09-01"),LocalDate.parse("2021-08-27")),
				new ShipmentModel(23L,2L,206L,ShipmentStatus.DISPATCHED,907L,501L,LocalDate.parse("2021-04-12"),LocalDate.parse("2021-05-23"))
		});
		
		List<ShipmentModel> actual = service.getShipments();
		
		assertEquals(expected, actual);

	}
	
	@Test
	@DisplayName("ManagementShipmentServiceImpl::get by id return null")
	void testGetByIdNull()  {		
		
		
		ShipmentModel actual = null;
		try {
			actual = service.getShipmentById(9L);
		} catch (ShipmentNotFoundException e) {
		}
		assertNull(actual);
	}
		
	@Test
	@DisplayName("ManagerShipmentServiceImpl::getById should return an existing ShipmentModel given existing id")
	void testgetShipmentById() throws ShipmentNotFoundException {
		
		ShipmentEntity testdata = new ShipmentEntity(1L,1L,1L,ShipmentStatus.DISPATCHED,3L,1L,LocalDate.parse("2021-09-01"),LocalDate.parse("2021-08-27"));
		ShipmentModel expected = new ShipmentModel(1L,1L,1L,ShipmentStatus.DISPATCHED,3L,1L,LocalDate.parse("2021-09-01"),LocalDate.parse("2021-08-27"));
		
		Mockito.when(shipmentRepo.existsById(testdata.getAssetId())).thenReturn(true);
		Mockito.when(shipmentRepo.findById(testdata.getAssetId())).thenReturn(Optional.of(testdata));
				
		ShipmentModel actual= service.getShipmentById(testdata.getShipmentId());
		Assertions.assertEquals(expected, actual);
	}
		
		
}
