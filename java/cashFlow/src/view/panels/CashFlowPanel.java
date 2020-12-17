package src.view.panels;

import java.awt.BorderLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import src.dataBase.CashFlowDB;
import src.view.Frame;
import src.view.tableModels.CashFlowTableModel;

public class CashFlowPanel extends JPanel {
    Frame frame;
    MenuPanel menuPanel;
    private CashFlowTableModel tableModel;
    private JTable cashFlowTable;

    public CashFlowPanel(Frame frame) {
        this.frame = frame;
        menuPanel = new MenuPanel(this.frame);
        setLayout(new BorderLayout(10, 10));
        add(menuPanel, BorderLayout.NORTH);
        createCashFlowTable();
        createEventComponentAdapter();
    }

    private void createCashFlowTable() {
        tableModel = new CashFlowTableModel();

        cashFlowTable = new JTable(tableModel);

        JScrollPane scroll = new JScrollPane(cashFlowTable);
        add(scroll, BorderLayout.CENTER);
    }

    private void createEventComponentAdapter() {
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                reload();
            }
        });
    }

    private void reload() {
        tableModel.load(CashFlowDB.list());
    }
}
