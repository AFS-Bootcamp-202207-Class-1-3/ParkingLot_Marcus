package com.parkinglot.entity;

import com.parkinglot.exception.UnrecognizedParkingTicketException;
import com.parkinglot.parkCarStrategy.enums.ParkCarStrategyEnumus;
import com.parkinglot.parkCarStrategy.implement.ComparePositionNumberStrategy;
import com.parkinglot.parkCarStrategy.implement.CompareRateStrategy;
import com.parkinglot.parkCarStrategy.implement.ParkFirstParkingLot;
import com.parkinglot.parkCarStrategy.interfaces.ParkCarStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StandardParkingBoy{
    private final List<ParkingLot> parkingLots;
    private final Map<ParkingTicket,ParkingLot> parkingTicketParkingLotMap = new HashMap<>();
    private final Map<ParkCarStrategyEnumus,ParkCarStrategy> Park_Car_Strategy;

    public StandardParkingBoy(List<ParkingLot> parkingLots) {
        Park_Car_Strategy = new HashMap<>();
        Park_Car_Strategy.put(ParkCarStrategyEnumus.CPNS,new ComparePositionNumberStrategy());
        Park_Car_Strategy.put(ParkCarStrategyEnumus.CRS,new CompareRateStrategy());
        Park_Car_Strategy.put(ParkCarStrategyEnumus.PFPL,new ParkFirstParkingLot());
        this.parkingLots = parkingLots;
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    public ParkingTicket park(Car car,ParkCarStrategyEnumus parkCarStrategyEnumus) {
        return Park_Car_Strategy.get(parkCarStrategyEnumus).park(car,parkingLots,parkingTicketParkingLotMap);
//        return parkCarStrategy.park(car,parkingLots,parkingTicketParkingLotMap);
    }

    public Car fetch(ParkingTicket parkingTicket) {
        if(parkingTicketParkingLotMap.containsKey(parkingTicket)){
            return parkingTicketParkingLotMap.remove(parkingTicket).fetchCarByParkingTicket(parkingTicket);
        }
        throw new UnrecognizedParkingTicketException();
    }

}
