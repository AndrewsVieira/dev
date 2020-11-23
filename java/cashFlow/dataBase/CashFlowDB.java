package dataBase;

import java.util.ArrayList;
import java.util.List;

import model.CashFlowRecord;

public class CashFlowDB {
    private static int id = 0;
    private static List<CashFlowRecord> records = new ArrayList<>();

    public static void create(CashFlowRecord record) {
        record.setId(++id);
        records.add(record);
    }

    public static void update(CashFlowRecord record) {
        int i = records.indexOf(record);
        if (i >= 0) {
            records.set(i, record);
        }
    }

    public static void delete(CashFlowRecord record) {
        records.remove(record);
    }

    public static List<CashFlowRecord> list() {
        return records;
    }

	public static void deleteAll() {
        for (CashFlowRecord record : records) {
            records.remove(record);
        }
	}
}
