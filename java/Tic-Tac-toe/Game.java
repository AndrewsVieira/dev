public class Game {
    private static final int NUM_FIELDS = 9;

    String[] ticTacToe = new String[9];

    public Game() {
        for (int i = 0; i < NUM_FIELDS; i++) {
            this.ticTacToe[i] = String.valueOf(i); // String.valueOf para tornar i uma String
        }

    }

    public void setTicTacToe(String symbol, int index) {
        Symbols symbols = new Symbols();
        this.ticTacToe[index] = symbol.equals(symbols.getSymbol(0)) || symbol.equals(symbols.getSymbol(1)) ? symbol
                : null;
    }

    public String getTicTacToe(int index) {
        return this.ticTacToe[index];
    }

    @Override
    public String toString() {
        return String.format("|\t%s\t|\t%s\t|\t%s\t|\n|\t%s\t|\t%s\t|\t%s\t|\n|\t%s\t|\t%s\t|\t%s\t|\n\n",
                getTicTacToe(0), getTicTacToe(1), getTicTacToe(2), getTicTacToe(3), getTicTacToe(4), getTicTacToe(5),
                getTicTacToe(6), getTicTacToe(7), getTicTacToe(8));
    }

    public boolean checkWinningSequences(String symbol) {
        int[][] winningSequences = { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 }, { 0, 3, 6 }, { 1, 4, 7 }, { 2, 5, 8 },
                { 0, 4, 8 }, { 2, 4, 6 } };

        for (int[] sequence : winningSequences) {
            if (this.ticTacToe[sequence[0]].equals(symbol) && this.ticTacToe[sequence[1]].equals(symbol)
                    && this.ticTacToe[sequence[2]].equals(symbol)) {
                return true;
            }
        }
        return false;

    }

    public boolean checkTie() {
        Symbols symbols = new Symbols();
        int count = 0;
        for (int i = 0; i < NUM_FIELDS; i++) {
            if (getTicTacToe(i).equals(symbols.getSymbol(0))
                    || getTicTacToe(i).equals(symbols.getSymbol(1))) {
                count++;
            }
        }
        System.out.printf("count = %d\n", count);
        return count == 9 ? true : false;
    }

}
