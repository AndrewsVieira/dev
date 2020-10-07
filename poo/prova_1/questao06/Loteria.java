/*
 * Loteria.java
 *
 * Classe que executa o programa e verifica o vencedor.
 */

public class Loteria {
    private static final int QTDE_DEZENAS = 6;
    private static final int MENOR_DEZENA = 1;
    private static final int MAIOR_DEZENA = 60;

    public static void main(String[] args) {
    // Implemente este método

    //Um jogador faça uma aposta;
    Jogador jogador1 = new Jogador();
    jogador1.apostar(QTDE_DEZENAS, MENOR_DEZENA, MAIOR_DEZENA);
    
    //Um sorteio seja realizado e as dezenas sorteadas sejam exibidas na tela (Ex.: Números sorteados: 3 10 40 23 59 1);
    
    int[] sorteio = Sorteio.sortear(QTDE_DEZENAS, MENOR_DEZENA, MAIOR_DEZENA);
    String formato = "Números sorteados: ";
    for (int i = 0; i < sorteio.length; i++) {
        formato += sorteio[i] + " ";        
    }
    System.out.println(formato);

    //A aposta do jogador seja comparada com as dezenas sorteadas;

    int[] aposta1 = jogador1.getAposta();
    boolean acerto; 
    int qtdeAcertos = 0;
    
    for (int i = 0; i < sorteio.length; i++) {
        for (int j = 0; j < aposta1.length; j++) {
            acerto = sorteio[i] == aposta1[j];
            if (acerto) {
                qtdeAcertos++;
            }
        }
    }

    //Caso o jogador acerte 5 (cinco) ou 6 (seis) dezenas, exibir na tela uma mensagem dizendo "Você ganhou! Você acertou n dezenas.", onde o n deve ser substituído pelo número de dezenas certas na aposta;
    //Caso o jogador acerte 4 (quatro) ou menos dezenas, exibir na tela uma mensagem dizendo "Sinto muito! Não foi desta vez. Você acertou n dezenas.", onde o n deve ser substituído pelo número de dezenas certas na aposta.

    if (qtdeAcertos >= 5) {
        System.out.printf("Você ganhou! Você acertou %d dezenas.%n", qtdeAcertos);
    } else {
        System.out.printf("Sinto muito! Não foi desta vez. Você acertou %d dezena(s).%n", qtdeAcertos);
    }

    } // fim do método main
    
} // fim da classe Loteria