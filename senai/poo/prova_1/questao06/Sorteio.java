/*
 * Sorteio.java
 *
 * Classe que realiza os sorteios da loteria.
 */

import java.util.Random;

public class Sorteio {
    private static final Random random = new Random();

    /*
     * Sorteia e retorna um array de dezenas distintas.
     */
    public static int[] sortear(int qtdeDezenas, int min, int max) {
	int[] sorteio = new int[qtdeDezenas];
	boolean valido;

	for (int i = 0; i < qtdeDezenas; i++) {
	    do {
		valido = true;
		
		sorteio[i] = min + random.nextInt(max);

		for (int j = 0; j < i; j++) {
		    if (sorteio[j] == sorteio[i]) {
			valido = false;
			break;
		    }
		}
	    } while (!valido);
	}

	return sorteio;
    } // fim do método sortear
    
} // fim da classe Sorteio