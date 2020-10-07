public class Fibonacci {
    private int[] fibonacciSequences;

    public Fibonacci(int limite) {
        this.fibonacciSequences = new int[limite];

        for (int i = 0; i < fibonacciSequences.length; i++) {
            if (i > 1) {
                fibonacciSequences[i] = fibonacciSequences[i-2] + fibonacciSequences[i-1];
            } else {
                fibonacciSequences[i] = i;
            }
        }
    }

    public String toString() {
        String resposta = "";

        for (int i = 0; i < this.fibonacciSequences.length; i++) {
            resposta += this.fibonacciSequences[i] + ";"; 
        }

        return resposta;
    }

    public int[] getFibonacciSequences() {
        return this.fibonacciSequences;
    }
}