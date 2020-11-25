package dataBase;

import java.util.ArrayList;
import java.util.List;

import model.CashFlow;
import model.FinancialRecord;
import model.PayamentRecord;
import model.RevenueRecord;

public class CashFlowDB {

    private static List<CashFlow> cashFlowRecords = new ArrayList<>();

    private static List<FinancialRecord> revenues = new ArrayList<>();
    private static List<FinancialRecord> payaments = new ArrayList<>();

	public static void setRevenues(List<FinancialRecord> revenues) {
        CashFlowDB.revenues = revenues;
    }

    public static void setPayaments(List<FinancialRecord> payaments) {
        CashFlowDB.payaments = payaments;
    }

	public static List<CashFlow> list() {
		return cashFlowRecords;
	}




}
