package views;

import utils.Validator;
import models.HotelModel;
import java.util.Scanner;

public class HotelView {

    HotelModel model;
    String title;
    int days;
    int persons;
    int stars;
    Scanner scanner;

    public HotelView(HotelModel model) {
        this.model = model;
    }

    public void getStarsInput() {

        scanner = new Scanner(System.in);

        title = "Введите желаемое количество звёзд отеля: ";
        System.out.println(title);
        stars = Validator.validateStarsInput(scanner);
        model.setStars(stars);
    }

    public void getOutput(String output) {
        System.out.println(output);
    }
}
