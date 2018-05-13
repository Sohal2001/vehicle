package com.vehicle.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;


@Entity
@Table(name = "vehicleinventory")
public class VehicleInventory {

    @Id
    private String id;

    @Column(unique = true)
    private String type;

    private Integer available;

    private Integer inUse;

    private Integer inMaintainance;

    public VehicleInventory() {
        this.id = UUID.randomUUID().toString();
    }

    public VehicleInventory(String type, Integer available, Integer inUse, Integer inMaintainance) {
        this.id = UUID.randomUUID().toString();
        this.type = type;
        this.available = available;
        this.inUse = inUse;
        this.inMaintainance = inMaintainance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public Integer getInUse() {
        return inUse;
    }

    public void setInUse(Integer inUse) {
        this.inUse = inUse;
    }

    public Integer getInMaintainance() {
        return inMaintainance;
    }

    public void setInMaintainance(Integer inMaintainance) {
        this.inMaintainance = inMaintainance;
    }
}
