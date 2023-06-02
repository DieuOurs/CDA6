package fr.steve.papeterie.bo.utils;

public class SerializerException extends Exception {

    public SerializerException() {
        super("L'objet sérialisé n'est pas un objet ou n'est pas un objet implémentant Serializable");
    }
}
