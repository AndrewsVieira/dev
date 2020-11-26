package dataBase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.CashFlow;
import model.FinancialRecord;

public class CashFlowDB {

    private static List<CashFlow> cashFlowRecords = new ArrayList<>();

    private static List<FinancialRecord> revenues = new ArrayList<>();
    private static List<FinancialRecord> payaments = new ArrayList<>();
    private static List<String> dates = new ArrayList<>();

    private static double openingBalance = 0.00;
    private static int index = 0;

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

    private static void loadCashFlowList() {

        CashFlow cashFlow = new CashFlow();
        setDates();
        cashFlow.setDate(dates.get(index));
        cashFlow.setPayamentValue(getSumOfPayamentsInDay(cashFlow.getDate()));
        cashFlow.setRevenueValue(getSumOfRevenueInDay(cashFlow.getDate()));
        cashFlow.setPrevBalance(openingBalance);
        cashFlow.setAccumulatedBalance(
                    cashFlow.getPrevBalance()
                +   cashFlow.getRevenueValue()
                -   cashFlow.getPayamentValue()
        );
        openingBalance = cashFlow.getAccumulatedBalance();

        cashFlowRecords.add(cashFlow);

    }

    private static double getSumOfRevenueInDay(String date) {
        double sum = 0;

        for (FinancialRecord rev : revenues) {
            for (String d : dates) {
                if (d.equals(rev.getDate()))
                    sum += rev.getValue();
            }
        }

        return sum;
    }

    private static double getSumOfPayamentsInDay(String date) {
        double sum = 0;

        for (FinancialRecord pay : payaments) {
            for (String d : dates) {
                if (d.equals(pay.getDate()))
                    sum += pay.getValue();
            }
        }

        return sum;
    }

    private static void setDates() {
        for (FinancialRecord rev : revenues) {
            dates.add(rev.getDate());
        }
        for (FinancialRecord pay : payaments) {
            dates.add(pay.getDate());
        }

        repeatedRemoverOfDates();

    }

    private static void repeatedRemoverOfDates() {
        for (int i = 0; i < dates.size(); i++) {
            for (int j = 0; j < dates.size(); j++) {
                if (dates.get(i).equals(dates.get(j))) {
                    dates.remove(j);
                }
            }
        }
    }

}
