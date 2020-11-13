package view;

import model.Task;
import model.TaskDB;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;

public class MainPanel extends JPanel {
    ToDoFrame frame;

    private JButton addTaskBtn;
    private JButton changeTaskBtn;
    private JButton removeTaskBtn;

    private JTable tableTask;
    private TaskTableModel tableModel;

    public MainPanel(ToDoFrame toDoFrame) {
        this.frame = toDoFrame;

        setLayout(new BorderLayout(10, 10));

        initBtns();
        initTable();
    }

    private void initBtns() {
        JPanel panel = new JPanel();
        // alinhar os botoes a direita
        FlowLayout layout = (FlowLayout) panel.getLayout();
        layout.setAlignment(FlowLayout.RIGHT);

        addTaskBtn = new JButton("Adicionar");
        addTaskBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.showFormPanel(null);
            }
        });
        panel.add(addTaskBtn);

        changeTaskBtn = new JButton("Alterar");
        changeTaskBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Task task = tableModel.getTask(tableTask.getSelectedRow());
                frame.showFormPanel(task);
            }
        });
        panel.add(changeTaskBtn);

        removeTaskBtn = new JButton("Remover");
        removeTaskBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Task task = tableModel.getTask(tableTask.getSelectedRow());
                int answer = JOptionPane.showConfirmDialog(MainPanel.this, "Deseja remover esta tarefa?",
                        ToDoFrame.TITLE, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (answer == JOptionPane.YES_OPTION) {
                    TaskDB.delete(task);
                    tableModel.delete(task);
                }
            }
        });
        panel.add(removeTaskBtn);

        add(panel, BorderLayout.NORTH);

        disableBtns();
    }

    private void initTable() {
        tableModel = new TaskTableModel(TaskDB.list());

        tableTask = new JTable(tableModel);
        tableTask.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        tableTask.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    if (tableTask.getSelectedRow() >= 0) {
                        ableBtns();
                    } else {
                        disableBtns();
                    }
                }
            }
        });

        JScrollPane scroll = new JScrollPane(tableTask);

        add(scroll, BorderLayout.CENTER);
    }

    public void reload() {
        tableModel.load(TaskDB.list());
    }

    private void disableBtns() {
        changeTaskBtn.setEnabled(false);
        removeTaskBtn.setEnabled(false);
    }

    private void ableBtns() {
        changeTaskBtn.setEnabled(true);
        removeTaskBtn.setEnabled(true);
    }

} // fim da classe MainPanel
