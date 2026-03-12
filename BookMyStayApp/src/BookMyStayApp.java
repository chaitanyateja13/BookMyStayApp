import java.util.*;

class InvalidBookingException extends Exception{

    InvalidBookingException(String message){
        super(message);
    }
}

public class BookMyStayApp {

    static Map<String,Integer> inventory = new HashMap<>();

    public static void main(String[] args){

        inventory.put("DELUXE",1);

        try{

            bookRoom("DELUXE");

            bookRoom("SUITE");

        }catch(Exception e){

            System.out.println("Booking Failed : "+e.getMessage());
        }
    }

    public static void bookRoom(String type) throws InvalidBookingException{

        if(!inventory.containsKey(type)){

            throw new InvalidBookingException("Invalid Room Type");
        }

        int available = inventory.get(type);

        if(available<=0){

            throw new InvalidBookingException("No rooms available");
        }

        inventory.put(type,available-1);

        System.out.println("Room booked "+type);
    }
}