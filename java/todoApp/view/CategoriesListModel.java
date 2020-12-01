package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;

import model.Category;

public class CategoriesListModel extends AbstractListModel {
    private List<Category> categories = new ArrayList<>();

    public CategoriesListModel(List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public Object getElementAt(int i) {
        Category category = null;

        if (i >= 0 && i < getSize()) {
            category = categories.get(i);
        }

        return category;
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
        fireIntervalAdded(this, getSize()-1, getSize()-1);
    }

    public List<Category> getCategories() {
        return categories;
    }
    
}
