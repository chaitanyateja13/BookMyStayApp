import java.util.HashMap;

class RoomInventory {
    HashMap<String, Integer> availability = new HashMap<>();

    public RoomInventory() {
        availability.put("Single", 10);
        availability.put("Double", 5);
        availability.put("Suite", 2);
    }

    public int getAvailability(String type) { return availability.getOrDefault(type, 0); }
    public void bookRoom(String type) {
        if(getAvailability(type) > 0) availability.put(type, getAvailability(type)-1);
    }
}

public class BookMyStayApp {

    public static void main(String[] args) {
        RoomInventory inventory = new RoomInventory();

        System.out.println("Single rooms available: " + inventory.getAvailability("Single"));
        System.out.println("Double rooms available: " + inventory.getAvailability("Double"));
        System.out.println("Suite rooms available: " + inventory.getAvailability("Suite"));
    }
}