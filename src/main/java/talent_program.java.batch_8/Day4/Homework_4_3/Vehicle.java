package Day4.Homework_4_3;

public class Vehicle {
    private String country;
    private int year;
    private double fuelLevel;
    private String vehicleType;
    private static int totalVehicles = 0;

    public Vehicle(String country, int year, double fuelLevel, String vehicleType) {
        this.country = country;
        this.year = year;
        this.fuelLevel = fuelLevel;
        this.vehicleType = vehicleType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(double fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void startEngine(){
        System.out.println("The engine has started.");
    }

    public void drive(){
        System.out.println("The vehicle is now driving.");
    }

    public void refuel(double amount){
        fuelLevel += amount;
        System.out.println("The "+vehicleType+" has been refueled. Current fuel level: "+fuelLevel+" liters.");
    }

    public static int getTotalVehicles(){
        return totalVehicles;
    }
}
