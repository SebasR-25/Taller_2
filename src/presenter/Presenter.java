package presenter;

import java.io.IOException;

import model.*;
import view.View;

public class Presenter {
    View view;
    CarManage carManage;

    public Presenter() {
        view = new View();
        carManage = new CarManage();
    }

    public void menuCar() throws IOException {
        int op = 0;
        do {
            op = view.readMenu();
            switch (op) {
                case 1:
                    this.createCar();
                    break;
                case 2:
                    this.showAllCars();
                    break;
                case 3:
                    this.showACar(view.readInt("Ingrese el ID del carro que desea buscar"));
                    break;
                case 4:
                    view.showMessage("Finalización");
                    break;
                default:
                    view.showMessage("Opcion incorrecta");
            }
        } while (op != 7);
    }

    private void createCar() throws IOException {
        carManage.createCar(view.readString("Ïngrese la marca del carro"),
                view.readString("Ingrese el modelo del carro"), "Ingrese el año del carro",
                view.readString("Ingrese el año dfel carro"), view.readString("Ingrese el color del carro"),
                carManage.readString("/src/sourdes/Vehicle_sequence.ddr"));
    }

    private void showAllCars() throws IOException {
        view.showMessage(carManage.showAllCars());
    }

    private void showACar(int carID) {
        int tempId = carID;
        String carInfo = "/src/sources/vehicle" + tempId + ".veh";
        carManage.showACar(carID, carInfo);
    }

    public static void main(String[] args) throws IOException {
        Presenter presenter = new Presenter();
        presenter.menuCar();
    }
}