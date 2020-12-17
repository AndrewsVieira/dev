package src.view.tableModels;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import src.model.utils.Category;

public class CategoryTableModel extends AbstractTableModel {

    private static List<Category> categories = new ArrayList<>();
    private static String[] columns = new String[] { "Id", "Nome", "Tipo" };

    @Override
    public String getColumnName(int column) {
        String colName = null;

        if (column >= 0 && column < columns.length) {
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
        return categories.size();
    }

    @Override
    public String getValueAt(int rowIndex, int colIndex) {
        String value = null;

        Category category = categories.get(rowIndex);

        switch (colIndex) {
            case 0:
                value = Integer.toString(category.getId());
                break;
            case 1:
                value = category.getName();
                break;
            case 2:
                value = category.getType().getType();
                break;

            default:
                System.err.printf("\n[ERRO] Índice de coluna inválido: %d", colIndex);
                break;
        }

        return value;
    }

	public Category getCategory(int selectedRow) {
		return categories.get(selectedRow);
	}

	public void delete(Category category) {
        categories.remove(category);
        fireTableDataChanged();
	}

	public void load(List<Category> list) {
        categories = list;
        fireTableDataChanged();
	}
}
