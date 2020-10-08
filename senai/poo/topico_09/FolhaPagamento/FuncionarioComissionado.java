public class FuncionarioComissionado extends Funcionario {
    public double valorVendido;
    public int porcentualComissao;

    public FuncionarioComissionado(String nome, String sobrenome, double valorVendido, int porcentualComissao) {
        super(nome, sobrenome);
        this.valorVendido = valorVendido;
        this.porcentualComissao = porcentualComissao;
    }

    @Override
    public String toString() {
        return String.format("%s: %s%n\t%s: $ %.2f%n\t%s: %d %%%n\t%s: $ %.2f%n", "Funcionário comissionado", super.toString(), "Valor vendido", this.valorVendido, "Porc. comissão", this.porcentualComissao, "Salário", calcularSalarioMensal());
    }

    @Override
    public double calcularSalarioMensal() {
        return this.porcentualComissao / 100.0 * this.valorVendido;
    }
}