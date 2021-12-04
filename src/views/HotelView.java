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

    public void getInputs() {

        scanner = new Scanner(System.in);

        title = "Введите количество дней: ";
        System.out.print(title);
        days = Validator.validateQuantityInput(scanner);
        model.setDays(days);

        title = "Введите количество людей: ";
        System.out.print(title);
        persons = Validator.validateQuantityInput(scanner);
        model.setPersons(persons);

        title = "Введите желаемое количество звёзд отеля: ";
        System.out.println(title);
        stars = Validator.validateStarsInput(scanner);
        model.setStars(stars);

        scanner.close();
    }
    public void getOutput(String output) {
        System.out.println(output);
    }
}
