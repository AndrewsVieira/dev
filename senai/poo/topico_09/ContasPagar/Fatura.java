public class Fatura implements Pagavel {
	public String fornecedor;
	public double valorNota;

	public Fatura(String fornecedor, double valorNota) {
		this.fornecedor = fornecedor;
		this.valorNota = valorNota;
	}

	@Override
	public String toString() {
		return String.format("%s: %s%n\t%s: $ %.2f%n",
				"Fornecedor", this.fornecedor,
				"Valor da nota", this.valorNota);
	}
	
	@Override
	public double obterValorPagar() {
		return this.valorNota;
	}
}
