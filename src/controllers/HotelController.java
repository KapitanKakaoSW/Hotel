package controllers;

import utils.Rounder;
import models.HotelModel;
import views.HotelView;
import java.util.HashMap;


public class HotelController {

    HotelModel model;
    HotelView view;
    double starsCoefficient;
    HashMap<Integer, String> hotelNames = new HashMap<>(5);

    public HotelController(HotelModel model, HotelView view) {
        this.model = model;
        this.view = view;
    }

    public void runApp() {

        view.getStarsInput();
        view.getPersonsInput();
        view.getDaysInput();
        view.getChildren();

        hotelNames.put(1, "Мини-отель Wood Cottage");
        hotelNames.put(2, "Отель Ягуар");
        hotelNames.put(3, "Гостинично-ресторанный комплекс Мир");
        hotelNames.put(4, "Отель Виктория");
        hotelNames.put(5, "Частная усадьба Белый Дом");

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
