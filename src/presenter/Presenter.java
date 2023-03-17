package presenter;
import model.*;
import view.*;

public  class Presenter{
    View view;
    WithoutSpace spaceless;;

    public Presenter(){
        view = new View();
        spaceless = new WithoutSpace();
    }
   /* public void menu() {
		int op=0;
		do {
			op = view.readMenu();
			switch (op) {
			case 1:
			
            break;
			case 2:
			
            break;
			case 3:
            
            break;
			case 4:
			
            break;
			case 5:
            
            break;
			case 6:
            
            break;
			case 7:
			
            break;
			default:
			view.showMessage("Opcion incorrecta");
			}
		}while (op != 7);
	} */
    
    public static void main(String[] args) {
        Presenter presenter = new Presenter();
        
    }
}