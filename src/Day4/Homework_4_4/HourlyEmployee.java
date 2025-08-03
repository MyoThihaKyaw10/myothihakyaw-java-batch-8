package Day4.Homework_4_4;

public class HourlyEmployee extends Employee{
    private double hourlyRate;
    private double hoursWorked;

    public HourlyEmployee(String name, int id, double hourlyRate, double hoursWorked) {
        super(name, id);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculatePay() {
        if(hoursWorked > 40){
            double overtimeHours = hoursWorked - 40;
            return (40 * hourlyRate) + (overtimeHours * hourlyRate * 1.5);
        }
        return hourlyRate * hoursWorked;
    }

    @Override
    public String toString() {
        return super.toString()+" [Hourly Employee | Rate: $" + hourlyRate + " | Hours: " + hoursWorked + "]";
    }
}
