package utils;

import java.util.Scanner;

public class Validator {

    public static int validateQuantityInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            String str = scanner.nextLine().trim();
            System.out.printf("\"%s\" - не число!\n", str);
            System.out.print("Введите количество!: ");
        }
        int quantity = scanner.nextInt();
        while (quantity <= 0) {
            System.out.println("Неверное значение! Введите количество: ");
            while (!scanner.hasNextInt()) {
                String str = scanner.next().trim();
                System.out.printf("\"%s\" - не число!\n", str);
                System.out.println("Введите количество!: ");
            }
            quantity = scanner.nextInt();
        }
        return quantity;
    }

    public static int validateStarsInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            String str = scanner.nextLine().trim();
            System.out.printf("\"%s\" - не число!\n", str);
            System.out.print("Введите количество звёзд отеля: ");
        }
        int quantity = scanner.nextInt();
        while (quantity <= 0 | quantity > 5) {
            System.out.println("Неверное количество звёзд! Попробуйте ещё раз: ");
            while (!scanner.hasNextInt()) {
                String str = scanner.next().trim();
                System.out.printf("\"%s\" - не число!\n", str);
                System.out.println("ВВведите количество звёзд отеля: ");
            }
            quantity = scanner.nextInt();
        }
        return quantity;
    }

    public static String operationChooser(Scanner scanner) {
        while (!scanner.hasNextLine()) {
            System.out.println("Неверная операция. Повторите попытку: ");
        }
        String operation = scanner.nextLine().trim();
        while (!operation.equalsIgnoreCase("да") & !operation.equalsIgnoreCase("нет")) {
            System.out.println("Неверная операция. Повторите попытку: ");
            operation = scanner.nextLine().trim();
        }
        return operation;
    }

    public static int validateChildrenInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            String str = scanner.nextLine().trim();
            System.out.printf("\"%s\" - не число!\n", str);
            System.out.print("Введите количество!: ");
        }
        int quantity = scanner.nextInt();
        while (quantity < 0) {
            System.out.println("Неверное значение! Введите количество: ");
            while (!scanner.hasNextInt()) {
                String str = scanner.next().trim();
                System.out.printf("\"%s\" - не число!\n", str);
                System.out.println("Введите количество!: ");
            }
            quantity = scanner.nextInt();
        }
        return quantity;
    }
}
