public class Conta {
    	private String nome;
	private double saldo;

	// construtor inicializa o nome e o saldo inicial
	public Conta(String nome, double saldo) {
		this.nome = nome;

		// assegura que o saldo inicial seja maior que 0.0
		// se não for, inicializa com o valor padrão que é 0.0
		if (saldo > 0.0) {
			this.saldo = saldo;
		}
	}

 	public void setNome(String nome) {
		this.nome = nome;
	}

    	public String getNome() {
        	return this.nome;
    	}

	public double getSaldo() {
		return this.saldo;
	}

	// deposita um valor na conta, se for maior que 0.0
	public void depositar(double valor) {
		if (valor > 0.0) {
			this.saldo = this.saldo + valor;
		}
	}
	
	//saca um valor da conta, se for maior que 0.0
	// menor que o saldo
	public void sacar (double valor) {
		if (valor > 0.0	&& valor <= saldo) {
			this.saldo = this.saldo - valor;
		}
	}
}

























