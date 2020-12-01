package view;

import model.*;

import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class FormPanel extends JPanel {

    private static final int VISIBLE_ROWS = 3;
    private static final Insets FIELD_INSETS = new Insets(5, 10, 0, 0);

    private TodoFrame frame;
    private Task task;

    private GridBagLayout layout;
    private GridBagConstraints constraints;

    private JTextField idTxt;
    private JTextField taskTxt;
    private JTextArea descriptionTxt;
    private CategoriesListModel isNotSelectedModel;
    private JList<Category> isNotSelectedList;
    private CategoriesListModel isSelectedModel;
    private JList<Category> isSelectedList;

    private JButton saveBtn;
    private JButton cancelBtn;

    public FormPanel(TodoFrame toDoFrame) {
        this.frame = toDoFrame;

        layout = new GridBagLayout();
        constraints = new GridBagConstraints();

        task = null;

        setLayout(layout);

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                if (task == null) {
                    idTxt.setText("");
                    taskTxt.setText("");
                    descriptionTxt.setText("");
                    isNotSelectedModel.load(CategoryDB.list());
                    isSelectedModel.load(new ArrayList<>());
                } else {
                    idTxt.setText(Integer.toString(task.getId()));
                    taskTxt.setText(task.getTask());
                    descriptionTxt.setText(task.getDescription());
                    isSelectedModel.load(task.getCategories());
                    isNotSelectedModel.load(CategoryDB.listTheNotSelecteds(task.getId()));
                }
            }
        });

        createForm();
    }

    public void setTask(Task task) {
        this.task = task;
    }

    private void createForm() {
        JLabel label;

        label = new JLabel("Id:");
        addComponent(label, 0, 0);
        idTxt = new JTextField(30);
        idTxt.setEditable(false);
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

        createCategoryList();

        // btns
        createBtns();

    }

    private void createCategoryList() {
        JLabel label;
        JPanel panel;
        JScrollPane scroll;
        Dimension scrollPreferredDimension = new Dimension(120, 60);

        label = new JLabel("Categorias");
        addComponent(label, 7, 0);

        panel = new JPanel();
        FlowLayout layout = (FlowLayout) panel.getLayout();
        layout.setAlignment(FlowLayout.LEFT);

        isNotSelectedModel = new CategoriesListModel(CategoryDB.list());
        isNotSelectedList = new JList<Category>(isNotSelectedModel);
        isNotSelectedList.setVisibleRowCount(VISIBLE_ROWS);
        isNotSelectedList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scroll = new JScrollPane(isNotSelectedList);
        scroll.setPreferredSize(scrollPreferredDimension);
        panel.add(scroll);

        JButton btnMove = new JButton("Mover");
        btnMove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Category isSelected;

                if (isNotSelectedList.getSelectedIndex() >= 0) {
                    isSelected = isNotSelectedList.getSelectedValue();
                    isSelectedModel.insert(isSelected);
                    isNotSelectedModel.remove(isSelected);
                }

                if (isSelectedList.getSelectedIndex() >= 0) {
                    isSelected = isSelectedList.getSelectedValue();
                    isNotSelectedModel.insert(isSelected);
                    isSelectedModel.remove(isSelected);

                }
            }
        });
        panel.add(btnMove);

        isSelectedModel = new CategoriesListModel(new ArrayList<>());
        isSelectedList = new JList<Category>(isSelectedModel);
        isSelectedList.setVisibleRowCount(VISIBLE_ROWS);
        isSelectedList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scroll = new JScrollPane(isSelectedList);
        scroll.setPreferredSize(scrollPreferredDimension);
        panel.add(scroll);

        addComponent(panel, 7, 1, 1, 3);
    }

    private void createBtns() {
        JPanel btnPanel = new JPanel();
        FlowLayout layout = (FlowLayout) btnPanel.getLayout();
        layout.setAlignment(FlowLayout.LEFT);

        createSaveBtn();
        btnPanel.add(saveBtn);

        createCancelBtn();
        btnPanel.add(cancelBtn);

        addComponent(btnPanel, 10, 1, 2, 1);
    }

    private void createCancelBtn() {
        cancelBtn = new JButton("Cancelar");
        cancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.showMainPanel();
            }
        });
    }

    private void createSaveBtn() {
        saveBtn = new JButton("Salvar");
        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Task task = new Task();
                task.setTask(taskTxt.getText());
                task.setDescription(descriptionTxt.getText());
                task.setCategories(isSelectedModel.getCategories());

                if (FormPanel.this.task == null) {
                    TaskDB.insert(task);
                    JOptionPane.showMessageDialog(FormPanel.this, "Tarefa criada com sucesso!", TodoFrame.TITLE,
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    task.setId(Integer.parseInt(idTxt.getText()));
                    TaskDB.update(task);
                    JOptionPane.showMessageDialog(FormPanel.this, "Tarefa alterada com sucesso!", TodoFrame.TITLE,
                            JOptionPane.INFORMATION_MESSAGE);
                }

                frame.showMainPanel();
            }
        });
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