import java.util.*;

class Reservation{

    String id;
    String roomType;

    Reservation(String id,String roomType){
        this.id=id;
        this.roomType=roomType;
    }
}

public class BookMyStayApp {

    static List<Reservation> bookingHistory = new ArrayList<>();

    public static void main(String[] args) {

        confirmBooking("RES1","DELUXE");
        confirmBooking("RES2","STANDARD");

        showHistory();
    }

    public static void confirmBooking(String id,String room){

        Reservation r = new Reservation(id,room);

        bookingHistory.add(r);

        System.out.println("Booking confirmed "+id);
    }

    public static void showHistory(){

        for(Reservation r:bookingHistory){

            System.out.println(r.id+" -> "+r.roomType);
        }
    }
}