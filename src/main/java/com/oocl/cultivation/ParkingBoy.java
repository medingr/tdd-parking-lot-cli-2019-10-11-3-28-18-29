package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {

    private final List<ParkingLot> parkingLotsToManage;
    private String lastErrorMessage;

    public ParkingBoy(List <ParkingLot> parkingLotsToManage) {
        this.parkingLotsToManage = parkingLotsToManage;
    }

    public ParkingTicket park(Car car) {

            ParkingTicket ticket = new ParkingTicket();

            for (ParkingLot parkingLot : parkingLotsToManage )
            {
                if ( parkingLot.getAvailableParkingPosition() == 0) {
                    lastErrorMessage = "Not enough position.";
                    ticket = null;
                } else {
                    ticket = parkingLot.park(car);
                    break;
                }

            }
        return ticket;
    }

    public Car fetch(ParkingTicket ticket) {
       Car car =  new Car();

       if (ticket == null ){
           lastErrorMessage = "Please provide your parking ticket.";
           return null;
       }
       for (ParkingLot parkingLot : parkingLotsToManage) {
           if ( parkingLot.fetch(ticket) != null){
               car = parkingLot.fetch(ticket);
           }else {
               car = null;
           }
       }

       if ( car == null) {
           lastErrorMessage = "Unrecognized parking ticket";
           return null;
       }
          return car;
    }

    public String getLastErrorMessage() {
        return lastErrorMessage;
    }
}
