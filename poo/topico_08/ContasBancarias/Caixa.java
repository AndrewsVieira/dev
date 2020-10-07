/* 
 * Classe que testa as classes Conta
 */

public class Caixa {
	public static void main(String[] args) {
		Conta conta1 = new Conta("Andrews", 1, 0.00);
		Conta conta2 = new Conta("Carolina", 2, 0.00);

		conta1.depositar(1000.00);

		System.out.println(conta1);

		conta1.sacar(50.00);

		System.out.println(conta1);

		conta1.transferir(950.00, conta2);

		System.out.println(conta1);
		System.out.println(conta2);

		Poupanca poupanca1 = new Poupanca("Zulmar", 3, 1000.00);

		poupanca1.aplicarRendimentoMensal(12);

		System.out.println(poupanca1);

		Corrente corrente1 = new Corrente("Goretti", 4, 1000.00);

		corrente1.pagarConta(500.00);

		System.out.println(corrente1);

		corrente1.descontarTarifa(12);

		System.out.println(corrente1);

		Investimento investimento1 = new Investimento("Thaynara", 5, 10000.00);

		investimento1.aplicarRendimentoMensal(12);

		System.out.println(investimento1);

		investimento1.cobrarIR();

		System.out.println(investimento1);

	}
}
