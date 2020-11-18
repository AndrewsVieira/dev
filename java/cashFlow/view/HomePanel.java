package view;

import javax.swing.JPanel;

public class HomePanel extends JPanel {
    Frame frame;
    MenuPanel menuPanel;

    public HomePanel(Frame frame) {
        this.frame = frame;
        menuPanel = new MenuPanel(this.frame);
        add(menuPanel);
    }

}
