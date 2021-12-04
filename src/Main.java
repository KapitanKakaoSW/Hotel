import controllers.HotelController;
import models.HotelModel;
import views.HotelView;

public class Main {

    public static void main(String[] args) {

        HotelModel model = new HotelModel();
        HotelView view = new HotelView(model);
        HotelController controller = new HotelController(model, view);
        controller.runApp();
    }
}
