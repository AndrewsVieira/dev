package view;
import model.Task;

import javax.swing.JFrame;
import javax.swing.JPanel;


import java.awt.CardLayout;

public class TodoFrame extends JFrame {
    public static String TITLE = "TODO App";

    private CardLayout layout;
    private JPanel cardsPanel;

    private FirstFrame homePanel;
    private MainPanel mainPanel;
    private FormPanel formPanel;
    
    public TodoFrame() {
        super(TITLE);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        layout = new CardLayout();
        
        cardsPanel = new JPanel();
        cardsPanel.setLayout(layout);
        add(cardsPanel);

        createCards();
    }

    public void draw() {
        pack();       
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void showMainPanel() {
        mainPanel.reload();
        layout.show(cardsPanel, MainPanel.class.getName());
    }

    public void showFormPanel(Task task) {
        formPanel.setTask(task);
        layout.show(cardsPanel, FormPanel.class.getName());
    }
    
    private void createCards() {
        homePanel = new FirstFrame(this);
        cardsPanel.add(homePanel, FirstFrame.class.getName());

        mainPanel = new MainPanel(this);
        cardsPanel.add(mainPanel, MainPanel.class.getName());

        formPanel = new FormPanel(this);
        cardsPanel.add(formPanel, FormPanel.class.getName());
        
    }
    
} // fim da classe ToDoScreen
