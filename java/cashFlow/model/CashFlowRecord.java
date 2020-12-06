package model;

import java.sql.Date;

public class CashFlowRecord {
    private int id;
    private Date date;
    private double revenueValue;
    private double payamentValue;
    private double accumulatedBalance;
    private double prevBalance;

    public double getRevenueValue() {
        return revenueValue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public String getStringDate() {
        return String.format("%d/%d/%d",1, 2, 3);
    }

    public void setDate(Date date) {
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

    public void setRevenueValue(double revenueValue) {
        this.revenueValue = revenueValue;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }
        
        if (this.getClass() != obj.getClass()) {
            return false;
        }

        CashFlowRecord cashFlow = (CashFlowRecord) obj;
        return this.id == cashFlow.id;
    }
}
