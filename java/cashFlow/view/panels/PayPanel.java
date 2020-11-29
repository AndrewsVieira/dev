package view.panels;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dataBase.PayamentDB;
import model.FinancialRecord;
import view.FinancialTableModel;
import view.Frame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PayPanel extends JPanel {
    private Frame frame;
    private MenuPanel menuPanel;
    private JPanel panel;

    private JTable payTable;

    private JButton btnChange;
    private JButton btnRemove;
    private JButton btnFormPay;
    private FinancialTableModel tableModel;

    public PayPanel(Frame frame) {
        this.frame = frame;

        setLayout(new BorderLayout(10, 10));

        menuPanel = new MenuPanel(this.frame);
        add(menuPanel, BorderLayout.NORTH);

        createPanel();
        createBtns();
        createPayTable();
    }

    private void createBtns() {
        JPanel btnPanel = new JPanel();
        FlowLayout layout = (FlowLayout) btnPanel.getLayout();
        layout.setAlignment(FlowLayout.RIGHT);

        // botão de criar registro de pagamento
        createBtnFormPay();
        btnPanel.add(btnFormPay);

        btnChange = new JButton("Alterar");

        btnChange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                FinancialRecord payament = tableModel.getRecord(payTable.getSelectedRow());
                frame.showPayFormPanel(payament);
            }
        });

        btnPanel.add(btnChange);

        btnRemove = new JButton("Remover");

        btnRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                FinancialRecord payament = tableModel.getRecord(payTable.getSelectedRow());
                PayamentDB.delete(payament);
                tableModel.delete(payament);
            }
        });

        btnPanel.add(btnRemove);

        panel.add(btnPanel, BorderLayout.NORTH);

        disableBtns();
    }

    private void createBtnFormPay() {

        btnFormPay = new JButton("Adicionar");
        btnFormPay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                frame.showPayFormPanel(null);
            }
        });
    }

    private void createPanel() {
        panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));
        add(panel, BorderLayout.CENTER);
    }

    private void createPayTable() {
        tableModel = new FinancialTableModel();
        tableModel.setFourthColName("Fornecedor");

        payTable = new JTable(tableModel);
        payTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        payTable.setAutoCreateRowSorter(true);

        payTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    if (payTable.getSelectedRow() >= 0) {
                        ableBtns();
                    } else {
                        disableBtns();
                    }
                }
            }
        });

        JScrollPane scroll = new JScrollPane(payTable);

        panel.add(scroll, BorderLayout.CENTER);
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
        tableModel.load(PayamentDB.list());
    }
}
