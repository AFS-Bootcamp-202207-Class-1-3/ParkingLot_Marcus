package com.parkinglot;

import com.parkinglot.entity.Car;
import com.parkinglot.entity.ParkingLot;
import com.parkinglot.entity.ParkingTicket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class parkingLotTest {
    @Test
    public void should_return_parkingTicket_when_park_given_car(){
//        given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
//        when
        ParkingTicket parkingTicket = parkingLot.park(car);
//        then
        Assertions.assertNotNull(parkingTicket);
    }

}
