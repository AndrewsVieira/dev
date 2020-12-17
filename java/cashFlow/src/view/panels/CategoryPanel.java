package src.view.panels;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import src.dataBase.CategoryDB;
import src.model.utils.Category;
import src.view.Frame;
import src.view.tableModels.CategoryTableModel;

public class CategoryPanel extends JPanel {

    private Frame frame;
    private MenuPanel menuPanel;
    private JButton btnCreateCategory;
    private JButton btnChangeCategory;
    private JButton btnRemoveCategory;
    private JPanel panel;
    private CategoryTableModel tableModel;
    private JTable categoriesTable;

    public CategoryPanel(Frame frame) {
        this.frame = frame;

        setLayout(new BorderLayout(10, 10));

        menuPanel = new MenuPanel(this.frame);
        add(menuPanel, BorderLayout.NORTH);

        createPanel();
        createBtns();
        createCategoriesTable();
    }

    private void createPanel() {
        panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));
        add(panel, BorderLayout.CENTER);
    }

    private void createBtns() {
        JPanel btnPanel = new JPanel();
        FlowLayout layout = (FlowLayout) btnPanel.getLayout();
        layout.setAlignment(FlowLayout.RIGHT);

        btnCreateCategory = new JButton("Adicionar");
        btnCreateCategory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                frame.showCategoryFormPanel(null);
            }
        });

        btnPanel.add(btnCreateCategory);

        btnChangeCategory = new JButton("Alterar");

        btnChangeCategory.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                Category category = tableModel.getCategory(categoriesTable.getSelectedRow());
                frame.showCategoryFormPanel(category);
            }
        });

        btnPanel.add(btnChangeCategory);

        btnRemoveCategory = new JButton("Remover");

        btnRemoveCategory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Category category = tableModel.getCategory(categoriesTable.getSelectedRow());
                CategoryDB.delete(category);
                tableModel.delete(category);
            }
        });

        btnPanel.add(btnRemoveCategory);

        panel.add(btnPanel, BorderLayout.NORTH);

        disableBtns();
    }

    private void createCategoriesTable() {
        tableModel = new CategoryTableModel();

        categoriesTable = new JTable(tableModel);
        categoriesTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        categoriesTable.setAutoCreateRowSorter(true);

        categoriesTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    if (categoriesTable.getSelectedRow() >= 0) {
                        ableBtns();
                    } else {
                        disableBtns();
                    }
                }                
            }
        });

        JScrollPane scroll = new JScrollPane(categoriesTable);
        panel.add(scroll, BorderLayout.CENTER);
    }

    private void disableBtns() {
        btnChangeCategory.setEnabled(false);
        btnRemoveCategory.setEnabled(false);
    }

    private void ableBtns() {
        btnChangeCategory.setEnabled(true);
        btnRemoveCategory.setEnabled(true);
    }

	public void reload() {
        tableModel.load(CategoryDB.list());
	}
}
