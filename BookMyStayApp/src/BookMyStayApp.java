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

class SingleRoom extends Room {
    public SingleRoom() { super("Single", 1, 100); }
    public void displayDetails() { System.out.println(type + " Room: Beds=" + beds + ", Price=" + price); }
}

class DoubleRoom extends Room {
    public DoubleRoom() { super("Double", 2, 180); }
    public void displayDetails() { System.out.println(type + " Room: Beds=" + beds + ", Price=" + price); }
}

class SuiteRoom extends Room {
    public SuiteRoom() { super("Suite", 3, 300); }
    public void displayDetails() { System.out.println(type + " Room: Beds=" + beds + ", Price=" + price); }
}

public class BookMyStayApp {

    public static void main(String[] args) {
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        single.displayDetails();
        doubleRoom.displayDetails();
        suite.displayDetails();
    }
}