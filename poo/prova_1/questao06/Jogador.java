/*
 * Jogador.java
 *
 * Classe que modela um jogador da loteria.
 */

import java.util.Scanner;

public class Jogador {
    private int[] aposta;

    public int[] getAposta() {
	return aposta;
    } // fim do método getAposta

    /*
     * Registra uma aposta do jogador, solicitando as dezenas.
     */
    public void apostar(int qtdeDezenas, int min, int max) {
	aposta = new int[qtdeDezenas];

	int dezena;
	for (int i = 0; i < qtdeDezenas; i++) {
	    dezena = informarDezena(i, min, max);
	    aposta[i] = dezena;
	}
    } // fim do método apostar

    /*
     * Solicita a i-ésima dezena da aposta. Valida se a dezena informada está no intervalo entre a menor e maior dezena permitidas. Valida também se a dezena não foi informada anteriormente.
     */
    private int informarDezena(int i, int min, int max) {
	Scanner scanner = new Scanner(System.in);
	int dezena;
	boolean valido;
	
	do {
	    System.out.printf("Informe a %da. dezena: ", i+1);
	    dezena = scanner.nextInt();
	    
	    valido = dezena >= min && dezena <= max;
	    if (!valido) {
		System.out.printf("Dezena inválida! Dezena deve estar entre %d e %d.%n%n", min, max);
	    } else {
		for (int d : aposta) {
		    if (d == dezena) {
			System.out.println("Dezena repetida!\n");
			valido = false;
			break;
		    }
		}
	    }
	} while(!valido);

	return dezena;
    } // fim do método informarDezena
    
} // fim da classe Jogador