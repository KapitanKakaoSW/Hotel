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
    int rooms;
    int children;
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

    public void getPersonsInput() {

        scanner = new Scanner(System.in);

        title = "Введите количество взрослых людей: ";
        System.out.print(title);
        persons = Validator.validateQuantityInput(scanner);
        if (persons >= 4) {

            title = "Количество взрослых 4 человека и более. Желаете снять несколько номеров?(да/нет): ";
            System.out.println(title);
            Scanner scan = new Scanner(System.in);
            String operation = Validator.operationChooser(scan);

            if (operation.equalsIgnoreCase("да")) {
                getRoomsInput();
            } else {
                System.out.println("Максимальное количество взрослых людей в номере - 3 человека.");
                getPersonsInput();
            }

        } else if (persons == 3) {
            title = "Количество взрослых 3 человека. Заселение дополнительного взрослого " +
                    "не включено в стоимость номера, взимается дополнительная плата. \nПродолжить?(да/нет): ";
            System.out.println(title);
            Scanner scan = new Scanner(System.in);
            String operation = Validator.operationChooser(scan);

            if (operation.equalsIgnoreCase("да")) {
                model.setAdditionalAdults(1);
                model.setRooms(1);

            } else getPersonsInput();

        } else model.setRooms(1);

        model.setPersons(persons);
    }

    public void getRoomsInput() {

        scanner = new Scanner(System.in);

        title = "Введите желаемое количество номеров: ";
        System.out.println(title);
        rooms = Validator.validateQuantityInput(scanner);

        if (persons % rooms == 1) {
            System.out.println("Максимальное количество взрослых людей в номере - 3. " +
                    "\nУслуга \"Дополнительная кровать\" будет включена в стоимость одного номера" +
                    "\nПродолжить?(да/нет): ");

            Scanner scan = new Scanner(System.in);
            String operation = Validator.operationChooser(scan);

            if (operation.equalsIgnoreCase("да")) {
                model.setAdditionalAdults(1);
            } else getPersonsInput();

            model.setRooms(rooms);

        } else if (rooms == 1) {
            System.out.println("Неверное количество. Необходимо выбрать более одного номера. ");
            getRoomsInput();

            model.setRooms(rooms);

        } else model.setRooms(rooms);
    }

    public void getDaysInput() {

        scanner = new Scanner(System.in);

        title = "Введите желаемое количество ночей: ";
        System.out.println(title);
        days = Validator.validateQuantityInput(scanner);
        model.setDays(days);
    }

    public void getChildren() {

        scanner = new Scanner(System.in);

        title = "Введите количество детей(если таковые отсутствуют, введите 0): ";
        System.out.println(title);

        children = Validator.validateChildrenInput(scanner);

        double tempChildren = children;
        double tempPersons = persons;

        if (children > 2 & tempPersons / tempChildren < 0.5) {
            System.out.println("Вы превысили допустимый лимит детей. Выберите другое количество."); //звучит так себе
            getChildren();
        } else model.setAdditionalChildren(children);
    }

    public void getOutput(String output) {
        System.out.println(output);
    }
}
