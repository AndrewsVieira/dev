/*
 *Classe que cria uma conta básica, somente com o número da conta, um nome e um saldo
 */

public class Conta {
	private String nome;
	private int numero;
	private double saldo;

	public Conta(String nome, int numero, double saldo) {
		this.nome = (nome != null && !nome.isBlank() ? nome : "Nome inválido");
		this.numero = (numero > 0 && numero <= 9999 ? numero : 0);
		this.saldo = (saldo > 0.00 ? saldo : 0.00);
	}

	public String getConta() {
		return String.format("%04d", this.numero);
	}

	public String getNome() {
		return this.nome;
	}

	protected void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getSaldo() {
		return this.saldo;
	}

	public void sacar(double valor) {
		setSaldo(getSaldo() - valor);
	}

	public void depositar(double valor) {
		setSaldo(getSaldo() + valor);
	}

	public void transferir(double valor, Conta conta1) {
		sacar(valor);
		conta1.depositar(valor);
	}

	@Override
	public String toString() {
		return String.format("%nConta %s - %s - Saldo: $ %.2f%n", getConta(), getNome(), getSaldo());
	}
}
