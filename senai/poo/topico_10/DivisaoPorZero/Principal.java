import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean repetir = true;

        do {
            try {
                System.out.print("Informe um numerador inteiro: ");
                int numerador = scanner.nextInt();

                System.out.print("Informe um denominador inteiro: ");
                int denominador = scanner.nextInt();

                int quociente = Calculadora.dividir(numerador, denominador);
                System.out.printf(  "Resultado: %d / %d = %d%n",
                                    numerador,
                                    denominador,
                                    quociente    );

                repetir = false;
            }

            catch (InputMismatchException inputMismatchException) {
                System.err.printf("%nExceção: %s%n", inputMismatchException);
                scanner.next(); // descartar o restante da entrada
                System.out.print("Apenas números inteiros são permitidos!\n\n");
            }
            catch (ArithmeticException arithmeticException) {
                System.err.printf("%nExceção: %s%n", arithmeticException);
                System.out.print("Zero é um denominador inválido!\n\n");
            }
        } while (repetir);
    }
}
