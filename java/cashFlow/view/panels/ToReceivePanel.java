package view.panels;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dataBase.RevenueDB;
import model.FinancialRecord;
import view.FinancialTableModel;
import view.Frame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToReceivePanel extends JPanel {
    private Frame frame;
    private MenuPanel menuPanel;

    private JPanel panel;
    private JTable toReceiveTable;

    private JButton btnChange;
    private JButton btnRemove;
    private JButton btnFormToReceive;
    private FinancialTableModel tableModel;

    public ToReceivePanel(Frame frame) {
        this.frame = frame;

        setLayout(new BorderLayout(10, 10));

        menuPanel = new MenuPanel(this.frame);
        add(menuPanel, BorderLayout.NORTH);

        createPanel();
        createBtns();
        createToReceiveTable();
    }

    private void createPanel() {
        panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));
        add(panel, BorderLayout.CENTER);
    }

    private void createBtns() {
        JPanel btnPanel = new JPanel();
        FlowLayout layout = (FlowLayout) btnPanel.getLayout();
        layout.setAlignment(FlowLayout.RIGHT);

        createBtnFormToReceive();
        btnPanel.add(btnFormToReceive);

        btnChange = new JButton("Alterar");

        btnChange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                FinancialRecord revenue = tableModel.getRecord(toReceiveTable.getSelectedRow());
                frame.showToReceiveFormPanel(revenue);
            }
        });

        btnPanel.add(btnChange);

        btnRemove = new JButton("Remover");

        btnRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                FinancialRecord revenue = tableModel.getRecord(toReceiveTable.getSelectedRow());
                RevenueDB.delete(revenue);
                tableModel.delete(revenue);
            }
        });

        btnPanel.add(btnRemove);

        panel.add(btnPanel, BorderLayout.NORTH);

        disableBtns();
    }

    private void createBtnFormToReceive() {
        btnFormToReceive = new JButton("Adicionar");
        btnFormToReceive.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {

                frame.showToReceiveFormPanel(null);
            }
        });
    }

    private void createToReceiveTable() {
        tableModel = new FinancialTableModel();
        tableModel.setFourthColName("Cliente");

        toReceiveTable = new JTable(tableModel);
        toReceiveTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        toReceiveTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    if (toReceiveTable.getSelectedRow() >= 0) {
                        ableBtns();
                    } else {
                        disableBtns();
                    }
                }
            }
        });

        JScrollPane scroll = new JScrollPane(toReceiveTable);

        panel.add(scroll);
    }

    private void disableBtns() {
        btnChange.setEnabled(false);
        btnRemove.setEnabled(false);
    }

    private void ableBtns() {
        btnChange.setEnabled(true);
        btnRemove.setEnabled(true);
    }

    public void reload() {
        tableModel.load(RevenueDB.list());
    }
}
