import java.io.Serializable;

public class Conta implements Serializable {
	private String nome;
	private String sobrenome;
	private double saldo;

	public Conta(String nome, String sobrenome, double saldo) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.saldo = saldo;
	}

	public Conta(String nome, String sobrenome) {
		this(nome, sobrenome, 0.0);
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return String.format("Conta:%n\tNome: %s%n\tSobrenome: %s%n\tSaldo: R$ %.2f%n", nome, sobrenome, saldo);
	}
} // fim da classe Conta
