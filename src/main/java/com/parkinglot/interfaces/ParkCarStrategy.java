package com.parkinglot.interfaces;

import com.parkinglot.entity.Car;
import com.parkinglot.entity.ParkingLot;
import com.parkinglot.entity.ParkingTicket;

import java.util.List;

public interface ParkCarStrategy {
    public ParkingTicket park(Car car, List<ParkingLot> parkingLots);
}
