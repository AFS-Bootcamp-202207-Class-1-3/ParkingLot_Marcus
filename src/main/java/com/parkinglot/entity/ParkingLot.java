package com.parkinglot.entity;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private Map<ParkingTicket, Car> parkingTicketCarMap = new HashMap<>();
    private int positionNumber;

    public ParkingLot(int positionNumber) {
        this.positionNumber = positionNumber;
    }

    public ParkingTicket park(Car car) {
        if (positionNumber > 0) {
            ParkingTicket parkingTicket = new ParkingTicket();
            parkingTicketCarMap.put(parkingTicket, car);
            positionNumber -= 1;
            return parkingTicket;
        } else {
            return null;
        }
    }

    public Car fetchCarByParkingTicket(ParkingTicket parkingTicket) {
        if(parkingTicketCarMap.containsKey(parkingTicket)){
            return parkingTicketCarMap.remove(parkingTicket);
        }else{
            throw new UnrecognizedParkingTicketException();
        }
    }

}
