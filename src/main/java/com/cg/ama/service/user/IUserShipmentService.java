package com.cg.ama.service.user;

import java.util.List;

import com.cg.ama.exception.ShipmentNotFoundException;
import com.cg.ama.model.ShipmentModel;

public interface IUserShipmentService {
	
	ShipmentModel getShipmentById(Long shipmentId) throws ShipmentNotFoundException;
	List<ShipmentModel> getShipments();
	
}
