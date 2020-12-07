package view.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import dataBase.RevenueDB;
import model.utils.Client;
import view.Frame;
import view.panels.FormPanel;
import model.FinancialRecord;
import model.RevenueRecord;

public class ToReceiveFormPanel extends FormPanel {

    private JTextField client;
    private JButton cancelBtn;
    private JButton saveBtn;
    private FinancialRecord revenue;

    public ToReceiveFormPanel(Frame frame) {
        super(frame);
        setPayament(null);
    }

    public void setRevenue(FinancialRecord revenue) {
        this.revenue = revenue;
    }

    @Override
    public JTextField getTypeComponent() {
        return client;
    }

    @Override
    public void createTypeComponent() {
        JLabel label = new JLabel("Cliente");
        addComponent(label, 3, 0);
        client = new JTextField(50);
        addComponent(client, 3, 1);

    }

    @Override
    public void createCancelBtn() {
        cancelBtn = new JButton("Cancelar");
        cancelBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                getFrame().showToReceivePanel();
                System.out.println(this);
            }
        });
        setCancelBtn(cancelBtn);
    }

    @Override
    public void createSaveBtn() {
        saveBtn = new JButton("Salvar");
        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                RevenueRecord rev = new RevenueRecord();
                register(rev);

                if (revenue == null) {
                    RevenueDB.insert(rev);
                } else {
                    rev.setId(Integer.parseInt(getIdTxt().getText()));
                    RevenueDB.update(rev);
                }

                getFrame().showToReceivePanel();
                System.out.println(this);
            }
        });
        setSaveBtn(saveBtn);
    }

    protected void register(RevenueRecord rev) {
        Client client = new Client();
        client.setName(getClientOrProvider().getText());

        Date date = transDate(getDateTxt().getText());

        rev.setDate(date);
        rev.setValue(Double.parseDouble(getValueTxt().getText()));
        rev.setClient(client);
        rev.setDescription(getDescriptionTxt().getText());
    }

    @Override
    public JTextField getClientOrProvider() {
        return client;
    }

    @Override
    public void setPayament(FinancialRecord record) {
        this.revenue = record;
    }

    @Override
    public FinancialRecord getRecord() {
        return revenue;
    }
}
