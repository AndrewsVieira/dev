// Embaralhando e distribuindo cartas para 4 jogadores

public class Jogo {
    private static final int NUMERO_DE_JOGADORES = 4;

    public static void main(String[] args) {
        Baralho baralho = new Baralho();
        baralho.embaralhar();

        String formato = "%-19s ";

        for (int i = 1; i <= NUMERO_DE_JOGADORES; i++) {
            System.out.printf(formato, "Jogador " + i);
        }
        System.out.println();

        for (int i = 1; i <= Baralho.NUMERO_DE_CARTAS; i++) {
            System.out.printf(formato, baralho.darUmaCarta());

            if ( i%4 == 0) {
                System.out.println();
            }
        }
    }// fim do método main
}