package bean.Committee;

public class Expense {
    private int id;
    private String description;
    private double amount;
    private double total_amount;

    public Expense() {
    }

    public Expense(int id, String description, double amount, double total_amount) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.total_amount = total_amount;
    }

    public Expense(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(double total_amount) {
        this.total_amount = total_amount;
    }
}
