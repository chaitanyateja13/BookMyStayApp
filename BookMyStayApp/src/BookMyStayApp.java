import java.util.*;

public class BookMyStayApp {

    static Stack<String> releasedRooms = new Stack<>();

    static Map<String,Integer> inventory = new HashMap<>();

    public static void main(String[] args){

        inventory.put("DELUXE",1);

        cancelBooking("ROOM-1","DELUXE");

        System.out.println("Released Rooms "+releasedRooms);
    }

    public static void cancelBooking(String roomId,String type){

        releasedRooms.push(roomId);

        inventory.put(type,inventory.get(type)+1);

        System.out.println("Booking cancelled for "+roomId);
    }
}