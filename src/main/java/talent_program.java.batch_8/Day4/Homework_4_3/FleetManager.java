package Day4.Homework_4_3;

import java.util.ArrayList;

public class FleetManager {
    public static void main(String[] args) {
        ArrayList<Vehicle> fleet = new ArrayList<>();
        fleet.add(new Car("Japan",2022,30));
        fleet.add(new Motorcycle("Germany", 2020, 10));
        fleet.add(new Car("USA", 2023, 25));

        for(Vehicle v : fleet){
            System.out.println("Vehicle Type: "+v.getVehicleType());
            System.out.println("Country: "+v.getCountry());
            System.out.println("Year: "+v.getYear());
            v.startEngine();
            v.drive();
            v.refuel(10);
            System.out.println();
        }
        System.out.println("Total numbers of vehicle in fleet: "+Vehicle.getTotalVehicles());
    }
}
