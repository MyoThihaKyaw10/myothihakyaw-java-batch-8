package Day4.Homework_4_3;

public class Car extends Vehicle{
    public Car(String country, int year, double fuelLevel) {
        super(country, year, fuelLevel,"Car");
    }

    @Override
    public void startEngine() {
        System.out.println("The car engine has started.");
    }

    @Override
    public void drive() {
        System.out.println("The car is now driving.");
    }

    @Override
    public String getVehicleType() {
        return "Car";
    }
}
