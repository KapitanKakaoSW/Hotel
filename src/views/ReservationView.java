package views;

import models.ReservationModel;
import utils.Validator;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ReservationView {

    ReservationModel model;
    Scanner scanner;
    String title;
    int roomNumber;
    Date startDate;
    Date finalDate;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public ReservationView(ReservationModel model) {
        this.model = model;
    }

    public void getInputs() {

        scanner = new Scanner(System.in);

        title = "Введите номер комнаты: ";
        System.out.println(title);
        roomNumber = Validator.validateQuantityInput(scanner);
        model.setRoomNumber(roomNumber);

        title = "Введите дату заселения(дд/мм/гггг): ";
        System.out.println(title);
        startDate = simpleDateFormat.parse(scanner.next()); //TODO exception handling
        model.setStartDate(startDate);

        title = "Введите дату отъезда(дд/мм/гггг): ";
        System.out.println(title);
        finalDate = simpleDateFormat.parse(scanner.next()); //TODO exception handling
        model.setFinalDate(finalDate);
    }

    public void getOutput(String output) {
        System.out.println(output);
    }
}
