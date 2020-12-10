package view.panels;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.FinancialRecord;
import view.Frame;

import java.awt.Insets;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.Date;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;

public abstract class FormPanel extends JPanel {
    private static Insets FIELD_INSETS = new Insets(5, 10, 0, 0);
    private Frame frame;

    private JTextField idTxt;
    private JTextField dateTxt;
    private JTextField valueTxt;
    private JTextArea descriptionTxt;

    private JButton saveBtn;
    private JButton cancelBtn;

    private GridBagLayout layout;
    private GridBagConstraints constraints;
    private MenuPanel menuPanel;

    private JPanel formPanel;

    public FormPanel(Frame frame) {
        this.frame = frame;

        setLayout(new BorderLayout(10, 10));

        createEventComponentAdapter();
        createMenuPanel();
        createFormPanel();
        createForm();
        createEmpysPanel();
    }

    public Frame getFrame() {
        return frame;
    }

    public JTextField getIdTxt() {
        return idTxt;
    }

    public JTextField getDateTxt() {
        return dateTxt;
    }

    public JTextField getValueTxt() {
        return valueTxt;
    }

    public JTextArea getDescriptionTxt() {
        return descriptionTxt;
    }

    public abstract JTextField getClientOrProvider();

    private void createEventComponentAdapter() {
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent arg0) {
                if (getRecord() == null) {
                    idTxt.setText("");
                    dateTxt.setText("");
                    valueTxt.setText("");
                    getTypeComponent().setText("");
                    descriptionTxt.setText("");
                } else {
                    idTxt.setText(Integer.toString(getRecord().getId()));
                    dateTxt.setText(getRecord().getStringDate());
                    valueTxt.setText(Double.toString(getRecord().getValue()));
                    getTypeComponent().setText(getRecord().getClientOrProvider().toString());
                    descriptionTxt.setText(getRecord().getDescription());
                }
            }
        });
    }

    public abstract void setRecord(FinancialRecord record);

    public abstract FinancialRecord getRecord();

    private void createEmpysPanel() {
        // adicionando panels para leste e oeste (vazios) para acrescentar uma margem
        JPanel eastPanel = new JPanel();
        add(eastPanel, BorderLayout.EAST);
        JPanel westPanel = new JPanel();
        add(westPanel, BorderLayout.WEST);
    }

    private void createFormPanel() {
        formPanel = new JPanel();

        layout = new GridBagLayout();
        constraints = new GridBagConstraints();

        formPanel.setLayout(layout);
        add(formPanel, BorderLayout.CENTER);
    }

    private void createMenuPanel() {
        menuPanel = new MenuPanel(this.frame);
        add(menuPanel, BorderLayout.NORTH);
    }

    private void createForm() {
        JLabel label;

        label = new JLabel("Id");
        addComponent(label, 0, 0);
        idTxt = new JTextField(30);
        idTxt.setEditable(false);
        addComponent(idTxt, 0, 1);

        label = new JLabel("Data");
        addComponent(label, 1, 0);
        dateTxt = new JTextField(30);
        addComponent(dateTxt, 1, 1);

        label = new JLabel("Valor");
        addComponent(label, 2, 0);
        valueTxt = new JTextField(30);
        addComponent(valueTxt, 2, 1);

        createTypeComponent();

        label = new JLabel("Categoria");
        addComponent(label, 4, 0);
        choiseCategory();

        label = new JLabel("Descrição");
        addComponent(label, 5, 0);
        descriptionTxt = new JTextArea(5, 30);
        JScrollPane scroll = new JScrollPane(descriptionTxt);
        addComponent(scroll, 5, 1, 1, 5);

        createBtns();

    }

    public abstract void createTypeComponent();

    public abstract JTextField getTypeComponent();

    private void createBtns() {
        JPanel btnPanel = new JPanel();
        FlowLayout layout = (FlowLayout) btnPanel.getLayout();
        layout.setAlignment(FlowLayout.LEFT);

        createSaveBtn();
        btnPanel.add(saveBtn);

        createCancelBtn();
        btnPanel.add(cancelBtn);

        addComponent(btnPanel, 10, 1);

    }

    public void setSaveBtn(JButton saveBtn) {
        this.saveBtn = saveBtn;
    }

    public void setCancelBtn(JButton cancelBtn) {
        this.cancelBtn = cancelBtn;
    }

    public abstract void createCancelBtn();

    public abstract void createSaveBtn();

    public abstract void choiseCategory();

    public void addComponent(JComponent comp, int row, int col) {
        addComponent(comp, row, col, 1, 1);
    }

    public void addComponent(JComponent comp, int row, int col, int width, int height) {
        constraints.gridx = col;
        constraints.gridy = row;
        constraints.gridwidth = width;
        constraints.gridheight = height;

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = FIELD_INSETS;

        layout.setConstraints(comp, constraints);

        formPanel.add(comp);
    }

    public Date transDate(String strDate) {
        String strYear = "";
        for (int i = 0; i < strDate.length(); i++) {
            if (i > 5 && i < 10) {
                strYear += strDate.charAt(i);
            }
        }
        int y = Integer.parseInt(strYear);

        String strMonth = "";
        for (int i = 0; i < strDate.length(); i++) {
            if (i > 2 && i < 5) {
                strMonth += strDate.charAt(i);
            }
        }
        int m = Integer.parseInt(strMonth);

        String strDay = "";
        for (int i = 0; i < strDate.length(); i++) {
            if (i >= 0 && i < 2) {
                strDay += strDate.charAt(i);
            }
        }
        int d = Integer.parseInt(strDay);

        Date date = Date.valueOf(String.format("%d-%d-%d", y, m, d));

        return date;
    }

}
