package model;

import java.util.Date;
import java.util.List;

public class CashFlow {
    // private List<String> dates;
    private String date;
    private double revenueValue;
    private double payamentValue;
    private double accumulatedBalance;
    private double prevBalance;

    public double getRevenueValue() {
        return revenueValue;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    // public List<String> getDates() {
    //     return dates;
    // }

    // public void setDates(List<String> dates) {
    //     this.dates = dates;
    // }

    public void setRevenueValue(double revenueValue) {
        this.revenueValue = revenueValue;
    }
}
