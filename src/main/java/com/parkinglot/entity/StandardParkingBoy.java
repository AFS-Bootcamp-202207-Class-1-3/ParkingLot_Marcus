package com.parkinglot.entity;

import com.parkinglot.exception.UnrecognizedParkingTicketException;
import com.parkinglot.exception.WithoutAnyPositionException;
import com.parkinglot.implement.StandardParking;
import com.parkinglot.interfaces.ParkCarStrategy;

import java.util.ArrayList;
import java.util.List;

public class StandardParkingBoy{
    private List<ParkingLot> parkingLots = new ArrayList<>();
    private ParkCarStrategy parkCarStrategy;
    public StandardParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    public ParkingTicket park(Car car) {
        return parkCarStrategy.park(car,parkingLots);
    }

    public Car fetch(ParkingTicket parkingTicket) {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getParkingTicketCarMap().containsKey(parkingTicket)) {
                return parkingLot.fetchCarByParkingTicket(parkingTicket);
            }
        }
        throw new UnrecognizedParkingTicketException();
    }

    public void setParkCarStrategy(ParkCarStrategy parkCarStrategy) {
        this.parkCarStrategy = parkCarStrategy;
    }
}
