import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrincipalFrame extends JFrame {
    private static final int NUM_BTN = 9;

    private JButton[] btns = new JButton[NUM_BTN];
    private int sizeArrayBtns = btns.length;
    private String title;

    public PrincipalFrame(String title) {
        super(title);
        this.title = title;

        this.setSize(640, 480);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        init();
    }

    private void init() {
        ActionEventHandler handler = new ActionEventHandler();

        setLayout(new GridLayout(3, 3, 0, 0));

        for (int i = 0; i < sizeArrayBtns; i++) {
            btns[i] = new JButton();
            add(btns[i]);
            btns[i].addActionListener(handler);
        }

    }

    private class ActionEventHandler implements ActionListener {
        private Symbols symbol = new Symbols();
        private String symbolTurnIndex;
        private Game game = new Game();
        private boolean winsMessage;

        @Override
        public void actionPerformed(ActionEvent e) {
            int position = -1;
            symbolTurnIndex = symbol.getSymbol(symbol.getTurnIndex());

            // uso do for para percorrer o array btns
            for (int i = 0; i < sizeArrayBtns; i++) {
                // uso do if para verificar em qual btn que aconteceu o evento(click)
                if (e.getSource() == btns[i]) {
                    btns[i].setText(symbolTurnIndex);
                    position = i;
                    // mudar a cor do botão dependendo do symbolTurnIndex (X/O)
                    if (symbolTurnIndex == "X") {
                        btns[i].setBackground(Color.CYAN);
                    } else {
                        btns[i].setBackground(Color.GREEN);
                    }
                    // quando aciona o evento em algum botão, desabilita o evento
                    btns[i].removeActionListener(this);
                }
            }
            if (position > -1) {
                game.setTicTacToe(symbolTurnIndex, position);

                if (game.checkWinningSequences(symbolTurnIndex) || game.checkTie()) {
                    // parar os eventos de click's quando terminar o jogo
                    for (int i = 0; i < sizeArrayBtns; i++) {
                        btns[i].removeActionListener(this);
                    }
                    // caixa de diálogo
    
                    if (game.checkWinningSequences(symbolTurnIndex)) {
                        winsMessage = true; // X/O ganhou
                        confirmDialog(winsMessage);
                    } else {
                        winsMessage = false; // foi empate
                        confirmDialog(winsMessage);
                    }
                }
            }

            symbol.change();
        }

        private void confirmDialog(boolean msg) {
            if (msg) {
                int answer = JOptionPane.showConfirmDialog(null,
                        "The symbols '" + symbolTurnIndex + "' wins!\nWould you like to play again?");
                if (answer == JOptionPane.OK_OPTION) {
                    setVisible(false);
                    // reiniciar o jogo
                    JFrame frame = new PrincipalFrame("Tic-Tac-Toe");
                    frame.setVisible(true);
                } else if (answer == JOptionPane.NO_OPTION) {
                    setVisible(false);
                }
            } else {
                int answer = JOptionPane.showConfirmDialog(null,
                        "The game tied!\nWould you like to play again?");
                if (answer == JOptionPane.OK_OPTION) {
                    setVisible(false);
                    // reiniciar o jogo
                    JFrame frame = new PrincipalFrame("Tic-Tac-Toe");
                    frame.setVisible(true);
                } else if (answer == JOptionPane.NO_OPTION) {
                    setVisible(false);
                }
            }
        }
    }
}