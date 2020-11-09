import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrincipalFrame extends JFrame {
    private static final int NUM_BTN = 9;

    private JButton[] btns = new JButton[NUM_BTN];
    private int sizeArrayBtns = btns.length;

    public PrincipalFrame(String title) {
        super(title);

        this.setSize(640, 480);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        init();
    }

    public void init() {
        ActionEventHandler handler = new ActionEventHandler();

        setLayout(new GridLayout(3, 3, 0, 0));

        for (int i = 0; i < sizeArrayBtns; i++) {
            btns[i] = new JButton();
            add(btns[i]);
            btns[i].addActionListener(handler);
        }

    }

    private class ActionEventHandler implements ActionListener {
        Symbols symbol = new Symbols();
        Game game = new Game();

        @Override
        public void actionPerformed(ActionEvent e) {
            int position = -1;

            // uso do for para percorrer o array btns
            for (int i = 0; i < sizeArrayBtns; i++) {
                // uso do if para verificar em qual btn que aconteceu o click
                if (e.getSource() == btns[i]) {
                    btns[i].setText(symbol.getSymbol(symbol.getTurnIndex()));
                    position = i;
                }
            }
            if (position > -1) {
                game.setTicTacToe(symbol.getSymbol(symbol.getTurnIndex()), position);
                System.out.println(game.toString());
                
                if (game.checkWinningSequences(symbol.getSymbol(symbol.getTurnIndex())) || game.checkTie()) {
                    System.out.println("Game-over");
                }
            }
            
            symbol.change();
        }
    }
}