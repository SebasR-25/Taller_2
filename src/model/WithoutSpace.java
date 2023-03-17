package model;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class WithoutSpace{
    public String  text ="";

    public void createFile() throws IOException {
		 try {
	            File file = new File("firstFile.txt");
	            if (file.createNewFile()) {
	                System.out.println("Archivo creado: " + file.getName());
	            }
	            else {
	                System.out.println("El archivo ya existe.");
	            }
	        }
	        catch (IOException e) {
	            System.out.println("Ocurrio un error.");
	            e.printStackTrace();
	        }
	}
	public void readFile(String fileName) throws FileNotFoundException {
		//fileName debe contener el nombre del archivo  y la terminación del mismo
        try {
            File file = new File("src/files/"+ fileName);
    	    Scanner sc = new Scanner(file);
        while(sc.hasNextLine()) {
        	text = sc.nextLine();
        }
        sc.close();
		}catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
            e.printStackTrace();
        }
	}
	public void writeFile() {
		File file = null;
		FileReader fr = null;
		BufferedReader br = null;
		try {
			file = new File ("C:\\firstFile.txt");
			fr = new FileReader (file);
			br = new BufferedReader(fr);
			String linea;
			while ((linea=br.readLine()) != null)
				System.out.println(linea);
		}
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {}
		}	
	}
    public void showSpaceless(){
        text = text.replace(" ", "");
        System.out.println(text);
    }
}