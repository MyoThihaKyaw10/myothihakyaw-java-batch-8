package Day4.Homework_4_4;

public class SalariedEmployee extends Employee{
    private double annualSalary;

    public SalariedEmployee(String name, int id, double annualSalary) {
        super(name, id);
        this.annualSalary = annualSalary;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }

    @Override
    public double calculatePay() {
        return annualSalary / 12;
    }

    @Override
    public String toString() {
        return super.toString()+" [Salaried Employee | Annual Salary: $" + annualSalary + "]";
    }
}
