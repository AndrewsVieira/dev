import java.util.Scanner;

public class Tela {
    private static Scanner scanner = new Scanner(System.in);

    //A classe Tela deve oferecer um método boasVindas para exibir uma mensagem no início da execução do programa;
    public static void boasVindas() {
        System.out.println("Seja bem-vindo(a)!!");
    }

    //A classe Tela deve oferecer um método pedirNota para solicitar ao usuário uma nota para um determinado usuário (idAluno);
    public static double pedirNota(int idAluno) {
        System.out.printf("Digite a nota do aluno %d: %n", idAluno);
        double nota = scanner.nextDouble();
        return nota;
    }

    //A classe Tela deve oferecer um método imprimeMedias que exibe para o usuário o nome da UC e, na linha seguinte, uma identificação do aluno (ex.: Aluno 0, Aluno 1, etc.) seguida pela sua média, colocando um aluno por linha;
    public static void imprimeMedias(double[] medias, String nomeUC) {
        System.out.printf("UC %s%n", nomeUC);
        for (int i = 0; i < medias.length; i++) {
            System.out.printf("Aluno %d: %.1f%n", i, medias[i]);
        }
    }

    //A classe Tela deve oferecer um método imprimeMedia que exibe para o usuário o nome da UC e, na linha seguinte, a identificação de um aluno específico (idAluno) seguida da média deste aluno;
    public static void imprimeMedia(double media, String nomeUC, int idAluno) {
        System.out.printf("UC %s%n", nomeUC);
        System.out.printf("Aluno %d: %.1f%n", idAluno, media);
    }
}