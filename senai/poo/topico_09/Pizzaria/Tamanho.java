public enum Tamanho {
	BROTO(4), MEDIA(6), GRANDE(8), GIGANTE(10);

	private final int fatias;

	private Tamanho(int fatias) {
		this.fatias = fatias;
	}

	public int getFatias() {
		return this.fatias;
	}
}
