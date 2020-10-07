import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int numeroSorteio = Sorteio.sortear();
        Scanner  scanner = new Scanner(System.in);
        String resposta;
        boolean advinhou = false;

        while(!advinhou) {
            System.out.print("Advinhe um número entre 1 e 1000: ");
            int numero = scanner.nextInt();

            if (numeroSorteio == numero) {
                resposta = "Parabéns, você advinhou!!\n";
                advinhou = true;
            } else if (numeroSorteio < numero) {
                resposta = "Muito alto! tente novamente!\n";
            } else {
                resposta = "Muito baixo! tente novamente!\n";
            }
            System.out.println(resposta);

            if (advinhou) {
                scanner.nextLine();

                System.out.print("Deseja jogar novamente? (s/n) ");
                String jogarNovamente = scanner.nextLine().toUpperCase();

                if (jogarNovamente.equals("S")) {
                    advinhou = false;
                }

            }

            
        }
    }
}
