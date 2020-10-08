public abstract class Pizza {
	private String nome;
	private Tamanho tamanho;

	public Pizza(String nome, Tamanho tamanho) {
		this.nome = nome;
		this.tamanho = tamanho;
	}

	public String getNome() {
		return this.nome;
	}

	public int getFatias() {
		return this.tamanho.getFatias();
	}

	public abstract void preparar();

	public abstract void assar();

	public void cortar() {
		System.out.printf("A pizza está sendo cortada em %d fatias%n%n", getFatias());
	}

	@Override
	public String toString() {
		return String.format(	"%s%nPizza %s com %d fatias pronta para servir.%n%s",
								"-------------------------------------------------", 
								getNome(), 
								getFatias(),
								"-------------------------------------------------"	);
	}
}
