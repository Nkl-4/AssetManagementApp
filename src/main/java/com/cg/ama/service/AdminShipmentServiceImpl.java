package com.cg.ama.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ama.exception.DuplicateEntryException;
import com.cg.ama.exception.ShipmentNotFoundException;
import com.cg.ama.model.ShipmentModel;
import com.cg.ama.repo.ShipmentRepo;

@Service
public class AdminShipmentServiceImpl implements IAdminShipmentService {
	
	@Autowired
	private EMParser parser;
	
	@Autowired
	private ShipmentRepo shipmentRepo;
	
	@Override
	public ShipmentModel getShipmentById(Long shipmentId) throws ShipmentNotFoundException {
		if (!shipmentRepo.existsById(shipmentId)) {
			throw new ShipmentNotFoundException("No shipment present with the given ID");
		}
		return parser.parse((shipmentRepo.findById(shipmentId).orElse(null)));
	}

	@Transactional
	@Override
	public ShipmentModel addShipment(ShipmentModel shipmentModel) throws DuplicateEntryException {
		if(shipmentModel != null) {
			if (shipmentRepo.existsById(ShipmentModel.getshipmentId())) {
				throw new DuplicateEntryException("Shipment already present in DB.");
			}
			shipmentModel = parser.parse((shipmentRepo.save(parser.parse(shipmentModel))));
		}
		return shipmentModel;
	}

	@Override
	public List<ShipmentModel> getShipments() throws ShipmentNotFoundException {
		if (shipmentRepo.count() == 0) {
			throw new ShipmentNotFoundException("No Shipment present with the given ID");
		}
		return shipmentRepo.findAll().stream().map(parser::parse).collect(Collectors.toList());
	}
	
	@Transactional
	@Override
	public ShipmentModel modifyShipment(Long shipmentId, ShipmentModel shipmentModel) throws ShipmentNotFoundException {
		if(shipmentModel != null) {
			if (!shipmentRepo.existsById(shipmentId)) {
				throw new ShipmentNotFoundException("Shipment Not present in DB.");
			}
			shipmentModel = parser.parse((shipmentRepo.save(parser.parse(shipmentModel))));
		}
		return shipmentModel;
	}

	@Override
	public String deleteShipmentById(Long shipmentId) throws ShipmentNotFoundException {
		if (!shipmentRepo.existsById(shipmentId)) {
			throw new ShipmentNotFoundException("No Shipment present with the given ID");
		}
		shipmentRepo.deleteById(shipmentId);
		return "User Deleted";
	}



}
