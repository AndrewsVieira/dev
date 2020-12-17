package src.view.tableModels;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;

import src.model.utils.Category;

public class ComboBoxCategoryModel extends DefaultComboBoxModel {
    private List<Category> categories = new ArrayList<>();

    public ComboBoxCategoryModel(List<Category> list) {
        this.categories = list;
    }

    @Override
    public void setSelectedItem(Object anObject) {
        Category category = (Category) anObject;
        int i = categories.indexOf(category);
        if (i >= 0 && i < categories.size()) {
            super.setSelectedItem(categories.get(i));
        } else {
            System.err.printf("[ERRO] Índice inválido para lista - índice: %d", i);
        }
    }

    @Override
    public Object getElementAt(int index) {
        Object value = null;

        if (index >= 0 && index < categories.size()) {
            value = categories.get(index);
        }

        return value;
    }

    @Override
    public int getSize() {
        return categories.size();
    }

    public void load(List<Category> categories) {
        this.categories = categories;
        fireContentsChanged(this, 0, getSize());
    }

    public void remove(Category category) {
        int index = categories.indexOf(category);

        if (index >= 0) {
            categories.remove(index);
            fireIntervalRemoved(this, index, index);
        }
    }

    public void insert(Category category) {
        categories.add(category);
        fireIntervalAdded(this, getSize() - 1, getSize() - 1);
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> list) {
        this.categories = list;
    }

}
