package com.cg.ama.service.manager;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ama.exception.ShipmentNotFoundException;
import com.cg.ama.model.ShipmentModel;
import com.cg.ama.repo.ShipmentRepo;
import com.cg.ama.service.EMParser;


@Service
public class ManagerShipmentServiceImpl implements IManagerShipmentService {
	
	@Autowired
	private EMParser parser;
	
	@Autowired
	private ShipmentRepo shipmentRepo;
	
	public ManagerShipmentServiceImpl() {
		super();
	}


	public ManagerShipmentServiceImpl(ShipmentRepo shipmentRepo) {
		super();
		this.parser = new EMParser();
		this.shipmentRepo = shipmentRepo;
	}

	//to get shipment by id
	@Override
	public ShipmentModel getShipmentById(Long shipmentId) throws ShipmentNotFoundException {
		if (!shipmentRepo.existsById(shipmentId)) {
			//if id not present
			throw new ShipmentNotFoundException("No shipment present with the given ID");
		}
		//if id present
		return parser.parse((shipmentRepo.findById(shipmentId).orElse(null)));
	}

	// to display all shipments
	@Override
	public List<ShipmentModel> getShipments() {
		return shipmentRepo.findAll().stream().map(parser::parse).collect(Collectors.toList());
	}
	
	//to modify shipments
	@Override
	public ShipmentModel modifyShipment(Long shipmentId, ShipmentModel shipmentModel) throws ShipmentNotFoundException {
		if(shipmentModel != null) {
			//if id not present
			if (!shipmentRepo.existsById(shipmentId)) {
				throw new ShipmentNotFoundException("Shipment Not present in DB.");
			}
			//if id present
			shipmentModel = parser.parse((shipmentRepo.save(parser.parse(shipmentModel))));
		}
		return shipmentModel;
	}

	//to update the shipment status
	@Override
	public String modifyShipmentStatus(Long shipmentId) throws ShipmentNotFoundException {
		if (!shipmentRepo.existsById(shipmentId)) {
			//if id not present
			throw new ShipmentNotFoundException("No Shipment present with the given ID");
		}
		//if id present
		shipmentRepo.setDeliveryStatus(shipmentId);;
		return "Shipment Status set to DELIVERED";
	}




}
