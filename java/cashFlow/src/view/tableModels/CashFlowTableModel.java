package src.view.tableModels;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import src.model.CashFlowRecord;

public class CashFlowTableModel extends AbstractTableModel {

    private List<CashFlowRecord> records = new ArrayList<>();
    private String[] columns = new String[] { "Data", "Recebimento", "Pagamento", "Saldo Acumulado" };

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
            CashFlowRecord record = records.get(rowIndex);

            switch (colIndex) {
                case 0:
                    value = record.getStringDate();
                    break;
                case 1:
                    value = Double.toString(record.getRevenueValue());
                    break;
                case 2:
                    value = Double.toString(record.getPayamentValue());
                    break;
                case 3:
                    value = Double.toString(record.getAccumulatedBalance());
                    break;

                default:
                    System.err.printf("\n[ERRO] Índice inválido para coluna - índice: %d", colIndex);
                    break;
            }
        }

        return value;
    }

    public void load(List<CashFlowRecord> records) {
        setRecords(records);
        fireTableDataChanged();
    }

    private void setRecords(List<CashFlowRecord> records) {
        this.records = records;
    }
}