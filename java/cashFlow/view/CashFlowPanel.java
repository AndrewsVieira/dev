package view;

import java.awt.BorderLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import dataBase.CashFlowDB;
import dataBase.PayamentDB;
import dataBase.RevenueDB;
import model.CashFlowRecord;
import model.FinancialRecord;
import model.PayamentRecord;
import model.RevenueRecord;

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
        fillCashFlowList();
        tableModel.load(CashFlowDB.list());
    }

    private void fillCashFlowList() {
        CashFlowDB.deleteAll();

        CashFlowRecord record = new CashFlowRecord();

        for (FinancialRecord pay : PayamentDB.list()) {
            for (FinancialRecord rev : RevenueDB.list()) {
                PayamentRecord payament = (PayamentRecord) pay;
                record.setPayament(payament);
                RevenueRecord revenue = (RevenueRecord) rev;
                record.setRevenue(revenue);

                CashFlowDB.create(record);
            }
        }

        System.out.println(CashFlowDB.list());

    }
}
