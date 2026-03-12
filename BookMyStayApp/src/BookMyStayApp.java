import java.util.*;

class Service{

    String name;
    int cost;

    Service(String name,int cost){
        this.name=name;
        this.cost=cost;
    }
}

public class BookMyStayApp {

    static Map<String,List<Service>> reservationServices = new HashMap<>();

    public static void main(String[] args) {

        addService("RES-1", new Service("Breakfast",500));
        addService("RES-1", new Service("Airport Pickup",1000));

        calculateCost("RES-1");
    }

    public static void addService(String reservationId, Service service){

        reservationServices
                .computeIfAbsent(reservationId,k->new ArrayList<>())
                .add(service);

        System.out.println(service.name+" added to "+reservationId);
    }

    public static void calculateCost(String reservationId){

        List<Service> services = reservationServices.get(reservationId);

        int total = 0;

        for(Service s : services){
            total += s.cost;
        }

        System.out.println("Total Add-on Cost: "+total);
    }
}