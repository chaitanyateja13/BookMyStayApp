import java.util.*;

public class BookMyStayApp {

    static Queue<String> bookingQueue = new LinkedList<>();

    static Map<String, Integer> inventory = new HashMap<>();

    static Map<String, Set<String>> allocatedRooms = new HashMap<>();

    static int roomCounter = 1;

    public static void main(String[] args) {

        inventory.put("DELUXE", 2);
        inventory.put("STANDARD", 3);

        bookingQueue.add("DELUXE");
        bookingQueue.add("STANDARD");
        bookingQueue.add("DELUXE");

        processBookings();
    }

    public static void processBookings() {

        while(!bookingQueue.isEmpty()) {

            String roomType = bookingQueue.poll();

            int available = inventory.getOrDefault(roomType,0);

            if(available > 0) {

                String roomId = "ROOM-" + roomCounter++;

                allocatedRooms
                        .computeIfAbsent(roomType,k->new HashSet<>())
                        .add(roomId);

                inventory.put(roomType,available-1);

                System.out.println("Reservation confirmed : "+roomType+" -> "+roomId);

            } else {

                System.out.println("No rooms available for "+roomType);
            }
        }
    }
}