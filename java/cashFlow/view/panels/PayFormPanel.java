package view.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import dataBase.CategoryDB;
import dataBase.PayamentDB;
import model.FinancialRecord;
import model.PayamentRecord;
import model.utils.Category;
import model.utils.Provider;
import model.utils.TypeCategory;
import view.Frame;

public class PayFormPanel extends FormPanel {

    private JTextField providerTxt;
    private JButton cancelBtn;
    private JButton saveBtn;
    private FinancialRecord payament;
    private JComboBox categoryBox;

    public PayFormPanel(Frame frame) {
        super(frame);

        setRecord(null);
    }

    @Override
    public void setRecord(FinancialRecord record) {
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

        Category category = CategoryDB.list().get(((Category) categoryBox.getSelectedItem()).getId());

        Date date = transDate(getDateTxt().getText());

        pay.setDate(date);
        pay.setValue(Double.parseDouble(getValueTxt().getText()));
        pay.setProvider(provider);
        pay.setCategory(category);
        pay.setDescription(getDescriptionTxt().getText());
    }

    @Override
    public void choiseCategory() {
        // String[] categories = new
        // String[CategoryDB.list(TypeCategory.PAYAMENT).size()];
        // for (String str : CategoryDB.list(TypeCategory.PAYAMENT)) {
        // categories[CategoryDB.list(TypeCategory.PAYAMENT).indexOf(str)] = str;
        // }

        List<Category> categories = CategoryDB.list(TypeCategory.PAYAMENT);
        categoryBox = new JComboBox((ComboBoxModel) categories);
        addComponent(categoryBox, 4, 1);
    }
}
