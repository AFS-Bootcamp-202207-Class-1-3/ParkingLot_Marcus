package com.parkinglot.entity;

import java.util.ArrayList;
import java.util.List;

public class StandardParkingBoy {
    private List<ParkingLot> parkingLots = new ArrayList<>();

    public StandardParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }
    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }
    public ParkingTicket park(Car car) {
        if(parkingLots.get(0).getPositionNumber()>0){
            return parkingLots.get(0).park(car);
        }else{
            return parkingLots.get(1).park(car);
        }
    }
    public Car fetch(ParkingTicket parkingTicket) {
        for(ParkingLot parkingLot:parkingLots){
            if(parkingLot.getParkingTicketCarMap().containsKey(parkingTicket)){
                return parkingLot.fetchCarByParkingTicket(parkingTicket);
            }
        }
        throw new UnrecognizedParkingTicketException();
    }

}
