package com.cg.ama.service.manager;

import java.util.List;

import com.cg.ama.exception.ShipmentNotFoundException;
import com.cg.ama.model.ShipmentModel;

public interface IManagerShipmentService {
	
	ShipmentModel getShipmentById(Long shipmentId) throws ShipmentNotFoundException;
	
	List<ShipmentModel> getShipments();
	
	ShipmentModel modifyShipment(Long shipmentId, ShipmentModel shipmentModel) throws ShipmentNotFoundException;
	
	String modifyShipmentStatus(Long shipmentId) throws ShipmentNotFoundException;

}
