package view;
import java.util.Scanner;

public class View{
    private Scanner input;

    public View(){
        input = new Scanner(System.in);
    }
    public void showMessage(String message){
		System.out.println(message);
	}
    public String readString(String message){
        this.showMessage(message);
        return input.next();
    }
    public double readDouble(String message){
		this.showMessage(message);
		return input.nextDouble();
	}
    public short readShort(String message){
		this.showMessage(message);
		return input.nextShort();
	}
    public int readInt(String message){
		this.showMessage(message);
		return input.nextInt();
	}
    public short readMenu(){
        String menuText = "1. Agregar carro"+"\n"+"2. Mostrar todos los carros"+"\n"+"3. Mostrar un carro especifico"+"\n"+"4. Salir";
        return readShort(menuText);
    }
}