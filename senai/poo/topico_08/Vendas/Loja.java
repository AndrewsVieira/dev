/*
 * Loja é a classe que inicializa o programa.
 */

public class Loja {
	public static void main(String[] args) {
		Vendedor joao = new Vendedor("João", "Silveira", 1000.00);
		joao.setValorVendidoMes(12000.00);
		System.out.println(joao);

		VendedorComissionado jose = new VendedorComissionado("José", "Silva", 2000.00, 3);
		jose.setValorVendidoMes(12000.00);
		System.out.println(jose);

		joao.setValorVendidoMes(24000.00);
		System.out.printf("%nSalário do %s %s depois do aumento de vendas%n", joao.getNome(), joao.getSobrenome());
		System.out.println(joao);

		jose.setValorVendidoMes(24000.00);
		System.out.printf("%nSalário do %s %s depois do aumento de vendas%n", jose.getNome(), jose.getSobrenome());
		System.out.println(jose);
	}// fim do método main.

}// fim da classe Loja.
