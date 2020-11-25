package model;

import java.util.Date;

public class CashFlow {
    private Date date;
    private double revenueValue;
    private double payamentValue;
    private double accumulatedBalance;
    private double prevBalance;

    public double getRevenueValue() {
        return revenueValue;
    }

    public double getPrevBalance() {
        return prevBalance;
    }

    public void setPrevBalance(double prevBalance) {
        this.prevBalance = prevBalance;
    }

    public double getAccumulatedBalance() {
        return accumulatedBalance;
    }

    public void setAccumulatedBalance(double accumulatedBalance) {
        this.accumulatedBalance = accumulatedBalance;
    }

    public double getPayamentValue() {
        return payamentValue;
    }

    public void setPayamentValue(double payamentValue) {
        this.payamentValue = payamentValue;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setRevenueValue(double revenueValue) {
        this.revenueValue = revenueValue;
    }
}
