package com.vehicle.Service;

import com.vehicle.Dao.VehicleInventoryDao;
import com.vehicle.Entity.VehicleInventory;
import com.vehicle.exceptions.BadRequestException;
import com.vehicle.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleInventoryServiceImpl implements VehicleInventoryService {

    @Autowired
    private VehicleInventoryDao vehicleInventoryDao;


    @Override
    @Transactional(readOnly = true)
    public List<VehicleInventory> findAll() {
        return vehicleInventoryDao.findAll();
    }

    @Override
    @Transactional
    public VehicleInventory update(String type, VehicleInventory vehicleInventory) {
        vehicleInventoryDao.findByType(type).orElseThrow(() -> new NotFoundException("Vehicle Inventory with type " + type + " does not exist"));
        return vehicleInventoryDao.save(vehicleInventory);
    }


    @Override
    @Transactional
    public VehicleInventory save(VehicleInventory vehicleInventory) {
        Optional<VehicleInventory> mayExists = vehicleInventoryDao.findByType(vehicleInventory.getType());
        if (mayExists.isPresent()) {
            throw new BadRequestException("Vehicle with type " + vehicleInventory.getType() + " already exists");
        }
        return vehicleInventoryDao.save(vehicleInventory);
    }

    @Override
    @Transactional
    public void delete(String type) {
        VehicleInventory existing = vehicleInventoryDao.findByType(type)
                .orElseThrow(() -> new NotFoundException("Vehicle Inventory with type " + type + " does not exist"));
        vehicleInventoryDao.delete(existing);
    }
}
