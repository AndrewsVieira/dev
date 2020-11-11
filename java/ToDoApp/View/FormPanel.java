package View;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FormPanel extends JPanel {

    private static final Insets FIELD_INSETS = new Insets(5,10,0,0);
    
    private GridBagLayout layout;
    private GridBagConstraints constraints;

    private JTextField idTxt;
    private JTextField taskTxt;
    private JTextArea descriptionTxt;

    private JButton saveBtn;
    private JButton cancelBtn;

    public FormPanel() {
        layout = new GridBagLayout();
        constraints = new GridBagConstraints();

        setLayout(layout);

        createForm();
    }
    
    private void createForm() {
        JLabel label;

        label = new JLabel("Id:");
        addComponent(label, 0, 0);
        idTxt = new JTextField(30);
        addComponent(idTxt, 0, 1);

        label = new JLabel("Tarefa:");
        addComponent(label, 1, 0);
        taskTxt = new JTextField(30);
        addComponent(taskTxt, 1, 1);

        label = new JLabel("Descrição:");
        addComponent(label, 2, 0);
        descriptionTxt = new JTextArea(5, 30);
        JScrollPane scroll = new JScrollPane(descriptionTxt);
        addComponent(scroll, 2, 1, 1, 5);

        // btns
        createBtns();
        

    } 
    
    private void createBtns() {
        JPanel btnPanel = new JPanel();
        createSaveBtn();
        btnPanel.add(saveBtn);

        createCencelBtn();
        btnPanel.add(cancelBtn);

        addComponent(btnPanel, 7, 1, 2, 1);
    }

    private void createCencelBtn() {
        cancelBtn = new JButton("Cancelar");
    }

    private void createSaveBtn() {
        saveBtn = new JButton("Salvar");
    }

    private void addComponent(JComponent comp, int row, int col) {
        addComponent(comp, row, col, 1, 1);
    }

    private void addComponent(JComponent comp, int row, int col, int width, int height) {
        constraints.gridx = col;
        constraints.gridy = row;
        constraints.gridwidth = width;
        constraints.gridheight = height;

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = FIELD_INSETS;
        
        layout.setConstraints(comp, constraints);

        add(comp);
    }
    
}