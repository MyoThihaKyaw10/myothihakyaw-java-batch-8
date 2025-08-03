package Day4.Homework_4_4;

import java.util.ArrayList;

public class Payroll {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new HourlyEmployee("Alice", 101, 20.0, 45));
        employees.add(new HourlyEmployee("Bob", 102, 18.5, 38));
        employees.add(new SalariedEmployee("Charlie", 103, 60000));

        System.out.println("Monthly Payroll");
        System.out.println();
        for(Employee e : employees){
            System.out.println(e.toString());
            System.out.println("Monthly Pay: $"+e.calculatePay());
            System.out.println();
        }
    }
}
