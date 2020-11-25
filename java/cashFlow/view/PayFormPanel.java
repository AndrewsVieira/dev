package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import dataBase.PayamentDB;
import model.utils.Provider;
import model.FinancialRecord;
import model.PayamentRecord;

public class PayFormPanel extends FormPanel {

    private JTextField providerTxt;
    private JButton cancelBtn;
    private JButton saveBtn;
    private FinancialRecord payament;

    public PayFormPanel(Frame frame) {
        super(frame);

        setPayament(null);
    }

    @Override
    public void setPayament(FinancialRecord record) {
        this.payament = record;
    }
    @Override
    public FinancialRecord getRecord() {
        return payament;
    }

    @Override
    public JTextField getTypeComponent() {
        return providerTxt;
    }

    @Override
    public void createTypeComponent() {
        JLabel label = new JLabel("Fornecedor");
        addComponent(label, 3, 0);
        providerTxt = new JTextField(50);
        addComponent(providerTxt, 3, 1);
    }

    @Override
    public void createCancelBtn() {
        cancelBtn = new JButton("Cancelar");
        cancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                getFrame().showPayPanel();
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

                PayamentRecord pay = new PayamentRecord();
                register(pay);

                if (payament == null) {
                    PayamentDB.insert(pay);
                } else {
                    pay.setId(Integer.parseInt(getIdTxt().getText()));
                    PayamentDB.update(pay);
                }

                getFrame().showPayPanel();
                System.out.println(this);
            }
        });
        setSaveBtn(saveBtn);
    }

    @Override
    public JTextField getClientOrProvider() {
        return providerTxt;
    }

    public void register(PayamentRecord pay) {
        Provider provider = new Provider();
        provider.setName(getClientOrProvider().getText());

        pay.setDate(getDateTxt().getText());
        pay.setValue(Double.parseDouble(getValueTxt().getText()));
        pay.setProvider(provider);
        pay.setDescription(getDescriptionTxt().getText());
    }
}
