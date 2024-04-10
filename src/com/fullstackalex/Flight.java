package com.fullstackalex;

public class Flight {
    private String flightNumber;
    private String airportName;
    private String airCompanyName;
    private String destination;
    private String timeOfFlightOut;
    private double price;

    public Flight(String flightNumber, String airportName, String airCompanyName, String destination, String timeOfFlightOut, double price){
        this.flightNumber = flightNumber;
        this.airportName = airportName;
        this.airCompanyName = airCompanyName;
        this.destination = destination;
        this.timeOfFlightOut = timeOfFlightOut;
        this.price = price;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getAirCompanyName() {
        return airCompanyName;
    }

    public void setAirCompanyName(String airCompanyName) {
        this.airCompanyName = airCompanyName;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getTimeOfFlightOut() {
        return timeOfFlightOut;
    }

    public void setTimeOfFlightOut(String timeOfFlightOut) {
        this.timeOfFlightOut = timeOfFlightOut;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight flight = (Flight) o;

        if (Double.compare(flight.price, price) != 0) return false;
        if (flightNumber != null ? !flightNumber.equals(flight.flightNumber) : flight.flightNumber != null)
            return false;
        if (airportName != null ? !airportName.equals(flight.airportName) : flight.airportName != null) return false;
        if (airCompanyName != null ? !airCompanyName.equals(flight.airCompanyName) : flight.airCompanyName != null)
            return false;
        if (destination != null ? !destination.equals(flight.destination) : flight.destination != null) return false;
        return timeOfFlightOut != null ? timeOfFlightOut.equals(flight.timeOfFlightOut) : flight.timeOfFlightOut == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = flightNumber != null ? flightNumber.hashCode() : 0;
        result = 31 * result + (airportName != null ? airportName.hashCode() : 0);
        result = 31 * result + (airCompanyName != null ? airCompanyName.hashCode() : 0);
        result = 31 * result + (destination != null ? destination.hashCode() : 0);
        result = 31 * result + (timeOfFlightOut != null ? timeOfFlightOut.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return  "Номер рейса: " + flightNumber +
                ", место вылета: " + airportName +
                ", авиаперевозчик: " + airCompanyName +
                ", пункт назначение: " + destination +
                ", время вылета: " + timeOfFlightOut +
                ", стоимость билета: " + price;
    }
}
