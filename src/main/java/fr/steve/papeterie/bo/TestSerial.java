package fr.steve.papeterie.bo;

import fr.steve.papeterie.bo.utils.Serializer;
import fr.steve.papeterie.bo.utils.SerializerException;

public class TestSerial {

    public static void main(String[] args) throws SerializerException {
        Stylo unBic = new Stylo(1, "Bic", "BBOrange", "Bic bille Orange", 1.2f, 20, "Bleu");
        Stylo unAutreBic = new Stylo(3, "Bic", "AutreBicUTF", "àéè", 1.2f, 20, "Rouge");
        Ramette uneRamette = new Ramette(2, "Clairef", "CRA4S", "Ramette A4 Sup", 9f, 20, 80);
        Panier panier = new Panier(1);
        panier.addLigne(unBic, 2);
        panier.addLigne(unAutreBic, 1);
        panier.addLigne(uneRamette, 2);
        Serializer.serialize(panier);
        panier = Serializer.deserialize(Panier.class);
        System.out.println(panier);
    }
}
