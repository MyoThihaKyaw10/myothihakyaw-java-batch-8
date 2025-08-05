package Day4.Homework_4_3;

public class Motorcycle extends Vehicle{
    public Motorcycle(String country, int year, double fuelLevel) {
        super(country, year, fuelLevel,"Motorcycle");
    }

    @Override
    public void startEngine() {
        System.out.println("The motorcycle engine has started.");
    }

    @Override
    public void drive() {
        System.out.println("The motorcycle is now driving.");
    }

    @Override
    public String getVehicleType() {
        return "Motorcycle";
    }
}
