package view.panels;

import javax.swing.JPanel;

import view.Frame;

public class HomePanel extends JPanel {
    Frame frame;
    MenuPanel menuPanel;

    public HomePanel(Frame frame) {
        this.frame = frame;
        menuPanel = new MenuPanel(this.frame);
        add(menuPanel);
    }

}
