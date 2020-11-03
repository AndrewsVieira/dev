public class Symbols {
    private String[] options = { "X", "O" };
    private int turnIndex = 0;

    public void change() {
        setTurnIndex(this.turnIndex);
    }

    public void setTurnIndex(int index) {
        this.turnIndex = this.turnIndex == 0 ? 1 : 0;
    }

    public int getTurnIndex() {
        return this.turnIndex;
    }

    public String getSymbol(int index) {
        return this.options[index];
    }

    @Override
    public String toString() {
        return String.format("%s", this.options[getTurnIndex()]);
    }
}
