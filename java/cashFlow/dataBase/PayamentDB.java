package dataBase;

import java.util.ArrayList;
import java.util.List;

import model.FinancialRecord;

public class PayamentDB {
    private static List<FinancialRecord> payaments = new ArrayList<>();
    private static int id = 0;

    public static void insert(FinancialRecord payament) {
        payament.setId(++id);
        payaments.add(payament);
        System.out.println(payament);
    }

    public static void update(FinancialRecord payament) {
        int i = payaments.indexOf(payament);
        if (i >= 0) {
            payaments.set(i, payament);
        }
    }

    public static void delete(FinancialRecord payament) {
        payaments.remove(payament);
    }

    public static List<FinancialRecord> list() {
        return payaments;
    }
}
