package fr.steve.papeterie.bo;

import fr.steve.serialisation.Adresse;
import fr.steve.serialisation.Personne;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TestSerial {

    public static void main(String[] args) {
        String url = "C:\\Users\\shoareau.cda\\OneDrive - EXPERNET\\java\\SER\\target\\extract\\";

        Stylo unBic = new Stylo(1, "Bic", "BBOrange","Bic bille Orange", 1.2f, 20, "Bleu");
        Ramette uneRamette = new Ramette(2, "Clairef", "CRA4S", "Ramette A4 Sup", 9f, 20, 80);
        Panier panier = new Panier();
        panier.addLigne(unBic,2);
        panier.addLigne(uneRamette,2);
        //S�rialisation
        try{

            FileOutputStream out = new FileOutputStream(url+"articles.ser");
            ObjectOutputStream oos = new ObjectOutputStream(out);
            oos.writeObject(panier);
            oos.close();

        }catch(Exception ex){
            ex.printStackTrace();
        }

        //D�s�rialisation
        try (FileInputStream fis = new FileInputStream(url+"articles.ser");
             ObjectInputStream ois = new ObjectInputStream(fis);
        ){
            panier = (Panier) ois.readObject();
            System.out.println(panier);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
}
