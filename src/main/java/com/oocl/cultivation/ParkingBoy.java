package com.oocl.cultivation;

public class ParkingBoy {

    private final ParkingLot parkingLot;
    private String lastErrorMessage;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingTicket park(Car car) {
         if ( parkingLot.getAvailableParkingPosition() == 0) {
             lastErrorMessage = "Not enough position.";
         }
          return parkingLot.park(car);
    }

    public Car fetch(ParkingTicket ticket) {
       Car car =  parkingLot.fetch(ticket);

       if (ticket == null ){
           lastErrorMessage = "Please provide your parking ticket.";
           return null;
       } else if ( car == null) {
           lastErrorMessage = "Unrecognized parking ticket";
           return null;
       } else {
          return car;
       }
    }

    public String getLastErrorMessage() {
        return lastErrorMessage;
    }
}
