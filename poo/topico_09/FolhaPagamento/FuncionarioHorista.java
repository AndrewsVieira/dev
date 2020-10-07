public class FuncionarioHorista extends Funcionario {
    public int horasTrabalhadas;
    public double valorPorHora;

    public FuncionarioHorista(String nome, String sobrenome, int horasTrabalhadas, double valorPorHora) {
        super(nome, sobrenome);

        this.horasTrabalhadas = horasTrabalhadas;
        this.valorPorHora = valorPorHora;
    }

    @Override
    public String toString() {
        return String.format("%s: %s%n\t%s: %d%n\t%s: $ %.2f%n\t%s: $ %.2f%n", "Funcionário horista", super.toString(), "Horas trabalhadas", this.horasTrabalhadas, "Valor por hora", this.valorPorHora, "Salário", calcularSalarioMensal());
    }

    @Override
    public double calcularSalarioMensal() {
        return this.valorPorHora * this.horasTrabalhadas;
    }
}
