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
            throw new WithoutAnyPositionException();
        }
    }

    public Car fetchCarByParkingTicket(ParkingTicket parkingTicket) {
        if (parkingTicketCarMap.containsKey(parkingTicket)) {
            positionNumber += 1;
            return parkingTicketCarMap.remove(parkingTicket);
        } else {
            throw new UnrecognizedParkingTicketException();
        }
    }

    public int getPositionNumber() {
        return positionNumber;
    }

    public Map<ParkingTicket, Car> getParkingTicketCarMap() {
        return parkingTicketCarMap;
    }

    public Double getRate(){

        return positionNumber/((positionNumber+parkingTicketCarMap.size())*1.0);
    }
}
