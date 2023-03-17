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
    public double readDouble(String message){
		this.showMessage(message);
		return input.nextDouble();
	}
    public short readShort(String message){
		this.showMessage(message);
		return input.nextShort();
	}
    public short readMenu(){
        String menuText = "1. Sumar"+"\n"+"2. Restar"+"\n"+"3. Multiplicar"+"\n"+"4. Dividir"+"\n"+"5. Ver los resultados de forma ascendente"+"\n"+"6. Ver los resultaods de forma descendente"+"\n"+"7. Salir";
        return readShort(menuText);
    }
}