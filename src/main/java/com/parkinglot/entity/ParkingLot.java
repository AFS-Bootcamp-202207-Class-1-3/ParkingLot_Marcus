package com.parkinglot.entity;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParkingLot {
    private List<ParkingTicket> parkingTickets = new ArrayList<>();
    public ParkingTicket park(Car car){
        ParkingTicket parkingTicket = new ParkingTicket(car);
        parkingTickets.add(parkingTicket);
        return parkingTicket;
    }
    public Car fetchCarByParkingTicket(ParkingTicket parkingTicket){
        Boolean isContainCar = parkingTickets.contains(parkingTicket);
        if(isContainCar){
            ParkingTicket parkingTicketA = parkingTickets.stream()
                                            .filter(parkingTicket1 -> parkingTicket1.equals(parkingTicket))
                                            .collect(Collectors.toList())
                                            .get(0);
            Car car = parkingTicketA.getCar();
            parkingTickets.remove(parkingTicket);
            return car;
        }else{
            return null;
        }
    }

}
