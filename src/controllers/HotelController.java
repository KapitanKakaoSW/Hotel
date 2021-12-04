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

        view.getInputs();

        switch (model.getStars()) {
            case 1 -> starsCoefficient = 1;
            case 2 -> starsCoefficient = 1.2;
            case 3 -> starsCoefficient = 1.5;
            case 4 -> starsCoefficient = 2.2;
            case 5 -> starsCoefficient = 2.5;
        }

        double paymentInitial = model.priceCalculation(model.getDays(), model.getPersons());
        double paymentFull = paymentInitial * starsCoefficient;

        String paymentRounded = Rounder.roundValue(paymentFull);


        String output = "------------------------------\n" +
                "Название отеля: " + "test" + "\n" +
                "Количество ночей: " + model.getDays() + "\n" +
                "Количество людей: " + model.getPersons() + "\n" +
                "К оплате (грн.): " + paymentRounded;

        view.getOutput(output);
    }
}
