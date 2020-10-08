public class ContasPagar {
	public static void main(String[] args) {
		ContasPagar contasPagar = new ContasPagar();
		contasPagar.executar();
	}

	public void executar() {
		Pagavel[] pagaveis = new Pagavel[5];

		pagaveis[0] = new FuncionarioAssalariado("Leia", "Organa", 8000.00);

		pagaveis[1] = new FuncionarioComissionado("Luke", "Skywalker", 120000.00, 5);

		pagaveis[2] = new FuncionarioHorista("Han", "Solo", 120, 40.00);

		pagaveis[3] = new Fatura("Companhia de Energia", 20000.00);

		pagaveis[4] = new Fatura("Provedor de Internet", 1000.00);

		double totalPagar = 0.0;
		for (Pagavel pagavel : pagaveis) {
			totalPagar += pagavel.obterValorPagar();
			System.out.println(pagavel);
		}

		System.out.printf("Valor total à pagar: $ %.2f%n%n", totalPagar);
					
	}
}
