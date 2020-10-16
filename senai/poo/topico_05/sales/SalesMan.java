package sales;

public class SalesMan {
    private String name;
    private double totalSoldInTheMonth;
    private double salary;
    private double salaryCommission;
    private final double COMMISSION = 0.05;

    public SalesMan(String name) {
        this.name = name;
        this.salary = 1045.00;
    }

    public void setTotalSoldInTheMonth(double amount, int numberProduct) {
        Product.setPriceSale(amount, numberProduct);
        this.totalSoldInTheMonth += Product.getPriceSale();
    }

    public double getTotalSoldInTheMonth() {
        return this.totalSoldInTheMonth;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setSalaryCommission() {
        this.totalSoldInTheMonth = totalSoldInTheMonth > 0 ? totalSoldInTheMonth : 0.00;
        this.salaryCommission = this.totalSoldInTheMonth * COMMISSION;
    }

    public double getSalaryCommission() {
        setSalaryCommission();
        return this.salaryCommission;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return String.format("%s\t%s%n%s\t%.2f%n%s\t%.2f%n%n", "Vendedor", getName(), "Total vendido",
                getTotalSoldInTheMonth(), "Salário do mês", getSalaryCommission() + getSalary());
    }
}
