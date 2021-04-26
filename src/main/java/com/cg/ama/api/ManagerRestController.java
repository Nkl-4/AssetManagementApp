package com.cg.ama.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ama.exception.AssetNotFoundException;
import com.cg.ama.exception.InvalidAssetDetailsException;
import com.cg.ama.exception.InvalidShipmentDetailsException;
import com.cg.ama.exception.ShipmentNotFoundException;
import com.cg.ama.exception.WarehouseNotFoundException;
import com.cg.ama.model.AssetModel;
import com.cg.ama.model.ShipmentModel;
import com.cg.ama.service.manager.IManagerAssetService;
import com.cg.ama.service.manager.IManagerShipmentService;
import com.cg.ama.service.report.IReportService;

@CrossOrigin
@RestController
@RequestMapping("/manager")
public class ManagerRestController {
		
	@Autowired
	private IManagerAssetService managerAssetService;
	
	@Autowired
	private IManagerShipmentService managerShipmentService;
	
		
	// ---------------------------------------------- ASSET   -----------------------------------------------
	
	@GetMapping("/assets/get/{assetId}")
	public ResponseEntity<AssetModel> getAssetsById(@PathVariable("assetId") Long assetId) throws AssetNotFoundException{
		return ResponseEntity.ok(managerAssetService.getAssetById(assetId));
	}
	
	@GetMapping("/assets/get/all")
	public ResponseEntity<List<AssetModel>> getAllAssets() throws AssetNotFoundException{
		return ResponseEntity.ok(managerAssetService.getAssetList());
	}
	
		
	@PutMapping("/assets/modify/{assetId}")
	public ResponseEntity<AssetModel> modifyAsset (
			@PathVariable("AssetId") Long userId,
			@RequestBody @Valid AssetModel assetModel,
			BindingResult result)  throws InvalidAssetDetailsException, AssetNotFoundException {
		
		if (result.hasErrors()) {
			throw new InvalidAssetDetailsException("Not Created");
		}
		
		return ResponseEntity.ok(managerAssetService.modifyAsset(userId, assetModel));
	}
	
		
	// ---------------------------------------------- SHIPMENT   -----------------------------------------------
		
	@GetMapping("/shipments/get/{shipmentId}")
	public ResponseEntity<ShipmentModel> getShipmentById(@PathVariable("shipmentId") Long shipmentId) throws ShipmentNotFoundException {
		return ResponseEntity.ok(managerShipmentService.getShipmentById(shipmentId));
	}
		
	@GetMapping("/shipments/get/all")
	public ResponseEntity<List<ShipmentModel>> getAllShipments() throws ShipmentNotFoundException {
		return ResponseEntity.ok(managerShipmentService.getShipments());
	}
		
		
	@PutMapping("/shipments/modify/{shipmentId}")
	public ResponseEntity<ShipmentModel> modifyShipment (
			@PathVariable("shipmentId") Long shipmentId,
			@RequestBody @Valid ShipmentModel shipmentModel,
			BindingResult result)  throws InvalidShipmentDetailsException, ShipmentNotFoundException {
		
		if (result.hasErrors()) {
			throw new InvalidShipmentDetailsException("Not Created");
		}
		
		return ResponseEntity.ok(managerShipmentService.modifyShipment(shipmentId, shipmentModel));
	}
	
	@GetMapping("/shipments/status/delivered")
	public ResponseEntity<String> setStatus(@RequestParam(name = "shipmentId") Long shipmentId) throws ShipmentNotFoundException  {
		return ResponseEntity.ok(managerShipmentService.modifyShipmentStatus(shipmentId));
	}
		
	// ------------------------------------------- REPORT --------------------------------------------------
	
	@Autowired
	IReportService reportService;
	
	@GetMapping("/shipments/report/month")
	public ResponseEntity<List<ShipmentModel>> getReport(@RequestParam(name = "month") int month, @RequestParam(name = "year") int year)  {
		return ResponseEntity.ok(reportService.getShipmentsByMonth(month, year));
	}
	
	@GetMapping("/shipments/report/week")
	public ResponseEntity<List<ShipmentModel>> getReportByWeek(
			@RequestParam(name = "week") int week,
			@RequestParam(name = "month") int month,
			@RequestParam(name = "year") int year)  {
		return ResponseEntity.ok(reportService.getShipmentsByWeek(week, month, year));
	}
	
	@GetMapping("/shipments/report/weekly")
	public ResponseEntity<List<ShipmentModel>> findAllByWeekly(){
		return ResponseEntity.ok(reportService.findAllByWeekly());
	}
	
	@GetMapping("/shipments/report/general/monthly")
	public ResponseEntity<List<ShipmentModel>> findAllByMonthly(){
		return ResponseEntity.ok(reportService.findAllByMonthly());
	}
	
	// --------------------------------------------- WAREHOUSE ------------------------------------------------
	
	@GetMapping("/warehouses/get/assets/{warehouseId}")
	public ResponseEntity<List<AssetModel>> getAllAssetsFromWarehouse(@PathVariable("warehouseId") Long warehouseId) throws WarehouseNotFoundException{
		return ResponseEntity.ok(managerAssetService.getAllAssets(warehouseId));
	}
	
}
