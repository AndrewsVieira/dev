package model;

import java.util.ArrayList;
import java.util.List;

// representa um banco de dados para tarefas

public class TaskDB {

    private static int id = 0;
    private static List<Task> tasks = new ArrayList<>();

    public static void insert(Task task) {
        task.setId(++id);
        tasks.add(task);

        System.out.println(task);
    }

    public static void update(Task task) {
        int i = tasks.indexOf(task);
        if (i >= 0) {
            tasks.set(i, task);
        }
    }

    public static void delete(Task task) {
        tasks.remove(task);
    }

    public static List<Task> list() {
        return tasks;
    }
} // fim da classe TaskDB
