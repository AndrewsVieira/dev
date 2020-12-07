package model;

import java.sql.Date;

import model.utils.StringDate;

public class CashFlowRecord {
    private Date date;
    private double revenueValue;
    private double payamentValue;

    public double getRevenueValue() {
        return revenueValue;
    }

    public Date getDate() {
        return date;
    }

    public String getStringDate() {
        String originalFormatDate = date.toString();
        String newFormatDate = String.format("%s/%s/%s", StringDate.getDayOfDate(originalFormatDate),
                StringDate.getMonthOfDate(originalFormatDate), StringDate.getYearOfDate(originalFormatDate));
        return newFormatDate;
    }

    public void setDate(Date date) {
        this.date = date;
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
}
