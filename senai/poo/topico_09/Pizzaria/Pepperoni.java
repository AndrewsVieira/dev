public class Pepperoni extends Pizza {
	private static final String[] INGREDIENTES = {
		"Molho",
		"Queijo",
		"Salame"	
	};

	private static final int TEMPO = 15;

	public Pepperoni(String nome, Tamanho tamanho) {
		super(nome, tamanho);
	}

	public void preparar() {
		System.out.printf(	"%n%s %s:%n%s %s%n%s %s%n%s %s%n%n",
							"Preparando pizza de", super.getNome(),
							"Colocando", INGREDIENTES[0],
							"Colocando", INGREDIENTES[1],
							"Colocando", INGREDIENTES[2]			);				
	}

	public void assar() {
		System.out.printf("Pizza %s assando, isso leva %d minutos.%n%n", 
				super.getNome(), TEMPO);
	} 
}
