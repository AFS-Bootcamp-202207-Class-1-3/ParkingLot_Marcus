package com.parkinglot.entity;

import com.parkinglot.exception.UnrecognizedParkingTicketException;
import com.parkinglot.interfaces.ParkCarStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StandardParkingBoy{
    private List<ParkingLot> parkingLots = new ArrayList<>();
    private Map<ParkingTicket,ParkingLot> parkingTicketParkingLotMap = new HashMap<>();
    private ParkCarStrategy parkCarStrategy;
    public StandardParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    public ParkingTicket park(Car car) {
        return parkCarStrategy.park(car,parkingLots,parkingTicketParkingLotMap);
    }

    public Car fetch(ParkingTicket parkingTicket) {
        if(parkingTicketParkingLotMap.containsKey(parkingTicket)){
            return parkingTicketParkingLotMap.remove(parkingTicket).fetchCarByParkingTicket(parkingTicket);
        }
        throw new UnrecognizedParkingTicketException();
    }

    public void setParkCarStrategy(ParkCarStrategy parkCarStrategy) {
        this.parkCarStrategy = parkCarStrategy;
    }
}
