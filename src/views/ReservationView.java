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

    public void getRoomNumber() {

        scanner = new Scanner(System.in);

        title = "Введите номер комнаты: ";
        System.out.println(title);
        roomNumber = Validator.validateQuantityInput(scanner);
        model.setRoomNumber(roomNumber);
    }

    public void getStartDate() {

        while (true) {
            title = "Введите дату заселения(дд/мм/гггг): ";
            System.out.println(title);

            try {
                startDate = simpleDateFormat.parse(scanner.next());
                break;
            } catch (Exception e) {
                System.out.println("Неверный формат даты.");
            }
        }
        model.setStartDate(startDate);
    }

    public void getFinalDate() {

        title = "Введите дату отъезда(дд/мм/гггг): ";
        System.out.println(title);

        while (true) {
            try {
                finalDate = simpleDateFormat.parse(scanner.next());
                break;
            } catch (Exception e) {
                System.out.println("Неверный формат даты.");
            }
        }
        model.setFinalDate(finalDate);
    }

    public void getOutput(String output) {
        System.out.println(output);
    }
}
