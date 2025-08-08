package Day9;

import java.time.LocalDate;

enum TransactionType{
    EXPENSE, INCOME
}

enum Category{
    SALARY, TIP, SNACK, PH_BILL, TRAN_BILL, MEAL_BILL, PRESENT, SHOPPING, DONATION
}
class Transaction {
    private static int counter = 1;
    private int transactionId;
    private TransactionType type;
    private Category category;
    private double amount;
    private LocalDate transactionDate;

    public Transaction(TransactionType type, Category category, double amount, LocalDate transcationDate) {
        this.transactionId = counter++;
        this.type = type;
        this.category = category;
        this.amount = amount;
        this.transactionDate = transcationDate;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public TransactionType getType() {
        return type;
    }

    public Category getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    @Override
    public String toString() {
        return String.format("ID:%d | %s | %s | %.2f | %s",
                transactionId, type, category, amount, transactionDate);
    }
}
