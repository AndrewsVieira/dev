import java.util.Scanner;

import javax.swing.JFrame;

public class TicTacToe {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        JFrame frame = new PrincipalFrame("Tic-Tac-Toe");
        frame.setVisible(true);
    }
}