package com.parkinglot.parkCarStrategy.interfaces;

import com.parkinglot.entity.Car;
import com.parkinglot.entity.ParkingLot;
import com.parkinglot.entity.ParkingTicket;

import java.util.List;
import java.util.Map;

public interface ParkCarStrategy {
    public ParkingTicket park(Car car, List<ParkingLot> parkingLots, Map<ParkingTicket,ParkingLot> parkingTicketParkingLotMap);
}
