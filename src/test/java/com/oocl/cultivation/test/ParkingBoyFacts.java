package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.ParkingTicket;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingBoyFacts {
    @Test
    void should_parking_boy_park_car_into_parking_lot() {

        ParkingLot parkLot = new ParkingLot();
        ParkingBoy parkBoy = new ParkingBoy(parkLot);
        Car car = new Car();
        ParkingTicket ticket = new ParkingTicket();

        parkBoy.park(car);
        assertNotNull(ticket);
    }

    @Test
    void should_fetch_car_by_parking_ticket_from_parking_lot() {
        ParkingLot parkLot = new ParkingLot();
        ParkingBoy parkBoy = new ParkingBoy(parkLot);
        Car car = new Car();
        ParkingTicket ticket = new ParkingTicket();

        parkBoy.park(car);
        parkBoy.fetch(ticket);
        assertNotNull(car);
    }

    @Test
    public void should_park_multiple_cars_into_lot_and_fetch_ticket() {
        ParkingLot parkLot = new ParkingLot();
        ParkingBoy parkBoy = new ParkingBoy(parkLot);
        Car car = new Car();
        Car car2 = new Car();

        ParkingTicket ticket = parkBoy.park(car);
        ParkingTicket ticket2 = parkBoy.park(car2);

        assertNotNull(ticket);
        assertNotNull(ticket2);
        assertNotEquals(ticket,ticket2);
    }

    @Test
    public void should_customer_give_wrong_ticket_no_car_to_fetch() {
        ParkingLot parkLot = new ParkingLot();
        ParkingBoy parkBoy = new ParkingBoy(parkLot);
        Car car = new Car();
        Car carFetchedByTicket = parkBoy.fetch(null);

        assertNull(carFetchedByTicket);
    }

    @Test
    public void should_not_fetch_when_ticket_already_used() {
        ParkingLot parkLot = new ParkingLot();
        ParkingBoy parkBoy = new ParkingBoy(parkLot);
        Car car = new Car();
        ParkingTicket ticket = parkBoy.park(car);
        Car carFetchedByTicket = parkBoy.fetch(ticket);
        carFetchedByTicket = parkBoy.fetch(ticket);
        assertNull(carFetchedByTicket);
    }

    @Test
    public void should_not_park_car_when_parking_lot_is_full() {
        ParkingLot parkLot = new ParkingLot();
        ParkingBoy parkBoy = new ParkingBoy(parkLot);
        Car car = new Car();
        ParkingTicket ticket = new ParkingTicket();
        for ( int i = 0 ; i <= 10 ; i++ ){
             ticket = parkBoy.park(car);
        }
        assertNull(ticket);
    }

    @Test
    public void should_not_fetch_car_when_ticket_is_wrong() {
        ParkingLot parkLot = new ParkingLot();
        ParkingBoy parkBoy = new ParkingBoy(parkLot);
        Car car = new Car();
        ParkingTicket ticket = parkBoy.park(car);

        Car car2 = parkBoy.fetch(new ParkingTicket());
        assertNull(car2);
        assertEquals(parkBoy.getLastErrorMessage(),"Unrecognized parking ticket");
    }

}
