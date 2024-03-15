package com.example.Model;

public class Vehical {

    Integer id;
    VehicalType vehicalType;

    public Vehical(Integer id, VehicalType vehicalType){
        this.id = id;
        this.vehicalType = vehicalType;
    }

    public Integer getId() {
        return id;
    }

    public VehicalType getVehicalType(){
        return vehicalType;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setVehicalType(VehicalType vehicalType){
        this.vehicalType = vehicalType;
    }
    
}
