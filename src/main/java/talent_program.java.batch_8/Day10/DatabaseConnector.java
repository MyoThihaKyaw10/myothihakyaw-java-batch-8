package Day10;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class DatabaseConnector {

    private static final Scanner sc = new Scanner(System.in);
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {
        while (true) {
            double balance = calculateBalance();
            System.out.println("\n=== Finance Tracker ===");
            System.out.println("Current Balance: " + balance);
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
                case "4" -> viewTransactionsByCategory();
                case "5" -> viewMonthlySummary();
                case "6" -> removeTransaction();
                case "0" -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    // Connect to database
    public static Connection connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/transactionDB", "root", "");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL driver not found.");
        } catch (SQLException e) {
            System.out.println("Database connection failed: " + e.getMessage());
        }
        return null;
    }

    // Add transaction
    private static void addTransaction(TransactionType type) {
        try {
            System.out.println("Select Category: " + Arrays.toString(Category.values()));
            Category category = Category.valueOf(sc.nextLine().toUpperCase());

            System.out.println("Enter amount: ");
            double amount = Double.parseDouble(sc.nextLine());

            System.out.println("Enter transaction date (dd/MM/yyyy): ");
            String dateInput = sc.nextLine();
            LocalDate date = LocalDate.parse(dateInput, DATE_FORMATTER);

            Transaction transaction = new Transaction(type, category, amount, date, type + " of " + amount);

            try (Connection connection = connect()) {
                if (connection != null) addTransactionToDB(transaction, connection);
                else System.out.println("Cannot save transaction. Database connection failed.");
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Invalid category or amount.");
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please use dd/MM/yyyy.");
        } catch (SQLException e) {
            System.out.println("Error while inserting transaction: " + e.getMessage());
        }
    }

    // Insert transaction into DB
    private static void addTransactionToDB(Transaction t, Connection connection) throws SQLException {
        String sql = "INSERT INTO transactions(tran_type, tran_category, amount, note, created_at, updated_at, delete_flag) VALUES (?,?,?,?,?,?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, t.getTran_type().toString());
            stmt.setString(2, t.getTran_category().toString());
            stmt.setDouble(3, t.getAmount());
            stmt.setString(4, t.getNote());
            stmt.setTimestamp(5, Timestamp.valueOf(t.getCreated_at()));
            stmt.setTimestamp(6, Timestamp.valueOf(t.getUpdated_at()));
            stmt.setInt(7, t.getDelete_flag());
            stmt.executeUpdate();
            System.out.println("Transaction added to DB.");
        }
    }

    // View all transactions
    private static void viewAllTransactions() {
        try (Connection connection = connect()) {
            if (connection == null) return;
            String sql = "SELECT tran_id, tran_type, tran_category, amount, created_at, note FROM transactions ORDER BY created_at";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                ResultSet rs = stmt.executeQuery();
                boolean found = false;
                while (rs.next()) {
                    int id = rs.getInt("tran_id");
                    String type = rs.getString("tran_type");
                    String category = rs.getString("tran_category");
                    double amount = rs.getDouble("amount");
                    Timestamp ts = rs.getTimestamp("created_at");
                    String note = rs.getString("note");

                    System.out.printf("ID:%d | %s | %s | %.2f | %s | %s%n",
                            id, type, category, amount, ts.toLocalDateTime().toLocalDate(), note);
                    found = true;
                }
                if (!found) System.out.println("No transactions found.");
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving transactions: " + e.getMessage());
        }
    }

    // View transactions by category
    private static void viewTransactionsByCategory() {
        System.out.print("Enter category: ");
        String input = sc.nextLine().trim().toUpperCase();

        try (Connection connection = connect()) {
            if (connection == null) return;
            String sql = "SELECT tran_id, tran_type, tran_category, amount, created_at, note FROM transactions WHERE tran_category = ?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, input);
                ResultSet rs = stmt.executeQuery();
                boolean found = false;
                while (rs.next()) {
                    int id = rs.getInt("tran_id");
                    String type = rs.getString("tran_type");
                    String category = rs.getString("tran_category");
                    double amount = rs.getDouble("amount");
                    Timestamp ts = rs.getTimestamp("created_at");
                    String note = rs.getString("note");

                    System.out.printf("ID:%d | %s | %s | %.2f | %s | %s%n",
                            id, type, category, amount, ts.toLocalDateTime().toLocalDate(), note);
                    found = true;
                }
                if (!found) System.out.println("No transactions found for category: " + input);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving transactions: " + e.getMessage());
        }
    }

    // Monthly summary
    private static void viewMonthlySummary() {
        try (Connection connection = connect()) {
            if (connection == null) return;
            String sql = "SELECT tran_type, amount, created_at FROM transactions";
            Map<String, Double> expenseTotals = new HashMap<>();
            Map<String, Double> incomeTotals = new HashMap<>();

            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    String type = rs.getString("tran_type");
                    double amount = rs.getDouble("amount");
                    Timestamp ts = rs.getTimestamp("created_at");
                    String month = ts.toLocalDateTime().toLocalDate().toString().substring(0, 7); // yyyy-MM

                    if ("EXPENSE".equalsIgnoreCase(type)) {
                        expenseTotals.put(month, expenseTotals.getOrDefault(month, 0.0) + amount);
                    } else {
                        incomeTotals.put(month, incomeTotals.getOrDefault(month, 0.0) + amount);
                    }
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
        } catch (SQLException e) {
            System.out.println("Error calculating monthly summary: " + e.getMessage());
        }
    }

    // Remove transaction by ID
    private static void removeTransaction() {
        System.out.print("Enter transaction ID to remove: ");
        try {
            int id = Integer.parseInt(sc.nextLine());

            try (Connection connection = connect()) {
                if (connection == null) return;
                String sql = "DELETE FROM transactions WHERE tran_id = ?";
                try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                    stmt.setInt(1, id);
                    int rows = stmt.executeUpdate();
                    if (rows > 0) System.out.println("Transaction removed.");
                    else System.out.println("Transaction ID not found.");
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID.");
        } catch (SQLException e) {
            System.out.println("Error removing transaction: " + e.getMessage());
        }
    }

    // Calculate current balance
    private static double calculateBalance() {
        double balance = 0;
        try (Connection connection = connect()) {
            if (connection == null) return balance;

            String sql = "SELECT tran_type, amount FROM transactions";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    String type = rs.getString("tran_type");
                    double amount = rs.getDouble("amount");
                    if ("INCOME".equalsIgnoreCase(type)) balance += amount;
                    else balance -= amount;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error calculating balance: " + e.getMessage());
        }
        return balance;
    }
}
