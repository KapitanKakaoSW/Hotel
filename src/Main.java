import controllers.HotelController;
import controllers.ReservationController;
import models.HotelModel;
import models.ReservationModel;
import utils.Validator;
import views.HotelView;
import views.ReservationView;
import java.util.Scanner;

public class Main {

    static Scanner scanner;

    public static void main(String[] args) {

        scanner = new Scanner(System.in);

        System.out.println("Выберите тип операций в приложении.\nДля выбора расчёта цены заселения" +
                "в отель введите \"Расчёт\".\nДля выбора операций бронирования введите \"Бронирование\".");
        String temp = Validator.viewChooser(scanner);
        if (temp.equalsIgnoreCase("Бронирование")){
            reservationView();
        } else hotelView();
    }

    static void reservationView(){
        ReservationModel model = new ReservationModel();
        ReservationView view = new ReservationView(model);
        ReservationController controller = new ReservationController(model, view);
        controller.runApp();
    }

    static void hotelView() {
        HotelModel model = new HotelModel();
        HotelView view = new HotelView(model);
        HotelController controller = new HotelController(model, view);
        controller.runApp();
    }
}
