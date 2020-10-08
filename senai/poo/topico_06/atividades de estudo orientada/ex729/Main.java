import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o n-ésimo número de Fibonacci: ");
        int n = scanner.nextInt();

        Fibonacci fibonacci = new Fibonacci(n+1);

        int[] fibonacciSequences = fibonacci.getFibonacciSequences();

        int nEsimo = fibonacciSequences[n];

        System.out.printf("O n-ésimo que você escolheu é o %d.%n", nEsimo);
    }
}
