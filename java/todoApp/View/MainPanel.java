package View;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel {
    ToDoFrame frame;

    private JButton addTaskBtn;
    private JButton changeTaskBtn;
    private JButton removeTaskBtn;

    private JTable tableTask;

    public MainPanel(ToDoFrame toDoFrame) {
        this.frame = toDoFrame;

        setLayout(new BorderLayout(10, 10));

        initBtns();
        initTable();
    }

    private void initBtns() {
        JPanel panel = new JPanel();

        addTaskBtn = new JButton("Adicionar");
        addTaskBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.showFormPanel();
            }
        });
        panel.add(addTaskBtn);

        changeTaskBtn = new JButton("Alterar");
        changeTaskBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.showFormPanel();
                // TODO: tratar evento
            }
        });
        panel.add(changeTaskBtn);

        removeTaskBtn = new JButton("Remover");
        removeTaskBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: tratar evento
            }
        });
        panel.add(removeTaskBtn);

        add(panel, BorderLayout.NORTH);

        disableBtns();
    }

    private void initTable() {
        tableTask = new JTable();
        tableTask.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scroll = new JScrollPane(tableTask);

        add(scroll, BorderLayout.CENTER);
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
