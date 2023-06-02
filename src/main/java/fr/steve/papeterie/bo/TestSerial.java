package fr.steve.papeterie.bo;

import java.io.*;

public class TestSerial {

    public static void main(String[] args) {
        String url = "C:\\Users\\shoareau.cda\\OneDrive - EXPERNET\\java\\SER\\target\\extract\\";

        Stylo unBic = new Stylo(1, "Bic", "BBOrange", "Bic bille Orange", 1.2f, 20, "Bleu");
        Stylo unAutreBic = new Stylo(3, "Bic", "AutreBicUTF", "àéè", 1.2f, 20, "Rouge");
        Ramette uneRamette = new Ramette(2, "Clairef", "CRA4S", "Ramette A4 Sup", 9f, 20, 80);
        Panier panier = new Panier(1);
        panier.addLigne(unBic, 2);
        panier.addLigne(unAutreBic, 1);
        panier.addLigne(uneRamette, 2);
        //Sérialisation
        try {

            FileOutputStream out = new FileOutputStream(url + "panier.ser");
            ObjectOutputStream oos = new ObjectOutputStream(out);
            oos.writeObject(panier);
            oos.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        //Désérialisation
        try (FileInputStream fis = new FileInputStream(url + "panier.ser");
             ObjectInputStream ois = new ObjectInputStream(fis)
        ) {
            panier = (Panier) ois.readObject();
            System.out.println(panier);
            System.out.println(panier.getMontant());
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
}
