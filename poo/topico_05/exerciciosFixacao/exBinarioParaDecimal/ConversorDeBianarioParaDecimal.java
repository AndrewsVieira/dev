import java.util.Scanner;

// classe converte um número binário em um número decimal

public class ConversorDeBianarioParaDecimal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número inteiro da base binária: ");
        String numeroBinario = scanner.nextLine();

        // calcular aqui
        int tamanhoNumeroBinario = numeroBinario.length();
        char numero;
        int posicao;
        double potencia;
        double soma = 0;

        for (int i = 1; i <= tamanhoNumeroBinario; i++) {
            posicao = tamanhoNumeroBinario - i;
            numero = numeroBinario.charAt(posicao);
            potencia = (double) posicao;
            if(numero == '1'){
                soma += Math.pow(2, potencia);
            }
        }
        System.out.printf("O número %s na base decimal fica %.0f.%n", numeroBinario, soma);
    }
}