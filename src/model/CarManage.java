package model;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class CarManage {
    public int tempId;
    private DataOutputStream dos;
    private DataInputStream dis;
    public CarManage() throws NumberFormatException, IOException{
        tempId = Integer.parseInt(this.readString("src/sources/Vehicle_sequence.ddr"));
    }

    public String createFile() throws IOException {
        String result = "";
        try {
            File file = new File("src/sources/" + "Vehicle_sequence.ddr");
            if (file.createNewFile()) {
                result = "Archivo creado: " + file.getName();
            } else {
                result = "El archivo ya existe.";
            }
        } catch (IOException e) {
            System.out.println("Ocurrio un error.");
            e.printStackTrace();
        }
        return result;
    }

    public void writeString(String cad, String fileNamePath) throws IOException {
        // fileNamePath debe contener el nombre del archivo y la terminación del mismo
        File file = new File(fileNamePath);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        dos = new DataOutputStream(fileOutputStream);
        dos.writeUTF(cad);
    }

    public String readString(String fileNamePath) throws IOException {
        // fileName debe contener el nombre del archivo y la terminación del mismo
        File file = new File(fileNamePath);
        FileInputStream fileInputStream = new FileInputStream(file);
        dis = new DataInputStream(fileInputStream);
        return dis.readUTF();
    }

    private boolean searchCar(int id) {
        String fileNamePath = "src/sources/vehiculo_" + id + ".veh";
        File file = new File(fileNamePath);
        return file.exists();
    }

    public String createCar(String marca, String modelo, String año, String matricula, String color, String id) throws IOException {
        String carInfo = marca + "," + modelo + "," + año + "," + matricula + "," + color + "," + id;
        int newId = tempId+1;
        this.writeString(carInfo, "src/sources/vehiculo_" + id + ".veh");
        this.writeString(newId + "", "src/sources/Vehicle_sequence.ddr");
        return "El carro ha sido creado correctamente";
    }

    public String showAllCars() throws IOException {
        String result = "";
        for (int i = 1; i == tempId; i++) {
            String fileNamePath = "src/sources/vehiculo_" + i + ".veh";
            result = myToString(this.readString(fileNamePath), i) + "\n";
        }
        return result;
    }

    public String showACar(int carID, String carInfo) {
        return this.myToString(carInfo, carID);
    }

    private String myToString(String carInfo, int carID) {
        String result = "";
        if (this.searchCar(carID)) {
            carInfo.replace(',', '\n');
        } else {
            result = "El auto no existe";
        }
        return result;
    }
}