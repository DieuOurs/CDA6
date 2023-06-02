package fr.steve.papeterie.bo.utils;

import java.io.*;

public class Serializer {

    private static final String url = "C:\\Users\\shoareau.cda\\OneDrive - EXPERNET\\java\\SER\\target\\extract\\";

    public static void serialize(Object object) {
        try {
            FileOutputStream out = new FileOutputStream(url + object.getClass().toString() + ".ser");
            ObjectOutputStream oos = new ObjectOutputStream(out);
            oos.writeObject(object);
            oos.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static <T extends Serializable> T deserialize(Class<T> classe) throws SerializerException {
        try (FileInputStream fis = new FileInputStream(url + classe.toString() + ".ser");
             ObjectInputStream ois = new ObjectInputStream(fis)
        ) {
            return (T) ois.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        throw new SerializerException();
    }
}
