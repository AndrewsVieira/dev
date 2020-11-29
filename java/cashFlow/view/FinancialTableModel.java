package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.FinancialRecord;

public class FinancialTableModel extends AbstractTableModel {

    private List<FinancialRecord> records = new ArrayList<>();
    private String[] columns = new String[] { "Id", "Data", "Valor", null, "Descrição" };

    public void setFourthColName(String FourthColName) {
        final int INDEX = 3;

        if (FourthColName != null) {
            columns[INDEX] = FourthColName;
        }

    }

    @Override
    public String getColumnName(int column) {
        String colName = null;

        if (column >= 0 && column <= columns.length) {
            colName = columns[column];
        }

        return colName;
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public int getRowCount() {
        return records.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int colIndex) {
        String value = null;

        if (rowIndex >= 0 && rowIndex <= records.size()) {
            FinancialRecord record = records.get(rowIndex);

            switch (colIndex) {
                case 0:
                    value = Integer.toString(record.getId());
                    break;
                case 1:
                    value = record.getDate();
                    break;
                case 2:
                    value = Double.toString(record.getValue());
                    break;
                case 3:
                    value = record.getClientOrProvider().toString();
                    break;
                case 4:
                    value = record.getDescription();
                    break;
                default:
                    System.err.printf("[ERRO] Índice de coluna inválido: %d\n", colIndex);
                    break;
            }
        }

        return value;
    }

    public FinancialRecord getRecord(int selectedRow) {
        FinancialRecord record = null;

        if (selectedRow >= 0 && selectedRow <= records.size()) {
            record = records.get(selectedRow);
        }

        return record;
    }

    public void load(List<FinancialRecord> record) {
        this.records = record;
        fireTableDataChanged();
    }

    public void delete(FinancialRecord record) {
        records.remove(record);
        fireTableDataChanged();
    }

}
