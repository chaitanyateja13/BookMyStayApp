import java.io.*;
import java.util.*;

public class BookMyStayApp {

    static List<String> bookings = new ArrayList<>();

    public static void main(String[] args) throws Exception{

        bookings.add("RES-1 DELUXE");
        bookings.add("RES-2 STANDARD");

        saveState();

        loadState();
    }

    public static void saveState() throws Exception{

        ObjectOutputStream oos =
                new ObjectOutputStream(new FileOutputStream("bookings.dat"));

        oos.writeObject(bookings);

        oos.close();

        System.out.println("State saved");
    }

    public static void loadState() throws Exception{

        ObjectInputStream ois =
                new ObjectInputStream(new FileInputStream("bookings.dat"));

        List<String> data = (List<String>) ois.readObject();

        System.out.println("Recovered Data");

        for(String s:data){
            System.out.println(s);
        }

        ois.close();
    }
}