package src.view.panels;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import src.dataBase.CategoryDB;
import src.model.utils.Category;
import src.model.utils.TypeCategory;
import src.view.Frame;

public class CategoryFormPanel extends JPanel {
    private static final String[] LIST_ITEMS = new String[] { TypeCategory.REVENUE.getType(),
            TypeCategory.PAYAMENT.getType() };

    private static Insets FIELD_INSETS = new Insets(5, 10, 0, 0);

    private Category category;
    private Frame frame;
    private GridBagLayout layout;
    private GridBagConstraints constraints;
    private JPanel formPanel;

    private JTextField idTxt;
    private JTextField nameTxt;
    private JComboBox typeBox;

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
        createEventComponentAdapter();
    }

    private void createEventComponentAdapter() {
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent arg0) {
                if (category == null) {
                    idTxt.setText("");
                    nameTxt.setText("");
                } else {
                    idTxt.setText(Integer.toString(category.getId()));
                    nameTxt.setText(category.getName());
                    typeBox.setSelectedItem(category.getType().getType());
                }
            }
        });
    }

    private void createForm() {
        JLabel label;

        label = new JLabel("Id");
        addComponent(label, 0, 0);
        idTxt = new JTextField();
        idTxt.setEditable(false);
        addComponent(idTxt, 0, 1);

        label = new JLabel("Nome");
        addComponent(label, 1, 0);
        nameTxt = new JTextField();
        addComponent(nameTxt, 1, 1);

        label = new JLabel("Tipo");
        addComponent(label, 2, 0);
        typeBox = new JComboBox<>(LIST_ITEMS);
        addComponent(typeBox, 2, 1);

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
                Category category = new Category();
                category.setName(nameTxt.getText());
                category.setType(typeBox.getSelectedItem().toString());

                if (CategoryFormPanel.this.category == null) {
                    CategoryDB.insert(category);
                } else {
                    category.setId(Integer.parseInt(idTxt.getText()));
                    CategoryDB.update(category);
                }                

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
