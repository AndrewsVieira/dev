import java.util.Scanner;

import javax.swing.JFrame;

public class TicTacToe {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // TicTacToe ticTacToe = new TicTacToe();

        JFrame frame = new PrincipalFrame("Tic-Tac-Toe");
        frame.setVisible(true);
        
        // ticTacToe.init();
    }


	// private void init() {
    //     Symbols symbols = new Symbols();
    //     Game ticTacToe = new Game();

    //     wellcome();

    //     System.out.println(ticTacToe);

    //     boolean gameOver = false;
    //     while (!gameOver) {
    //         String symbol = symbols.toString(); 

    //         System.out.print("Escolha a posição: ");
    //         int position = scanner.nextInt();

    //         ticTacToe.setTicTacToe(symbol, position);
    //         System.out.println(ticTacToe);

    //         if (ticTacToe.checkWinningSequences(symbol)) {
    //             congratulations(symbol);
    //             gameOver = true;
    //         }
    //         if (ticTacToe.checkTie()) {
    //             System.out.println("Deu velha!!\n");
    //             gameOver = true;
    //         }

    //         symbols.change();
    //     }

    // }

    // private static void wellcome() {
    //     System.out.println(
    //             "Seja bem-vindo.\nEste é o TIC-TAC-TOE, famoso jogo da velha.\nSímbolos aceitos são o 'X' e o 'O'.\nAs posições são escolhidas conforme mostrado abaixo.\nBom jogo!!\n");
    // }

    // private static void congratulations(String symbol) {
    //     System.out.printf("Parabéns!\nQuem estava com o símbolo '%s' venceu!!\n", symbol);
    // }
}