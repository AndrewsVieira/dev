package view;

import model.CashFlow;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class CashFlowTableModel extends AbstractTableModel {

    private List<CashFlow> records = new ArrayList<>();
    private String[] columns = new String[] { "Data", "Recebimento", "Pagamento", "Saldo Acumulado" };

    @Override
    public String getColumnName(int column) {
        String colName = null;
        
        if (column >= 0 && column <= columns.length) {
            colName =  columns[column];
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
            CashFlow record = records.get(rowIndex);

            double prevBalance = 0.0;
            if (getValueAt(rowIndex-1, colIndex-1) != null) {
                prevBalance = Double.parseDouble((String) getValueAt(rowIndex-1, 3));
            }
            
            double rev = record.getRevenueValue();
            double pay = record.getPayamentValue();

            switch (colIndex) {
                case 0:
                    value = record.getDate();
                    break;
                case 1:
                    value = Double.toString(rev);
                    break;
                case 2:
                    value = Double.toString(pay);
                    break;
                case 3:
                    value = Double.toString(prevBalance + rev - pay);
                    break;

                default:
                    System.err.printf("[ERRO] Índice inválido para coluna - índice: %d", colIndex);
                    break;
            }
        }

        return value;
    }

    public void load(List<CashFlow> records) {
        setRecords(records);
        fireTableDataChanged();
    }

    private void setRecords(List<CashFlow> records) {
        this.records = records;
    }
}