package model;

public class CashFlowRecord extends FinancialRecord {

    private RevenueRecord revenue;
    private PayamentRecord payament;
    private double balance;

    public void setBalance(double balance) {
        this.balance = revenue.getValue() - payament.getValue();
    }
    
    public double getBalance() {
        return balance;
    }

    public void setPayament(PayamentRecord payament) {
        this.payament = payament;
    }

    public void setRevenue(RevenueRecord revenue) {
        this.revenue = revenue;
    }

    public PayamentRecord getPayament() {
        return payament;
    }

    public RevenueRecord getRevenue() {
        return revenue;
    }
    
    @Override
    public Object getClientOrProvider() {
        return null;
    }
    
}
