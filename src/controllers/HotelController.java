package controllers;

import utils.Rounder;
import models.HotelModel;
import views.HotelView;
import java.util.HashMap;


public class HotelController {

    HotelModel model;
    HotelView view;
    double starsCoefficient;
    String additionalBed;
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

        double paymentInitial = model.priceCalculation(model.getDays(), model.getRooms());
        double paymentFull = paymentInitial * starsCoefficient;

        String hotelName = hotelNames.get(model.getStars());
        int days = model.getDays();
        int persons = model.getPersons();
        int children = model.getAdditionalChildren();
        int rooms = model.getRooms();

        if (model.getAdditionalAdults() > 0){
            additionalBed = "Включена.";
        } else additionalBed = "Отсутствует.";

        String paymentRounded = Rounder.roundValue(paymentFull);

        String output = "------------------------------\n" +
                "Название отеля: " + hotelName + "\n" +
                "Количество ночей: " + days + "\n" +
                "Количество взрослых: " + persons + "\n" +
                "Количество детей: " + children + "\n" +
                "Количество номеров: " + rooms + "\n" +
                "Услуга \"дополнительная кровать\" : " + additionalBed + "\n" +
                "К оплате (грн.): " + paymentRounded;

        view.getOutput(output);
    }
}
