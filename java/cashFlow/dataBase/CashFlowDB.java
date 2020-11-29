package dataBase;

import java.util.ArrayList;
import java.util.List;

import model.CashFlow;
import model.FinancialRecord;
import model.utils.Date;

public class CashFlowDB {
    private static int id = 0;
    private static List<CashFlow> cashFlowRecords = new ArrayList<>();

    private static List<FinancialRecord> revenues = new ArrayList<>();
    private static List<FinancialRecord> payaments = new ArrayList<>();
    private static List<String> dates = new ArrayList<>();

    public static void setRevenues(List<FinancialRecord> revenues) {
        CashFlowDB.revenues = revenues;
    }

    public static void setPayaments(List<FinancialRecord> payaments) {
        CashFlowDB.payaments = payaments;
    }

    public static List<CashFlow> list() {
        loadCashFlowList();
        return cashFlowRecords;
    }

    private static void createOrReplace(CashFlow cashFlow) {
        int i = cashFlowRecords.indexOf(cashFlow);

        if (i >= 0) {
            cashFlowRecords.set(i, cashFlow);
        } else {
            cashFlow.setId(++id);
            cashFlowRecords.add(cashFlow);
        }
    }

    private static double getSumOfRevenueInDay(String date) {
        double sum = 0;

        for (FinancialRecord rev : revenues) {
            if (rev.getDate().equals(date))
                sum += rev.getValue();
        }

        return sum;
    }

    private static double getSumOfPayamentsInDay(String date) {
        double sum = 0;

        for (FinancialRecord pay : payaments) {
            if (pay.getDate().equals(date))
                sum += pay.getValue();
        }

        return sum;
    }

    private static void setDates() {
        for (FinancialRecord rev : revenues) {
            orderDates(rev.getDate());
        }
        for (FinancialRecord pay : payaments) {
            orderDates(pay.getDate());
        }
    }

    private static void orderDates(String date) {
        if (dates.size() > 0 && !repeatedDates(date)) {
            for (int i = 0; i < dates.size(); i++) {
                if (Date.lowestDate(date, dates.get(i)) && !repeatedDates(date)) {
                    dates.add(0, date);
                } else if (!repeatedDates(date)) {
                    dates.add(dates.size(), date);
                }

            }
        } else if (!repeatedDates(date)) {
            dates.add(date);
        }
    }

    private static boolean repeatedDates(String date) {
        boolean b = false;
        for (String dt : dates) {
            if (dt.equals(date)) {
                b = true;
                return b;
            }
        }
        return b;
    }

    private static void loadCashFlowList() {
        CashFlow cashFlow;

        cashFlowRecords.removeAll(cashFlowRecords);
        dates.removeAll(dates);

        setDates();
        for (int i = 0; i < dates.size(); i++) {

            cashFlow = new CashFlow();

            cashFlow.setDate(dates.get(i));
            cashFlow.setPayamentValue(getSumOfPayamentsInDay(cashFlow.getDate()));
            cashFlow.setRevenueValue(getSumOfRevenueInDay(cashFlow.getDate()));
            createOrReplace(cashFlow);

        }

    }
}
