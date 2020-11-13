package view;

import model.Task;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class TaskTableModel extends AbstractTableModel {
    private List<Task> tasks = new ArrayList<>();
    private String[] columns = new String[] { "Id", "Nome", "Descrição" };

    public TaskTableModel(List<Task> list) {
        this.tasks = list;
    }

    @Override
    public String getColumnName(int column) {
        String columnName = null;

        if (column >= 0 && column <= columns.length) {
            columnName = columns[column];
        }

        return columnName;
    }

    @Override
    public int getRowCount() {
        return tasks.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int colIndex) {
        String value = null;

        if (rowIndex >= 0 && rowIndex <= tasks.size()) {
            Task task = tasks.get(rowIndex);

            switch (colIndex) {
                case 0:
                    value = Integer.toString(task.getId());
                    break;
                case 1:
                    value = task.getTask();
                    break;
                case 2:
                    value = task.getDescription();
                    break;
                default:
                    System.err.printf("[ERRO] Índice e coluna inválido: %d\n", colIndex);
                    break;
            }
        }

        return value;
    }

	public void load(List<Task> listTasks) {
        this.tasks = listTasks;
        fireTableDataChanged();
    }

    public Task getTask(int rowIndex) {
        Task task = null;
        
        if (rowIndex >= 0 && rowIndex <= tasks.size()) {
            task = tasks.get(rowIndex);
        }

        return task;
    }

	public void delete(Task task) {
        tasks.remove(task);
        fireTableDataChanged();
    }
}
