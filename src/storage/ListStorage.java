package storage;

import controller.Storage;
import model.Destillat;
import model.Fad;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ListStorage implements Storage {
    private static final ArrayList<Destillat> destillater = new ArrayList<>();
    private static final ArrayList<Fad> fade = new ArrayList<>();
    //---------------------------------------------------------------------

    public List<Destillat> getDestillater() {
        return new ArrayList<>(destillater);
    }
    public void storeDestillat(Destillat d) {
        destillater.add(d);
    }

    //---------------------------------------------------------------------

    public List<Fad> getFade(){
        return new ArrayList<>(fade);
    }
    public void storeFad(Fad f) {
        fade.add(f);
    }

    //---------------------------------------------------------------------


    // load og save metoder
    public static ListStorage loadStorage() {
        String fileName = "src/storage/storage.ser";
        try (FileInputStream fileIn = new FileInputStream(fileName);
             ObjectInputStream objIn = new ObjectInputStream(fileIn)
        ) {
            Object obj = objIn.readObject();
            ListStorage storage = (ListStorage) obj;
            System.out.println("Storage loaded from file " + fileName);
            return storage;
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error deserializing storage");
            System.out.println(ex);
            return null;
        }
    }

    public static void saveStorage(Storage storage) {
        String fileName = "src/storage/storage.ser";
        try (FileOutputStream fileOut = new FileOutputStream(fileName);
             ObjectOutputStream objOut = new ObjectOutputStream(fileOut)
        ) {
            objOut.writeObject(storage);
            System.out.println("Storage saved in file " + fileName);
        } catch (IOException ex) {
            System.out.println("Error serializing storage");
            System.out.println(ex);
            throw new RuntimeException();
        }
    }
}
