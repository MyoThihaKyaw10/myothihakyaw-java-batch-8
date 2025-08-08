package Day9;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ExpenseTracker {
    private static ArrayList<Transaction> transactions = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while(true){
            double balance = calculateBalance();
            System.out.println();
            System.out.println("=== Finance Tracker ===");
            System.out.println("Current Balance: "+balance);
            System.out.println("1. Add Expense");
            System.out.println("2. Add Income");
            System.out.println("3. View All Transactions");
            System.out.println("4. View Transactions by Category");
            System.out.println("5. View Expense and Income Monthly Summary");
            System.out.println("6. Remove Transaction");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1" -> addTransaction(TransactionType.EXPENSE);
                case "2" -> addTransaction(TransactionType.INCOME);
                case "3" -> viewAllTransactions();
                case "4" -> viewTransactionsByCategory(transactions);
                case "5" -> viewMonthlySummary();
                case "6" -> removeTransaction();
                case "0" -> {
                    saveData(transactions);
                    System.out.println("Data saved. Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static void addTransaction(TransactionType type){
        try{
            System.out.println("Select Category: "+ Arrays.toString(Category.values()));
            Category category = Category.valueOf(sc.nextLine().toUpperCase());

            System.out.println("Enter amount: ");
            double amount = Double.parseDouble(sc.nextLine());

            System.out.println("Enter transaction date (dd/MM/yyyy): ");
            String dateInput = sc.nextLine();
            LocalDate date = LocalDate.parse(dateInput, DATE_FORMATTER);

            transactions.add(new Transaction(type, category, amount, date));
            System.out.println("Transaction added.");
        }
        catch (IllegalArgumentException e){
            System.out.println("Invalid category or amount.");
        }
        catch (DateTimeParseException e){
            System.out.println("Invalid date format. Please use dd/MM/yyyy.");
        }
    }

    private static void viewAllTransactions(){
        if(transactions.isEmpty()){
            System.out.println("No transactions found.");
            return;
        }
        transactions.forEach(System.out::println);
    }

    public static void viewTransactionsByCategory(List<Transaction> transactions) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter category: ");
        String input = sc.nextLine().trim();

        Category selectedCategory = null;
        for (Category c : Category.values()) {
            if (c.name().equalsIgnoreCase(input)) {
                selectedCategory = c;
                break;
            }
        }
        if (selectedCategory == null) {
            System.out.println("Invalid category. Available categories:");
            for (Category c : Category.values()) {
                System.out.println("- " + c.name());
            }
            return;
        }

        boolean found = false;
        for (Transaction t : transactions) {
            if (t.getCategory() == selectedCategory) {
                System.out.println(t);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No transactions found for category: " + selectedCategory.name());
        }
    }

    private static void viewMonthlySummary() {
        Map<String, Double> expenseTotals = new HashMap<>();
        Map<String, Double> incomeTotals = new HashMap<>();
        for (Transaction t : transactions) {
            String month = t.getTransactionDate().toString().substring(0, 7); // "yyyy-MM"
            if (t.getType() == TransactionType.EXPENSE) {
                expenseTotals.put(month, expenseTotals.getOrDefault(month, 0.0) + t.getAmount());
            } else {
                incomeTotals.put(month, incomeTotals.getOrDefault(month, 0.0) + t.getAmount());
            }
        }
        if (expenseTotals.isEmpty() && incomeTotals.isEmpty()) {
            System.out.println("No transactions found.");
            return;
        }
        Set<String> allMonths = new HashSet<>();
        allMonths.addAll(expenseTotals.keySet());
        allMonths.addAll(incomeTotals.keySet());
        List<String> sortedMonths = new ArrayList<>(allMonths);
        Collections.sort(sortedMonths);

        for (String month : sortedMonths) {
            System.out.printf("%s -> Expenses: %.2f | Income: %.2f%n",
                    month,
                    expenseTotals.getOrDefault(month, 0.0),
                    incomeTotals.getOrDefault(month, 0.0));
        }
    }

    private static void removeTransaction() {
        System.out.println("All Transactions:");
        for (Transaction t : transactions) {
            System.out.println(t); // Assuming toString() shows all details
        }

        System.out.print("Enter transaction ID to remove: ");
        try {
            int id = Integer.parseInt(sc.nextLine());
            boolean removed = transactions.removeIf(t -> t.getTransactionId() == id);
            if (removed) {
                System.out.println("Transaction removed.");
            } else {
                System.out.println("Transaction ID not found.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID.");
        }
    }

    private static double calculateBalance() {
        double balance = 0;
        for (Transaction t : transactions) {
            if (t.getType() == TransactionType.INCOME) {
                balance += t.getAmount();
            } else {
                balance -= t.getAmount();
            }
        }
        return balance;
    }

    private static void saveData(List<Transaction> transactions) {
        try (PrintWriter pw = new PrintWriter(new FileWriter("E:\\MTHK\\ACEPLUS\\JAVA\\transactions.txt"))) {
            for (Transaction t : transactions) {
                String line = String.format("%d,%s,%s,%.2f,%s",
                        t.getTransactionId(),
                        t.getType(),
                        t.getCategory(),
                        t.getAmount(),
                        t.getTransactionDate());
                pw.println(line);
            }
            System.out.println("Saving data.");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }
}
