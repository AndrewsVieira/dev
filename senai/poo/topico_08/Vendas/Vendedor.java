/* 
 * Vendedor é uma classe que representa um vendedor de uma loja que recebe 
 * mensalmente apenas o salário base.
 */

public class Vendedor {
	private String nome;
	private String sobrenome;
	private double valorVendidoMes;
	private double salarioBase;

	// Construtor que inicializa o nome, sobrenome e salário base.
	
	public Vendedor(String nome, String sobrenome, double salarioBase) {
		this.nome = (nome != null && !nome.isBlank() ? nome : "Não informado");
		this.sobrenome = (sobrenome != null && !nome.isBlank() ? sobrenome : "Não informado");
		this.salarioBase = (salarioBase > 0.0 ? salarioBase : 0.0);
	}

	public String getNome() {
		return this.nome;
	}

	public String getSobrenome() {
		return this.sobrenome;
	}

	public double getSalarioBase() {
		return this.salarioBase;
	}

	public void setValorVendidoMes(double valorVendidoMes) {
		this.valorVendidoMes = (valorVendidoMes > 0.0 ? valorVendidoMes : 0.0);
	}

	public double getValorVendidoMes() {
		return this.valorVendidoMes;
	}

	public double getSalario() {
		return this.salarioBase;
	}

	@Override
	public String toString() {
		return String.format("%s: %s %s%n\t%s: $ %.2f%n\t%s: $ %.2f%n\t%s: $ %.2f", "Vendedor", this.nome, this.sobrenome, "Salário Base", this.salarioBase, "Vendas no mês", this.valorVendidoMes, "Salário", getSalario());
	}

}// fim da classe
