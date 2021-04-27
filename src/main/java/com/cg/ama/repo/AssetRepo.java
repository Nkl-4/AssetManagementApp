package com.cg.ama.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.ama.entity.AssetEntity;

@Repository
public interface AssetRepo extends JpaRepository<AssetEntity, Long>{
	
	//Lists all assets in a particular warehouse
	@Query(value = "select * from assets where wh_id = :warehouseId", nativeQuery = true)
	List<AssetEntity> getAssetsInWarehouse(@Param("warehouseId") Long warehouseId); 
}
