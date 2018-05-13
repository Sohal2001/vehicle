package com.vehicle.Controller;

import com.vehicle.Entity.VehicleInventory;
import com.vehicle.Service.VehicleInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/vehicle")
public class VehicleInventoryController {

    @Autowired
    private VehicleInventoryService vehicleInventoryService;

    @PostMapping(value = "/addInventory")
    public VehicleInventory addInventory(@RequestBody VehicleInventory vehicleInventory){
        return vehicleInventoryService.save(vehicleInventory);
    }

    @DeleteMapping(value = "/delete/{type}")
    public void delete(@PathVariable("type") String type){
        vehicleInventoryService.delete(type);
    }

    @GetMapping(value = "/allVehicles")
    public List<VehicleInventory> findAll() {
        return vehicleInventoryService.findAll();
    }

    @PutMapping(value = "/updateInventory/{type}")
    public VehicleInventory update(@PathVariable("type") String type,@RequestBody VehicleInventory vehicleInventory) {
        return vehicleInventoryService.update(type,vehicleInventory);
    }

}
