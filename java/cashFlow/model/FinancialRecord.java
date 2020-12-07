package model;

import java.sql.Date;

import model.utils.StringDate;

public abstract class FinancialRecord {
    private int id;
    private Date date;
    private String description;
    private double value;

    public double getValue() {
        return value;
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
        String originalFormatDate = date.toString();
        String newFormatDate = String.format("%s/%s/%s", StringDate.getDayOfDate(originalFormatDate),
                StringDate.getMonthOfDate(originalFormatDate), StringDate.getYearOfDate(originalFormatDate));
        return newFormatDate;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setValue(double value) {
        this.value = value;
    }

    abstract public Object getClientOrProvider();
}
