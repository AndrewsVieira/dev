import java.util.Scanner;

public class LocalizeMaiorNumero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        int largest = 0;
        String cadeiaDenumbers = "";

        for (int counter = 0; counter <= 10; counter++) {
            System.out.print("Digite um número inteiro: ");
            number = scanner.nextInt();

            if (number > largest) {
                largest = number;
            }

            if (counter < 10) {
                cadeiaDenumbers += number + ", ";
            } else {
                cadeiaDenumbers += number + ".";
            }

            
        }
        System.out.printf("Lista de números escolhidos: [%s].%n", cadeiaDenumbers);
        System.out.printf("O maior escolhido é o número %d.%n", largest);
    }
}