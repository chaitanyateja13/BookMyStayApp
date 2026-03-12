import java.util.*;

public class BookMyStayApp {

    static int inventory = 2;

    public static synchronized void bookRoom(String guest){

        if(inventory>0){

            System.out.println(guest+" booked room");

            inventory--;

        }else{

            System.out.println("No room for "+guest);
        }
    }

    public static void main(String[] args){

        Thread t1 = new Thread(()->bookRoom("Guest1"));

        Thread t2 = new Thread(()->bookRoom("Guest2"));

        Thread t3 = new Thread(()->bookRoom("Guest3"));

        t1.start();
        t2.start();
        t3.start();
    }
}