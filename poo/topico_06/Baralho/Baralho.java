
// classe que representa um baralho de cartas.
import java.util.Random;

public class Baralho {
    private Carta[] deque;
    private int cartaTopo;

    // constantes da classe
    public static final int NUMERO_DE_CARTAS = 52;
    private static final Random random = new Random();

    public Baralho() {
        deque = new Carta[NUMERO_DE_CARTAS];
        cartaTopo = 0;

        String[] faces = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
        String[] naipes = { "Copas", "Ouro", "Espadas", "Paus" };

        for (int i = 0; i < deque.length; i++) {
            deque[i] = new Carta(faces[i % faces.length], naipes[i / faces.length]);
        }
    }// fim do construtor
    

    public void embaralhar() {
        cartaTopo = 0;

        for (int i = 0; i < deque.length; i++) {
            int j = random.nextInt(NUMERO_DE_CARTAS);

            Carta temp = deque[i];
            deque[i] = deque[j];
            deque[j] = temp;
        }
    }// fim do método embaralhar.

    public Carta darUmaCarta() {
        Carta carta = null;

        if (cartaTopo < deque.length) {
            carta = deque[cartaTopo++];
        }

        return carta;
    }// fim do método darUmaCarta

    
}