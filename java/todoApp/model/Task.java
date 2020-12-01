package model;

import java.util.List;

public class Task {

    private int id;
    private String task;
    private String description;
    private List<Category> categories;

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setTask(String task) {
        this.task = task;
    }
    
    public String getTask() {
        return task;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Category> getCategories() {
        return categories;
    }

    @Override
    public String toString() {
        return String.format("%d: %s, %s\n", id, task, description);
    }
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (this.getClass() != obj.getClass()) {
            return false;
        }

        Task task = (Task) obj;
        return this.id == task.id;      
    }
} // fim da classe Task
