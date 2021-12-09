package models;

import base.Price;

public class HotelModel implements Price {

    int days;
    int persons;
    int stars;
    int rooms;
    int additionalAdults;
    int additionalChildren;
    final double basePrice = 300;
    final double adultPlus = 150;
    final double childPlus = 100;

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getPersons() {
        return persons;
    }

    public void setPersons(int persons) {
        this.persons = persons;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getAdditionalAdults() {
        return additionalAdults;
    }

    public void setAdditionalAdults(int additionalAdults) {
        this.additionalAdults = additionalAdults;
    }

    public int getAdditionalChildren() {
        return additionalChildren;
    }

    public void setAdditionalChildren(int additionalChildren) {
        this.additionalChildren = additionalChildren;
    }

    @Override
    public double priceCalculation(int days, int rooms) {
        return days * ((rooms * basePrice) + (additionalAdults * adultPlus) + (additionalChildren * childPlus));
    }
}
