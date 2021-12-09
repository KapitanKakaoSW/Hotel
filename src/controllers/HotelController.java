package controllers;

import utils.Rounder;
import models.HotelModel;
import views.HotelView;


public class HotelController {

    HotelModel model;
    HotelView view;
    double starsCoefficient;

    public HotelController(HotelModel model, HotelView view) {
        this.model = model;
        this.view = view;
    }

    public void runApp() {

        view.getStarsInput();
        view.getPersonsInput();
        view.getDaysInput();
        view.getChildren();

        switch (model.getStars()) {
            case 1 -> starsCoefficient = 1;
            case 2 -> starsCoefficient = 1.2;
            case 3 -> starsCoefficient = 1.5;
            case 4 -> starsCoefficient = 2.2;
            case 5 -> starsCoefficient = 2.5;
        }

        String persons = String.valueOf(model.getPersons());
        String days = String.valueOf(model.getDays());

        double paymentInitial = model.priceCalculation(model.getDays(), model.getPersons());
        double paymentFull = paymentInitial * starsCoefficient;

        String paymentRounded = Rounder.roundValue(paymentFull);

        String output = "------------------------------\n" +
                "Название отеля: " + "test" + "\n" +
                "Количество ночей: " + days + "\n" +
                "Количество людей: " + persons + "\n" +
                "К оплате (грн.): " + paymentRounded;

        view.getOutput(output);
    }
}
