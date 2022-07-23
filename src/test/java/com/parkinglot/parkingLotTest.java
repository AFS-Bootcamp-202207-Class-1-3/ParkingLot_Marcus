package com.parkinglot;

import com.parkinglot.entity.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class parkingLotTest {
    @Test
    public void should_return_parkingTicket_when_park_given_car() {
//        given
        Car car = new Car("123");
        ParkingLot parkingLot = new ParkingLot(10);
//        when
        ParkingTicket parkingTicket = parkingLot.park(car);
//        then
        Assertions.assertNotNull(parkingTicket);
    }

    @Test
    public void should_return_car_when_fetchCarByParkingTicket_given_parkingTicket() {
//        given
        Car testCar = new Car("123");
        ParkingLot parkingLot = new ParkingLot(10);
        ParkingTicket parkingTicket = parkingLot.park(testCar);
//        when
        Car car = parkingLot.fetchCarByParkingTicket(parkingTicket);
//        then
        Assertions.assertNotNull(car);
    }

    @Test
    public void should_return_twoRightCar_when_fetchCarByParkingTicket_given_twoParkingTicket() {
//        given
        Car testCar1 = new Car("123");
        Car testCar2 = new Car("456");
        ParkingLot parkingLot = new ParkingLot(10);
        ParkingTicket parkingTicket1 = parkingLot.park(testCar1);
        ParkingTicket parkingTicket2 = parkingLot.park(testCar2);
//        when
        Car car1 = parkingLot.fetchCarByParkingTicket(parkingTicket1);
        Car car2 = parkingLot.fetchCarByParkingTicket(parkingTicket2);
//        then
        Assertions.assertEquals(testCar1, car1);
        Assertions.assertEquals(testCar2, car2);
    }

    @Test
    public void should_return_errorMessage_when_fetchCarByParkingTicket_given_wrongParkingTicket() {
//        given
        ParkingLot parkingLot = new ParkingLot(10);
        ParkingTicket unrecognizedParkingTicket = new ParkingTicket();

//      when  then
        Exception exception = Assertions.assertThrows(UnrecognizedParkingTicketException.class
                , () -> parkingLot.fetchCarByParkingTicket(unrecognizedParkingTicket));
        Assertions.assertEquals("Unrecognized parking ticket", exception.getMessage());

    }

    @Test
    public void should_return_errorMessage_when_fetchCarByParkingTicket_given_usedParkingTicket() {
//        given
        Car testCar = new Car("123");
        ParkingLot parkingLot = new ParkingLot(10);
        ParkingTicket parkingTicket = parkingLot.park(testCar);
//        when
        Car carOne = parkingLot.fetchCarByParkingTicket(parkingTicket);
//        then
        Exception exception = Assertions.assertThrows(UnrecognizedParkingTicketException.class
                , () -> parkingLot.fetchCarByParkingTicket(parkingTicket));
        Assertions.assertEquals("Unrecognized parking ticket", exception.getMessage());
    }

    @Test
    public void should_returnNoPositionMessage_when_park_given_noPosition() {
//        given
        Car testCar = new Car("123");
        Car testCar2 = new Car("345");
        ParkingLot parkingLot = new ParkingLot(1);
//        when
        ParkingTicket parkingTicket = parkingLot.park(testCar);
//        then
        Exception exception = Assertions.assertThrows(WithoutAnyPositionException.class
                , () -> parkingLot.park(testCar2));
        Assertions.assertEquals("No available position.", exception.getMessage());
    }

    @Test
    public void should_return_parkingTicket_when_park_given_carAndParkingBoy() {
//        given
        ParkingLot parkingLot = new ParkingLot(10);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car("123");
//        when
        ParkingTicket parkingTicket = parkingBoy.park(car);
//        then
        Assertions.assertNotNull(parkingTicket);
    }

    @Test
    public void should_return_rightCar_when_parkingBoyFetch_given_correctParkingTicket() {
//        given
        ParkingLot parkingLot = new ParkingLot(10);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car testCar = new Car("123");
        ParkingTicket parkingTicket = parkingBoy.park(testCar);
//        when
        Car fetchCar = parkingBoy.fetch(parkingTicket);
//        then
        Assertions.assertEquals(fetchCar, testCar);
    }

    @Test
    public void should_return_errorMessage_when_parkingBoyFetch_given_wrongParkingTicket() {
//        given
        ParkingLot parkingLot = new ParkingLot(10);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        ParkingTicket unrecognizedParkingTicket = new ParkingTicket();

//      when  then
        Exception exception = Assertions.assertThrows(UnrecognizedParkingTicketException.class
                , () -> parkingBoy.fetch(unrecognizedParkingTicket));
        Assertions.assertEquals("Unrecognized parking ticket", exception.getMessage());

    }

    @Test
    public void should_return_errorMessage_when_parkingBoyFetch_given_usedParkingTicket() {
//        given
        Car testCar = new Car("123");
        ParkingLot parkingLot = new ParkingLot(10);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        ParkingTicket parkingTicket = parkingLot.park(testCar);
//        when
        Car carOne = parkingBoy.fetch(parkingTicket);
//        then
        Exception exception = Assertions.assertThrows(UnrecognizedParkingTicketException.class
                , () -> parkingBoy.fetch(parkingTicket));
        Assertions.assertEquals("Unrecognized parking ticket", exception.getMessage());
    }

    @Test
    public void should_returnNoPositionMessage_when_parkingBoyPark_given_noPosition() {
//        given
        Car testCar = new Car("123");
        Car testCar2 = new Car("345");
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
//        when
        ParkingTicket parkingTicket = parkingBoy.park(testCar);
//        then
        Exception exception = Assertions.assertThrows(WithoutAnyPositionException.class
                , () -> parkingBoy.park(testCar2));
        Assertions.assertEquals("No available position.", exception.getMessage());
    }

    @Test
    public void should_return_firstParkingLotSizeReduceOne__when_standardParkingBoyPark_given_car() {
//        given
        Car testCar = new Car("123");
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(10));
        parkingLots.add(new ParkingLot(10));
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLots);
//        when
        ParkingTicket parkingTicket = standardParkingBoy.park(testCar);
//        then
        Assertions.assertEquals(9, standardParkingBoy.getParkingLots().get(0).getPositionNumber());
        Assertions.assertEquals(10, standardParkingBoy.getParkingLots().get(1).getPositionNumber());
    }


}
