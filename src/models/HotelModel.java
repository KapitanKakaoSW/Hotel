package models;
import base.Price;

public class HotelModel implements Price {

    int days;
    int persons;
    int stars;
    final double price = 20;

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

    @Override
    public double priceCalculation(int days, int persons) {
        return days * persons * price;
    }
}
