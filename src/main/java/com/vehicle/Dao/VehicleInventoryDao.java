package com.vehicle.Dao;

import com.vehicle.Entity.VehicleInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VehicleInventoryDao extends JpaRepository<VehicleInventory, String> {

    public List<VehicleInventory> findAll();

    public Optional<VehicleInventory> findByType(String type);

    public VehicleInventory save(VehicleInventory vehicleInventory);

    public void delete(VehicleInventory vehicleInventory);

}
