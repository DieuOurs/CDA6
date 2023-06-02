package fr.steve.serialisation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DemoSerial02 {
	/*
	 * Description : 
	 * 	-1 Montrer la d�s�rialisation d'un objet
	 *  -2 Illustrer le fonctionnement du serialVersionUID : 
	 *  	2.1 - S�rialiser avec serialVersionUID de Personne � 1
	 *      2.2 - Changer le serialVersionUID de Personne � 2
	 *      2.3 - D�s�rialiser : provoque java.io.InvalidClassException: fr.eni.serialisation.Personne;...
	 */
	public static void main(String[] args) {
		Personne personne=null;


		try (	FileInputStream	fis = new FileInputStream("C:\\Users\\shoareau.cda\\OneDrive - EXPERNET\\java\\SER\\target\\extract\\personne.ser");
				ObjectInputStream ois = new ObjectInputStream(fis);
				){
			personne = (Personne) ois.readObject();
			System.out.println(personne);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}


	}
}
