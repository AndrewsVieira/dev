package view;

import javax.swing.JPanel;

public class CashFlowPanel extends JPanel {
    Frame frame;
    MenuPanel menuPanel;

    public CashFlowPanel(Frame frame) {
        this.frame = frame;
        menuPanel = new MenuPanel(this.frame);
        add(menuPanel);
    }
}
