package view.panels;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.utils.Category;
import view.Frame;

public class CategoryFormPanel extends JPanel {
    private static Insets FIELD_INSETS = new Insets(5, 10, 0, 0);

    private Category category;
    private Frame frame;
    private GridBagLayout layout;
    private GridBagConstraints constraints;
    private JPanel formPanel;

    private JTextField idTxt;
    private JTextField nameTxt;
    private JTextField typeTxt;

    private JButton save;
    private JButton cancel;

    public CategoryFormPanel(Frame frame) {
        this.frame = frame;
        MenuPanel menuPanel = new MenuPanel(frame);
        setLayout(new BorderLayout(10, 10));
        add(menuPanel, BorderLayout.NORTH);

        layout = new GridBagLayout();
        constraints = new GridBagConstraints();

        formPanel = new JPanel();
        formPanel.setLayout(layout);

        createForm();
    }

    private void createForm() {
        JLabel label;

        label = new JLabel("Id");
        addComponent(label, 0, 0);
        idTxt = new JTextField();
        addComponent(idTxt, 0, 1);

        label = new JLabel("Nome");
        addComponent(label, 1, 0);
        nameTxt = new JTextField();
        addComponent(nameTxt, 1, 1);

        label = new JLabel("Tipo");
        addComponent(label, 2, 0);
        typeTxt = new JTextField();
        addComponent(typeTxt, 2, 1);

        createBtns();

        add(formPanel, BorderLayout.CENTER);
    }

    private void createBtns() {
        JPanel panel = new JPanel();

        save = new JButton("Salvar");
        panel.add(save);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                frame.showCategoryPanel();    
            }
        });

        cancel = new JButton("Cancelar");
        panel.add(cancel);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                frame.showCategoryPanel(); 
            }
        });

        addComponent(panel, 3, 1);
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    private void addComponent(JComponent comp, int row, int col) {
        addComponent(comp, row, col, 1, 1);
    }

    private void addComponent(JComponent comp, int row, int col, int width, int height) {
        constraints.gridy = row;
        constraints.gridx = col;
        constraints.gridwidth = width;
        constraints.gridheight = height;

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = FIELD_INSETS;

        layout.setConstraints(comp, constraints);

        formPanel.add(comp);
    }

}
