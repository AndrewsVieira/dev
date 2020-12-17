package src.view.panels;

import javax.swing.JPanel;

import src.view.Frame;

public class HomePanel extends JPanel {
    Frame frame;
    MenuPanel menuPanel;

    public HomePanel(Frame frame) {
        this.frame = frame;
        menuPanel = new MenuPanel(this.frame);
        add(menuPanel);
    }

}
