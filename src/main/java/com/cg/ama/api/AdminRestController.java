package com.cg.ama.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ama.exception.AssetNotFoundException;
import com.cg.ama.exception.DuplicateEntryException;
import com.cg.ama.exception.InvalidAssetDetailsException;
import com.cg.ama.exception.InvalidShipmentDetailsException;
import com.cg.ama.exception.InvalidUserDetailsException;
import com.cg.ama.exception.InvalidWarehouseDetailsException;
import com.cg.ama.exception.ShipmentNotFoundException;
import com.cg.ama.exception.UserNotFoundException;
import com.cg.ama.exception.WarehouseNotFoundException;
import com.cg.ama.model.AssetModel;
import com.cg.ama.model.ShipmentModel;
import com.cg.ama.model.UserModel;
import com.cg.ama.model.WarehouseModel;
import com.cg.ama.service.admin.IAdminAssetService;
import com.cg.ama.service.admin.IAdminShipmentService;
import com.cg.ama.service.admin.IAdminUserService;
import com.cg.ama.service.admin.IAdminWarehouseService;
import com.cg.ama.service.report.IReportService;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminRestController {
	
	@Autowired
	private IAdminUserService adminUserService;
	
	@Autowired
	private IAdminAssetService adminAssetService;
	
	@Autowired
	private IAdminShipmentService adminShipmentService;
	
	@Autowired
	private IAdminWarehouseService adminWarehouseService;
	
	
	// --------------------------------------  USERS -------------------------------------------------
	
	@GetMapping("/users/get/{userId}")
	public ResponseEntity<UserModel> getUsersById(@PathVariable("userId") Long userId) throws UserNotFoundException{
		return ResponseEntity.ok(adminUserService.getUserById((userId)));
	}
	
	@GetMapping("/users/get/all")
	public ResponseEntity<List<UserModel>> getAllUsers() throws UserNotFoundException{
		return ResponseEntity.ok(adminUserService.getUsers());
	}
	
	@PostMapping("/users")
	public ResponseEntity<String> createUser(@RequestBody @Valid UserModel userModel, BindingResult result) throws InvalidUserDetailsException, DuplicateEntryException {
		
		if (result.hasErrors()) {
			throw new InvalidUserDetailsException("Not Created");
		}
		UserModel userModel1 = adminUserService.addUser(userModel);
		return new ResponseEntity<String>("User "+ userModel1.getUserId() +" Created", HttpStatus.CREATED);
	}
	
	@PutMapping("/users/modify/{userId}")
	public ResponseEntity<UserModel> modifyUser(
			@PathVariable("userId") Long userId,
			@RequestBody @Valid UserModel userModel,
			BindingResult result)  throws InvalidUserDetailsException, UserNotFoundException {
		
		if (result.hasErrors()) {
			throw new InvalidUserDetailsException("Not Created");
		}
		
		return ResponseEntity.ok(adminUserService.modifyUser(userId, userModel));
	}
			
	@DeleteMapping("/users/delete/{userId}")
	public ResponseEntity<String> deleteUserById(@PathVariable("userId") Long userId) throws UserNotFoundException {
		return ResponseEntity.ok(adminUserService.deleteUserById(userId));
	}
	
	// ---------------------------------------------- ASSET   -----------------------------------------------
	
	@GetMapping("/assets/get/{assetId}")
	public ResponseEntity<AssetModel> getAssetsById(@PathVariable("assetId") Long assetId) throws AssetNotFoundException{
		return ResponseEntity.ok(adminAssetService.getAssetById((assetId)));
	}
	
	@GetMapping("/assets/get/all")
	public ResponseEntity<List<AssetModel>> getAllAssets() throws AssetNotFoundException{
		return ResponseEntity.ok(adminAssetService.getAssetList());
	}
	
	@PostMapping("/assets")
	public ResponseEntity<AssetModel> createAsset(
			@RequestBody @Valid AssetModel assetModel,
			BindingResult result) throws InvalidAssetDetailsException, DuplicateEntryException {
		
		if (result.hasErrors()) {
			throw new InvalidAssetDetailsException("Not Created");
		}
		
		return ResponseEntity.ok(adminAssetService.addAsset(assetModel));
	}
	
	@PutMapping("/assets/modify/{assetId}")
	public ResponseEntity<AssetModel> modifyAsset (
			@PathVariable("assetId") Long assetId,
			@RequestBody @Valid AssetModel assetModel,
			BindingResult result)  throws InvalidAssetDetailsException, AssetNotFoundException {
		
		if (result.hasErrors()) {
			throw new InvalidAssetDetailsException("Not Created");
		}
		
		return ResponseEntity.ok(adminAssetService.modifyAsset(assetId, assetModel));
	}
	
	@DeleteMapping("/assets/delete/{assetId}")
	public ResponseEntity<String> deleteAssetById(@PathVariable("assetId") Long assetId) throws AssetNotFoundException {
		return ResponseEntity.ok(adminAssetService.deleteAssetById(assetId));
	}
	
	// ---------------------------------------------- WAREHOUSE   -----------------------------------------------
	
	@GetMapping("/warehouses/get/{warehouseId}")
	public ResponseEntity<WarehouseModel> getWarehouseById(@PathVariable("warehouseId") Long warehouseId) throws WarehouseNotFoundException{
		return ResponseEntity.ok(adminWarehouseService.getWareHouseById(warehouseId));
	}
	
	@GetMapping("/warehouses/get/all")
	public ResponseEntity<List<WarehouseModel>> getAllWarehouses() throws WarehouseNotFoundException{
		return ResponseEntity.ok(adminWarehouseService.getWarehouseList());
	}
	
	@PostMapping("/warehouses")
	public ResponseEntity<WarehouseModel> createWarehouse(@RequestBody @Valid WarehouseModel warehouseModel, BindingResult result) throws InvalidWarehouseDetailsException, DuplicateEntryException {
		
		if (result.hasErrors()) {
			throw new InvalidWarehouseDetailsException("Not Created");
		}
		
		return ResponseEntity.ok(adminWarehouseService.addWarehouse(warehouseModel));
	}
	
	@GetMapping("/warehouses/get/assets/{warehouseId}")
	public ResponseEntity<List<AssetModel>> getAllAssetsFromWarehouse(@PathVariable("warehouseId") Long warehouseId) throws WarehouseNotFoundException{
		return ResponseEntity.ok(adminWarehouseService.getAllAssets(warehouseId));
	}
	
	@PutMapping("/warehouses/modify/{warehouseId}")
	public ResponseEntity<WarehouseModel> modifyAsset (
			@PathVariable("warehouseId") Long warehouseId,
			@RequestBody @Valid WarehouseModel warehouseModel,
			BindingResult result)  throws InvalidWarehouseDetailsException, WarehouseNotFoundException {
		
		if (result.hasErrors()) {
			throw new InvalidWarehouseDetailsException("Not Created");
		}
		
		return ResponseEntity.ok(adminWarehouseService.modifyWarehouse(warehouseId, warehouseModel));
	}
	
	@DeleteMapping("/warehouses/delete/{warehouseId}")
	public ResponseEntity<String> deleteWarehouseById(@PathVariable("warehouseId") Long warehouseId) throws WarehouseNotFoundException {
		return ResponseEntity.ok(adminWarehouseService.deleteWarehouseById(warehouseId));
	}
		
	// ---------------------------------------------- SHIPMENT   -----------------------------------------------
		
	@GetMapping("/shipments/get/{shipmentId}")
	public ResponseEntity<ShipmentModel> getShipmentById(@PathVariable("shipmentId") Long shipmentId) throws ShipmentNotFoundException {
		return ResponseEntity.ok(adminShipmentService.getShipmentById(shipmentId));
	}
		
	@GetMapping("/shipments/get/all")
	public ResponseEntity<List<ShipmentModel>> getAllShipments() throws ShipmentNotFoundException {
		return ResponseEntity.ok(adminShipmentService.getShipments());
	}
		
	@PostMapping("/shipments")
	public ResponseEntity<ShipmentModel> createShipment(@RequestBody @Valid ShipmentModel shipmentModel, BindingResult result) throws InvalidShipmentDetailsException
							, DuplicateEntryException, AssetNotFoundException, WarehouseNotFoundException {
			
		if (result.hasErrors()) {
			throw new InvalidShipmentDetailsException("Not Created");
		}
			
		return ResponseEntity.ok(adminShipmentService.addShipment(shipmentModel));
	}
	
	@PutMapping("/shipments/modify/{shipmentId}")
	public ResponseEntity<ShipmentModel> modifyShipment (
			@PathVariable("shipmentId") Long shipmentId,
			@RequestBody @Valid ShipmentModel shipmentModel,
			BindingResult result)  throws InvalidShipmentDetailsException, ShipmentNotFoundException {
		
		if (result.hasErrors()) {
			throw new InvalidShipmentDetailsException("Not Created");
		}
		
		return ResponseEntity.ok(adminShipmentService.modifyShipment(shipmentId, shipmentModel));
	}
		
	@DeleteMapping("/shipments/delete/{shipmentId}")
	public ResponseEntity<String> deleteShipmentById(@PathVariable("shipmentId") Long shipmentId) throws ShipmentNotFoundException {
		return ResponseEntity.ok(adminShipmentService.deleteShipmentById(shipmentId));
						
	}
	
	@GetMapping("/shipments/status/delivered")
	public ResponseEntity<String> setStatus(@RequestParam(name = "shipmentId") Long shipmentId) throws ShipmentNotFoundException  {
		return ResponseEntity.ok(adminShipmentService.modifyShipmentStatus(shipmentId));
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
	
	@GetMapping("/shipments/report/general/weekly")
	public ResponseEntity<List<ShipmentModel>> findAllByWeekly(){
		return ResponseEntity.ok(reportService.findAllByWeekly());
	}
	
	@GetMapping("/shipments/report/general/monthly")
	public ResponseEntity<List<ShipmentModel>> findAllByMonthly(){
		return ResponseEntity.ok(reportService.findAllByMonthly());
	}
	
	
}
