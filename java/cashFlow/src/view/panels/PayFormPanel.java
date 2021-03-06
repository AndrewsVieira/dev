package src.view.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import src.dataBase.CategoryDB;
import src.dataBase.PayamentDB;
import src.model.FinancialRecord;
import src.model.PayamentRecord;
import src.model.utils.Category;
import src.model.utils.Provider;
import src.model.utils.TypeCategory;
import src.view.Frame;
import src.view.tableModels.ComboBoxCategoryModel;

public class PayFormPanel extends FormPanel {

    private JTextField providerTxt;
    private JButton cancelBtn;
    private JButton saveBtn;
    private FinancialRecord payament;
    private JComboBox categoryBox;
    private ComboBoxCategoryModel comboModel;

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

        Category category = (Category) categoryBox.getSelectedItem();

        Date date = transDate(getDateTxt().getText());

        pay.setDate(date);
        pay.setValue(Double.parseDouble(getValueTxt().getText()));
        pay.setProvider(provider);
        pay.setCategory(category);
        pay.setDescription(getDescriptionTxt().getText());
    }

    @Override
    public void chooseCategory() {
        comboModel = new ComboBoxCategoryModel(CategoryDB.list(TypeCategory.PAYAMENT));
        categoryBox = new JComboBox(comboModel);
        addComponent(categoryBox, 4, 1);
    }

    @Override
    public JComboBox getComboBoxComponent() {
        reload();
        return categoryBox;
    }

    private void reload() {
        comboModel.setCategories(CategoryDB.list(TypeCategory.PAYAMENT));
    }
}
