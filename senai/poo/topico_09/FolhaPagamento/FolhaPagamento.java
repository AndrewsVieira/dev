public class FolhaPagamento {
    public static void main(String[] args) {
        FolhaPagamento folhaPagamento = new FolhaPagamento();
        folhaPagamento.executar();
    }
    public void executar() {
        Funcionario[] funcionarios = new Funcionario[3];
        funcionarios[0] = new FuncionarioAssalariado("Leia", "Organa", 8000.00);
        funcionarios[1] = new FuncionarioComissionado("Luke", "Skywalker", 120000.00, 5);
        funcionarios[2] = new FuncionarioHorista("Han", "Solo", 120, 40.00);

        double valorFolha = 0.0;
        for (Funcionario funcionario : funcionarios) {
            if(funcionario instanceof FuncionarioAssalariado) {
                FuncionarioAssalariado funcionarioAssalariado = (FuncionarioAssalariado) funcionario; // downcasting
                funcionarioAssalariado.darAumento(10);
            }

            valorFolha += funcionario.calcularSalarioMensal();
            System.out.println(funcionario);
        }
        System.out.printf("Valor da folha de pagamento: $ %.2f%n%n", valorFolha);
    }
}
