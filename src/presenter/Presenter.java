package presenter;
import java.io.FileNotFoundException;

import model.*;
import view.*;

public  class Presenter{
    View view;
    WithoutSpace spaceless;;

    public Presenter(){
        view = new View();
        spaceless = new WithoutSpace();
    }
   public void showSpaceless(String fileName) throws FileNotFoundException{
        spaceless.readFile(view.readString("Ïngrese el nombre del archivo"));
   }
    
    public static void main(String[] args) throws FileNotFoundException {
        Presenter presenter = new Presenter();
        presenter.showSpaceless(null);
    }
}