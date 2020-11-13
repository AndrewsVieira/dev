package view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.CardLayout;

public class ToDoFrame extends JFrame {
    public static String TITLE = "TODO App";

    private CardLayout layout;
    private JPanel cardsPanel;

    private HomePanel homePanel;
    private MainPanel mainPanel;
    private FormPanel formPanel;
    
    public ToDoFrame() {
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
        layout.show(cardsPanel, MainPanel.class.getName());
    }

    public void showFormPanel() {
        layout.show(cardsPanel, FormPanel.class.getName());
    }
    
    private void createCards() {
        homePanel = new HomePanel(this);
        cardsPanel.add(homePanel, HomePanel.class.getName());

        mainPanel = new MainPanel(this);
        cardsPanel.add(mainPanel, MainPanel.class.getName());

        formPanel = new FormPanel(this);
        cardsPanel.add(formPanel, FormPanel.class.getName());
        
    }
    
} // fim da classe ToDoScreen
