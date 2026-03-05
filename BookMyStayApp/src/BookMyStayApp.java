import java.util.HashMap;

// Inventory class
class RoomInventory {
    HashMap<String, Integer> availability = new HashMap<>();

    public RoomInventory() {
        availability.put("Single", 10);
        availability.put("Double", 5);
        availability.put("Suite", 2);
    }

    public int getAvailability(String type) {
        return availability.getOrDefault(type, 0);
    }
}

// Abstract Room class
abstract class Room {
    String type;
    int beds;
    double price;

    public Room(String type, int beds, double price) {
        this.type = type;
        this.beds = beds;
        this.price = price;
    }

    public abstract void displayDetails();
}

// Concrete Room classes
class SingleRoom extends Room {
    public SingleRoom() { super("Single", 1, 100); }
    public void displayDetails() {
        System.out.println(type + " Room: Beds=" + beds + ", Price=" + price);
    }
}

class DoubleRoom extends Room {
    public DoubleRoom() { super("Double", 2, 180); }
    public void displayDetails() {
        System.out.println(type + " Room: Beds=" + beds + ", Price=" + price);
    }
}

class SuiteRoom extends Room {
    public SuiteRoom() { super("Suite", 3, 300); }
    public void displayDetails() {
        System.out.println(type + " Room: Beds=" + beds + ", Price=" + price);
    }
}

// Main Application
public class BookMyStayApp {

    public static void main(String[] args) {
        RoomInventory inventory = new RoomInventory();
        Room[] rooms = { new SingleRoom(), new DoubleRoom(), new SuiteRoom() };

        System.out.println("Guest search results (rooms with availability > 0):");
        for(Room r : rooms) {
            int available = inventory.getAvailability(r.type);
            if(available > 0) {
                System.out.print(r.type + " room is available. ");
                r.displayDetails();
                System.out.println("Remaining: " + available);
            }
        }
    }
}