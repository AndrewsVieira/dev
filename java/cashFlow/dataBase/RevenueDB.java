package dataBase;

import java.util.ArrayList;
import java.util.List;

import model.FinancialRecord;

public class RevenueDB {
    private static int id = 0;
    private static List<FinancialRecord> revenues = new ArrayList<>();

    public static void insert(FinancialRecord revenue) {
        revenue.setId(++id);
        revenues.add(revenue);
        System.out.println(revenue);
    }

    public static void update(FinancialRecord revenue) {
        int i = revenues.indexOf(revenue);
        if (i >= 0) {
            revenues.set(i, revenue);
        }
    }

    public static void delete(FinancialRecord revenue) {
        revenues.remove(revenue);
    }

    public static List<FinancialRecord> list() {
        return revenues;
    }
}
