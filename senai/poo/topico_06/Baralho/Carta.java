// Classe que representa uma carta do baralho.

public class Carta {
	private String face;
	private String naipe;

	public Carta(String face, String naipe) {
		this.face = face;
		this.naipe = naipe;
	}

	public String toString() {
		return face + " de " + naipe;
	}
}// fim da classe Carta.
	
