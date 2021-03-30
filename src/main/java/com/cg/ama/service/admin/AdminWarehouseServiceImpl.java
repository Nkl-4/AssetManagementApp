package com.cg.ama.service.admin;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ama.exception.DuplicateEntryException;
import com.cg.ama.exception.WarehouseNotFoundException;
import com.cg.ama.model.AssetModel;
import com.cg.ama.model.WarehouseModel;
import com.cg.ama.repo.AssetRepo;
import com.cg.ama.repo.WarehouseRepo;
import com.cg.ama.service.EMParser;


@Service
public class AdminWarehouseServiceImpl implements IAdminWarehouseService {
	
	@Autowired
	private EMParser parser;
	
	@Autowired
	private WarehouseRepo warehouseRepo;
	
	@Autowired
	private AssetRepo assetRepo;
	
	public AdminWarehouseServiceImpl() {
		super();
		this.parser = new EMParser();
	}

	public AdminWarehouseServiceImpl(WarehouseRepo warehouseRepo) {
		super();
		this.parser = new EMParser();
		this.warehouseRepo = warehouseRepo;
	}

	@Override
	public WarehouseModel getWareHouseById(Long warehouseId) throws WarehouseNotFoundException {
		if (!warehouseRepo.existsById(warehouseId)) {
			throw new WarehouseNotFoundException("No Warehouse present with the given ID");
		}
		return parser.parse((warehouseRepo.findById(warehouseId).orElse(null)));
	}
	
	@Transactional
	@Override
	public WarehouseModel addWarehouse(WarehouseModel wareHouseModel) throws DuplicateEntryException {
		if(wareHouseModel != null) {
			if (warehouseRepo.existsById(wareHouseModel.getWhId())) {
				throw new DuplicateEntryException("Warehouse already present in DB.");
			}
			wareHouseModel = parser.parse((warehouseRepo.save(parser.parse(wareHouseModel))));
		}
		return wareHouseModel;
	}

	@Override
	public List<WarehouseModel> getWarehouseList() {
		return warehouseRepo.findAll().stream().map(parser::parse).collect(Collectors.toList());
	}
	
	@Transactional
	@Override
	public WarehouseModel modifyWarehouse(Long warehouseId, WarehouseModel wareHouseModel)
			throws WarehouseNotFoundException {
		if(wareHouseModel != null) {
			if (!warehouseRepo.existsById(warehouseId)) {
				throw new WarehouseNotFoundException("Warehouse Not present in DB.");
			}
			wareHouseModel = parser.parse((warehouseRepo.save(parser.parse(wareHouseModel))));
		}
		return wareHouseModel;
	}

	@Override
	public String deleteWarehouseById(Long warehouseId) throws WarehouseNotFoundException {
		if (!warehouseRepo.existsById(warehouseId)) {
			throw new WarehouseNotFoundException("No Warehouse present with the given ID");
		}
		warehouseRepo.deleteById(warehouseId);
		return "Warehouse Deleted";
	}

	@Override
	public List<AssetModel> getAllAssets(Long warehouseId) throws WarehouseNotFoundException {
		if (!warehouseRepo.existsById(warehouseId)) {
			throw new WarehouseNotFoundException("No Warehouse present with the given ID");
		}
		return assetRepo.getAssetsInWarehouse(warehouseId).stream().map(parser::parse).collect(Collectors.toList());
	}


}
