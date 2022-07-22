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
        Car car = new Car("123");
        ParkingLot parkingLot = new ParkingLot();
//        when
        ParkingTicket parkingTicket = parkingLot.park(car);
//        then
        Assertions.assertNotNull(parkingTicket);
    }
    @Test
    public void should_return_car_when_fetchCarByParkingTicket_given_parkingTicket(){
//        given
        Car testCar = new Car("123");
        ParkingLot parkingLot = new ParkingLot();
        ParkingTicket parkingTicket = parkingLot.park(testCar);
//        when
        Car car = parkingLot.fetchCarByParkingTicket(parkingTicket);
//        then
        Assertions.assertNotNull(car);
    }
    @Test
    public void should_return_twoRightCar_when_fetchCarByParkingTicket_given_twoParkingTicket(){
//        given
        Car testCar1 = new Car("123");
        Car testCar2 = new Car("456");
        ParkingLot parkingLot = new ParkingLot();
        ParkingTicket parkingTicket1 = parkingLot.park(testCar1);
        ParkingTicket parkingTicket2 = parkingLot.park(testCar2);
//        when
        Car car1 = parkingLot.fetchCarByParkingTicket(parkingTicket1);
        Car car2 = parkingLot.fetchCarByParkingTicket(parkingTicket2);
//        then
        Assertions.assertEquals(testCar1,car1);
        Assertions.assertEquals(testCar2,car2);
    }
    @Test
    public void should_return_null_when_fetchCarByParkingTicket_given_wrongParkingTicket(){
//        given

        ParkingLot parkingLot = new ParkingLot();
        ParkingTicket parkingTicket = new ParkingTicket();
//        when
        Car car = parkingLot.fetchCarByParkingTicket(parkingTicket);
//        then
        Assertions.assertNull(car);
    }
    @Test
    public void should_return_null_when_fetchCarByParkingTicket_given_usedParkingTicket(){
//        given
        Car testCar = new Car("123");
        ParkingLot parkingLot = new ParkingLot();
        ParkingTicket parkingTicket = parkingLot.park(testCar);
//        when
        Car carOne = parkingLot.fetchCarByParkingTicket(parkingTicket);
        Car carTwo = parkingLot.fetchCarByParkingTicket(parkingTicket);
//        then
        Assertions.assertNull(carTwo);
    }
}
