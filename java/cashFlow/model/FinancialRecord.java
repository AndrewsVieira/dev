package model;

import java.sql.Date;
import java.text.SimpleDateFormat;

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
        String newFormatDate = String.format("%s/%s/%s", getDayOfDate(originalFormatDate), getMonthOfDate(originalFormatDate),
                getYearOfDate(originalFormatDate));
        return newFormatDate;
    }

    private Object getDayOfDate(String originalFormatDate) {
        String day = "";
        for (int i = 0; i < originalFormatDate.length(); i++) {
            if (i > 7 && i < 10) {
                day += originalFormatDate.charAt(i);
            }
        }
        return day;
    }

    private Object getMonthOfDate(String originalFormatDate) {
        String month = "";
        for (int i = 0; i < originalFormatDate.length(); i++) {
            if (i > 4 && i < 7) {
                month += originalFormatDate.charAt(i);
            }
        }
        return month;
    }

    private String getYearOfDate(String originalFormatDate) {
        String year = "";
        for (int i = 0; i < originalFormatDate.length(); i++) {
            if (i >= 0 && i < 4) {
                year += originalFormatDate.charAt(i);
            }
        }
        return year;
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
