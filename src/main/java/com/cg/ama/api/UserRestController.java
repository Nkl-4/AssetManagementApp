package com.cg.ama.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ama.exception.AssetNotFoundException;
import com.cg.ama.exception.ShipmentNotFoundException;
import com.cg.ama.model.AssetModel;
import com.cg.ama.model.ShipmentModel;
import com.cg.ama.service.user.IUserAssetService;
import com.cg.ama.service.user.IUserShipmentService;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserRestController {
	
	@Autowired
	private IUserAssetService userAssetService;
	
	@Autowired
	private IUserShipmentService userShipmentService;

	// ---------------------------------------------- ASSET   -----------------------------------------------
	
	@GetMapping("/assets/get/{assetId}")
	public ResponseEntity<AssetModel> getAssetsById(@PathVariable("assetId") Long assetId) throws AssetNotFoundException {
		return ResponseEntity.ok(userAssetService.getAssetById(assetId));
	}
	
	@GetMapping("/assets/get/all")
	public ResponseEntity<List<AssetModel>> getAllAssets() throws AssetNotFoundException{
		return ResponseEntity.ok(userAssetService.getAssetList());
	}
	
	
			
	// ---------------------------------------------- SHIPMENT   -----------------------------------------------
		
	@GetMapping("/shipments/get/{shipmentId}")
	public ResponseEntity<ShipmentModel> getShipmentById(@PathVariable("shipmentId") Long shipmentId) throws ShipmentNotFoundException {
		return ResponseEntity.ok(userShipmentService.getShipmentById(shipmentId));
	}
		
	@GetMapping("/shipments/get/all")
	public ResponseEntity<List<ShipmentModel>> getAllShipments() throws ShipmentNotFoundException {
		return ResponseEntity.ok(userShipmentService.getShipments());
	}
		
		
}
