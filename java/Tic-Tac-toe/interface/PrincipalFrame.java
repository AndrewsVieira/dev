import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;



public class PrincipalFrame extends JFrame {
    private static final Insets FIELD_INSETS = new Insets(5, 10, 0, 0);


    private GridBagLayout layout;
    private GridBagConstraints constraints;

    private JPanel panel;

    public PrincipalFrame(String name) {
        super(name);

        layout = new GridBagLayout();
        constraints = new GridBagConstraints();
        panel = new JPanel();
        

        init();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
    }
    
    private void init() {
        setLayout(new GridLayout(1,2,2,2));

        panel.setLayout(layout);
        add(panel);

        
    } 

    public void addComponent(JComponent comp, int row, int col, int width, int height) {
        constraints.gridx = col;
        constraints.gridy = row;
        constraints.gridwidth = width;
        constraints.gridheight = height;
        constraints.fill = GridBagConstraints.BOTH;;
        constraints.insets = FIELD_INSETS;

        layout.setConstraints(comp, constraints);
        panel.add(comp);
    }
}
