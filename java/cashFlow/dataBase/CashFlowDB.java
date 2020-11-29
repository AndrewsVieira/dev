package dataBase;

import java.util.ArrayList;
import java.util.List;

import model.CashFlow;
import model.FinancialRecord;

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
            if (!repeatedDates(rev.getDate())) {
                dates.add(rev.getDate());
            }
        }
        for (FinancialRecord pay : payaments) {
            if (!repeatedDates(pay.getDate())) {
                dates.add(pay.getDate());
            }
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
