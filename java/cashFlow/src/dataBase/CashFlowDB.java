package src.dataBase;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import src.connection.ConnectionFactory;
import src.model.CashFlowRecord;
import src.model.FinancialRecord;

public class CashFlowDB {
    public static List<CashFlowRecord> list() {
        List<CashFlowRecord> records = new ArrayList<>();

        List<Date> dates = getDates();

        for (Date date : dates) {
            CashFlowRecord cashFlowRecord = new CashFlowRecord();
            cashFlowRecord.setDate(date);
            cashFlowRecord.setPayamentValue(sumPayamentOfDate(date));
            cashFlowRecord.setRevenueValue(sumRevenueOfDate(date));
            records.add(cashFlowRecord);
        }

        return records;
    }

    private static double sumRevenueOfDate(Date date) {
        double sum = 0;

        for (FinancialRecord rev : RevenueDB.list()) {
            if (rev.getDate().equals(date))
                sum += rev.getValue();
        }

        return sum;
    }

    private static double sumPayamentOfDate(Date date) {
        double sum = 0;

        for (FinancialRecord pay : PayamentDB.list()) {
            if (pay.getDate().equals(date))
                sum += pay.getValue();
        }

        return sum;
    }

    private static List<Date> getDates() {
        List<Date> dates = new ArrayList<>();
        final String SELECT_DATES = "SELECT date FROM financial ORDER BY date";

        Connection connection = null;
        Statement statement = null;
        ResultSet result = null;

        try {

            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            result = statement.executeQuery(SELECT_DATES);

            while (result.next()) {
                Date date = result.getDate("date");
                if (!repeatedDates(date, dates)) {
                    dates.add(date);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (result != null) {
                    result.close();
                }

                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return dates;
    }

    private static boolean repeatedDates(Date date, List<Date> dates) {
        for (Date dt : dates) {
            if (dt.equals(date)) {
                return true;
            }
        }
        return false;
    }
}
