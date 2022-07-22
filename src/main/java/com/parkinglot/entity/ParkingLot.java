package com.parkinglot.entity;
import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private Map<ParkingTicket,Car> parkingTicketCarMap = new HashMap<>();
    public ParkingTicket park(Car car){
        ParkingTicket parkingTicket = new ParkingTicket();
        parkingTicketCarMap.put(parkingTicket,car);
        return parkingTicket;
    }
    public Car fetchCarByParkingTicket(ParkingTicket parkingTicket){
        return parkingTicketCarMap.remove(parkingTicket);

    }

}
