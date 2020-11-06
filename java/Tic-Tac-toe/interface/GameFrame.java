import javax.swing.JButton;
public class GameFrame extends PrincipalFrame {
    private static final int NUM_FIELDS = 9;

    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btn4;
    private JButton btn5;
    private JButton btn6;
    private JButton btn7;
    private JButton btn8;
    private JButton btn9;

    public GameFrame(String name) {
        super(name);

        init();

        pack();
    }

    public void init() {
        btn1 = new JButton();
        
        addComponent(btn1, 1, 1, 1, 1);

        btn2= new JButton();
        addComponent(btn2, 1, 2, 1, 1);

        btn3 = new JButton();
        addComponent(btn3, 1, 3, 1, 1);

        btn4 = new JButton();
        addComponent(btn4, 2, 1, 1, 1);

        btn5 = new JButton();
        addComponent(btn5, 2, 2, 1, 1);

        btn6 = new JButton();
        addComponent(btn6, 2, 3, 1, 1);

        btn7 = new JButton();
        addComponent(btn7, 3, 1, 1, 1);

        btn8 = new JButton();
        addComponent(btn8, 3, 2, 1, 1);

        btn9 = new JButton();
        addComponent(btn9, 3, 3, 1, 1);
    }
}
