package com.example.Model;

public class Parkinglot {
    Integer id;
    VehicalType vehicalType;
    boolean isBooked;

    public Parkinglot(Integer id, VehicalType vehicalType){
        this.id = id;
        this.vehicalType = vehicalType;
    }

    public VehicalType getVehicalType() {
        return vehicalType;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public Integer getId() {
        return id;
    }
    
    public void setVehicalType(VehicalType vehicalType) {
        this.vehicalType = vehicalType;
    }

    public void setBooked(boolean isBooked) {
        this.isBooked = isBooked;
    }

}
