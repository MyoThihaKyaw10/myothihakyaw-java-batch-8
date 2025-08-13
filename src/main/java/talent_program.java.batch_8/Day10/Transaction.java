package Day10;

import java.time.LocalDate;
import java.time.LocalDateTime;

enum TransactionType {
    EXPENSE, INCOME
}

enum Category {
    SALARY, TIP, SNACK, PH_BILL, TRAN_BILL, MEAL_BILL, PRESENT, SHOPPING, DONATION
}

public class Transaction {
    private int tran_id;
    private TransactionType tran_type;
    private Category tran_category;
    private Double amount;
    private String note;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private int delete_flag;

    public Transaction() {
        this.delete_flag = 0;
        this.created_at = LocalDateTime.now();
        this.updated_at = LocalDateTime.now();
        this.note = "";
    }

    public Transaction(TransactionType type, Category category, Double amount, LocalDate date, String note) {
        this.tran_type = type;
        this.tran_category = category;
        this.amount = amount;
        this.created_at = date.atStartOfDay();
        this.updated_at = LocalDateTime.now();
        this.delete_flag = 0;
        this.note = note;
    }

    // Getters and Setters
    public int getTran_id() { return tran_id; }
    public void setTran_id(int tran_id) { this.tran_id = tran_id; }
    public TransactionType getTran_type() { return tran_type; }
    public void setTran_type(TransactionType tran_type) { this.tran_type = tran_type; }
    public Category getTran_category() { return tran_category; }
    public void setTran_category(Category tran_category) { this.tran_category = tran_category; }
    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }
    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }
    public LocalDateTime getCreated_at() { return created_at; }
    public void setCreated_at(LocalDateTime created_at) { this.created_at = created_at; }
    public LocalDateTime getUpdated_at() { return updated_at; }
    public void setUpdated_at(LocalDateTime updated_at) { this.updated_at = updated_at; }
    public int getDelete_flag() { return delete_flag; }
    public void setDelete_flag(int delete_flag) { this.delete_flag = delete_flag; }
}
