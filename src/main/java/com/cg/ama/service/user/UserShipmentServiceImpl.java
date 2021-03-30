package com.cg.ama.service.user;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ama.exception.ShipmentNotFoundException;
import com.cg.ama.model.ShipmentModel;
import com.cg.ama.repo.ShipmentRepo;
import com.cg.ama.service.EMParser;


@Service
public class UserShipmentServiceImpl implements IUserShipmentService {

	@Autowired
	private EMParser parser;
	
	@Autowired
	private ShipmentRepo shipmentRepo;
	
	public UserShipmentServiceImpl() {
		super();
	}


	public UserShipmentServiceImpl(EMParser parser, ShipmentRepo shipmentRepo) {
		super();
		this.parser = parser;
		this.shipmentRepo = shipmentRepo;
	}


	@Override
	public ShipmentModel getShipmentById(Long shipmentId) throws ShipmentNotFoundException {
		if (!shipmentRepo.existsById(shipmentId)) {
			throw new ShipmentNotFoundException("No shipment present with the given ID");
		}
		return parser.parse((shipmentRepo.findById(shipmentId).orElse(null)));
	}


	@Override
	public List<ShipmentModel> getShipments() throws ShipmentNotFoundException {
		if (shipmentRepo.count() == 0) {
			throw new ShipmentNotFoundException("No Shipment present with the given ID");
		}
		return shipmentRepo.findAll().stream().map(parser::parse).collect(Collectors.toList());
	}

}
