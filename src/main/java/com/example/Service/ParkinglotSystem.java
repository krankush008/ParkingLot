package com.example.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.example.Model.Parkinglot;
import com.example.Model.User;
import com.example.Model.Vehical;

public class ParkinglotSystem {
    
    ArrayList<Parkinglot> parkinglots;
    ArrayList<User> users;
    Map<Integer, Integer> slotToUser;
    Map<Integer, Integer> slotToVehical;
    Map<Integer, ArrayList<Integer>> usersToParkingLots;

    public ParkinglotSystem(ArrayList<Parkinglot> parkinglots){
        this.parkinglots = parkinglots;
        this.users = new ArrayList<>();
        this.slotToUser = new HashMap<>();
        this.slotToVehical = new HashMap<>();
        this.usersToParkingLots = new HashMap<>();
    }

    public void addParkingLot(Parkinglot parkingLot){
        parkinglots.add(parkingLot);
    }

    public void bookSlot(Vehical vehical, User user){
        boolean isPoss = false;
        Integer slotId = 0;
        for(int i=0;i<parkinglots.size();i++){
            if(parkinglots.get(i).getVehicalType()==vehical.getVehicalType() && !parkinglots.get((i)).isBooked()){
                parkinglots.get((i)).setBooked(true);
                isPoss = true;
                slotId = parkinglots.get(i).getId();
                break;
            }
        }
        if(isPoss){
            slotToUser.put(slotId, user.getId());
            slotToVehical.put(slotId, vehical.getId());
            ArrayList<Integer> userToParkingsLot = usersToParkingLots.get(user.getId());
            if(userToParkingsLot==null){
                userToParkingsLot = new ArrayList<Integer>();
            }
            userToParkingsLot.add(slotId);
            usersToParkingLots.put(user.getId(), userToParkingsLot);
            boolean userIsPresent = false;
            for(int i=0; i<users.size(); i++){
                if(users.get(i).getId()==user.getId()){
                    userIsPresent = true;
                }
            }
            if(!userIsPresent){
                users.add(user);
            }
            printSlot(slotId, user, vehical);
        }
    }

    public void printSlot(Integer slotId, User user, Vehical vehical){
        System.out.println("slot id = "+slotId+" vehical id = "+vehical.getId()+" user id = "+user.getId());
    }

    public void printAllSlots(User user){
        for(int i=0; i<usersToParkingLots.get(user.getId()).size(); i++){
            System.out.println("slot id = "+usersToParkingLots.get(user.getId()).get(i)+" vehical id = "+slotToVehical.get(usersToParkingLots.get(user.getId()).get(i)));
        }
    }
}
