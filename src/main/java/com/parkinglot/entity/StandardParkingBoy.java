package com.parkinglot.entity;

import java.util.ArrayList;
import java.util.List;

public class StandardParkingBoy implements ParkCar,FetchCar {
    private List<ParkingLot> parkingLots = new ArrayList<>();

    public StandardParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    public ParkingTicket park(Car car) {
        ParkingLot parkingLot = parkingLots.stream()
                .filter(oneParkingLot -> oneParkingLot.getPositionNumber() > 0)
                .findFirst().orElse(null);
        if (parkingLot != null) {
            return parkingLot.park(car);
        } else {
            throw new WithoutAnyPositionException();
        }
    }

    public Car fetch(ParkingTicket parkingTicket) {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getParkingTicketCarMap().containsKey(parkingTicket)) {
                return parkingLot.fetchCarByParkingTicket(parkingTicket);
            }
        }
        throw new UnrecognizedParkingTicketException();
    }

}
