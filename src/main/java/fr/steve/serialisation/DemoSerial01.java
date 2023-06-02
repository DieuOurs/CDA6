package fr.steve.serialisation;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class DemoSerial01  {

	/**
	 * Description : 
	 * 	S�rialiser un objet de type Personne
	 * @param args
	 */
	public static void main(String[] args) {
		Personne personne = new Personne();
		personne.setNom("Bob");
		personne.setAge(82);
		System.out.println(personne);

		try{

			FileOutputStream out = new FileOutputStream("C:\\Users\\shoareau.cda\\OneDrive - EXPERNET\\java\\SER\\target\\extract\\personne.ser");
			ObjectOutputStream oos = new ObjectOutputStream(out);
			oos.writeObject(personne);
			oos.close();

		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
