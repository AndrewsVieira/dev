import java.util.Scanner;

public class TestFatorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // questão a)
        int numero = 0;
        System.out.print("Digite um número inteiro positivo: ");
        numero = scanner.nextInt();

        Fatorial fatorial = new Fatorial(numero);

        System.out.printf("%d! = %d%n%n", numero, fatorial.getFatorial());

        // questão b)

        double euler = 1;

        for (int i = numero; i > 0; i--) {
            Fatorial fatorialParaEuler = new Fatorial(i);
            double divisor = fatorialParaEuler.getFatorial();
            euler += 1 / divisor;
        }

        System.out.printf("e[%d] = %.4f%n%n", numero, euler);

        // questão c)

        double eulerExponencial = 1; // e^x
        double numeroDividendo = (double) numero;

        for (int i = numero; i > 0; i--) {
            Fatorial fatorialParaEulerExponencial = new Fatorial(i);
            double divisor1 = fatorialParaEulerExponencial.getFatorial();
            double dividendo = Math.pow(numeroDividendo, i);
            eulerExponencial += dividendo / divisor1;
        }

        System.out.printf("e^(%d) = %.4f%n%n", numero, eulerExponencial);
    }
}