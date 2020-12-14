package view.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import dataBase.CategoryDB;
import dataBase.RevenueDB;
import model.FinancialRecord;
import model.RevenueRecord;
import model.utils.Category;
import model.utils.Client;
import model.utils.TypeCategory;
import view.Frame;
import view.tableModels.ComboBoxCategoryModel;

public class ToReceiveFormPanel extends FormPanel {

    private JTextField client;
    private JButton cancelBtn;
    private JButton saveBtn;
    private FinancialRecord revenue;
    private JComboBox categoryBox;
    private ComboBoxCategoryModel comboModel;

    public ToReceiveFormPanel(Frame frame) {
        super(frame);
        setRecord(null);
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

        Category category = CategoryDB.list().get(((Category) categoryBox.getSelectedItem()).getId());

        Date date = transDate(getDateTxt().getText());

        rev.setDate(date);
        rev.setValue(Double.parseDouble(getValueTxt().getText()));
        rev.setClient(client);
        rev.setCategory(category);
        rev.setDescription(getDescriptionTxt().getText());
    }

    @Override
    public JTextField getClientOrProvider() {
        return client;
    }

    @Override
    public void setRecord(FinancialRecord record) {
        this.revenue = record;
    }

    @Override
    public FinancialRecord getRecord() {
        return revenue;
    }

    @Override
    public void chooseCategory() {
        comboModel = new ComboBoxCategoryModel(CategoryDB.list(TypeCategory.REVENUE));
        categoryBox = new JComboBox(comboModel);
        addComponent(categoryBox, 4, 1);
    }

    @Override
    public JComboBox getComboBoxComponent() {
        reload();
        return categoryBox;
    }

    private void reload() {
        comboModel.setCategories(CategoryDB.list(TypeCategory.REVENUE));
    }
}
