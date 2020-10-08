// Face.java - enumerador de faces do baralho.
public enum Face {
	AS("A"), DOIS("2"), TRES("3"), QUATRO("4"), CINCO("5"), SEIS("6"), SETE("7"), OITO("8"), NOVE("9"), DEZ("10"), VALETE("J"), DAMA("Q"), REI("K");

	private final String valor;

	private Face(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return this.valor;		
	}

}//fim do enumerador
