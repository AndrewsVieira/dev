package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class FirstFrame extends JPanel {
    private TodoFrame frame;
    private JButton btn;

    public FirstFrame(TodoFrame toDoFrame) {

        this.frame = toDoFrame;

        btn = new JButton("Tarefas");
        add(btn);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.showMainPanel();
            }
        });
    }
    
}
