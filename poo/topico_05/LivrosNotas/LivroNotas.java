/* LivroNotas.java
Calcula a média das notas dos alunos de uma unidade curricula*/

import java.util.Scanner;

public class LivroNotas {
    private String nomeUC;

    public LivroNotas(String nomeUC) {
        this.nomeUC = nomeUC;
    }

    public String getNomeUC() {
        return this.nomeUC;
    }

    public void exibirMensagem() {
        System.out.printf("Bem-vindo(a) a UC \"%s\"!%n%n", getNomeUC());
    }

    public void calcularMediaAlunos(int numAlunos) {
        Scanner scanner = new Scanner(System.in);

        double nota;
        double media;
        double total = 0;
        boolean valido;

        for (int i = 1; i <= numAlunos; i++) {
            do {
                System.out.print("Informe a nota: ");
                nota = scanner.nextDouble();

                valido = nota >= 0.0 && nota <= 10.0;

                if (!valido) {
                    System.out.printf("%.1f não é uma nota válida! %n", nota);
                }
            } while (!valido);

            System.out.printf("Conceito = %c%n", converterParaConceito(nota));
            total += nota;
        }

        media = total / numAlunos;

        System.out.printf("%nSoma da(s) %d notas(s) = %.1f%n", numAlunos, total);
        System.out.printf("Média da turma = %.1f%n", media);
        System.out.printf("Conceito da turma = %c%n", converterParaConceito(media));
    }// fim do método calcularMediaAlunos

    private char converterParaConceito(double nota) {
        char conceito;
        int notaInt = (int) nota;

        switch (notaInt) {
            case 9:
            case 10:
                conceito = 'A';
                break;
            case 8:
                conceito = 'B';
                break;
            case 7:
                conceito = 'C';
                break;
            case 6:
                conceito = 'D';
                break;
            default:
                conceito = 'F';

        }

        return conceito;
    }// fim do método converterParaConceito
}//fim da classe LivroNotas
