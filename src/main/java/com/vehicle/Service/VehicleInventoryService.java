package com.vehicle.Service;

import com.vehicle.Entity.VehicleInventory;

import java.util.List;
import java.util.Optional;

public interface VehicleInventoryService {

    public List<VehicleInventory> findAll();

    public VehicleInventory update(String type,VehicleInventory vehicleInventory);

    public VehicleInventory save(VehicleInventory vehicleInventory);

    public void delete(String type);

}
