package controllers;

import models.ReservationModel;
import views.ReservationView;
import java.util.Date;

public class ReservationController {

    ReservationModel model;
    ReservationView view;

    public ReservationController(ReservationModel model, ReservationView view) {
        this.model = model;
        this.view = view;
    }

    public void runApp() {

        view.getInputs();

        String roomNumber = String.valueOf(model.getRoomNumber());

        long duration = model.calculateDuration();

        Date startDate = model.getStartDate();
        String startDateTemp = startDate.toString();

        Date finalDate = model.getFinalDate();
        String finalDateTemp = finalDate.toString();

        String output = "------------------------------\n" +
                "Номер комнаты: " + roomNumber + "\n" +
                "Дата заселения: " + startDateTemp + "\n" +
                "Дата отъезда: " + finalDateTemp + "\n" +
                "Срок пребывания: " + duration + " дн.";

        view.getOutput(output);
    }
}
