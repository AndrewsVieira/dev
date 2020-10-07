/**
 * VendedorComissionado é uma classe que representa um vendedor de uma loja que
 * recebe o salário base mais uma comissão correspondente a um percentual do
 * total de vendas do mês.
 */

public class VendedorComissionado extends Vendedor {
    private int porcentualComissao;

    /**
     * Construtor que inicializa o nome, sobrenome, salário base e o porcentual de
     * comissão.
     */

    public VendedorComissionado(String nome, String sobrenome, double salarioBase, int porcentualComissao) {
        // chama o construtor da superclasse.
        super(nome, sobrenome, salarioBase);

        this.porcentualComissao = (porcentualComissao > 0 ? porcentualComissao : 0);
    }

    public int getPorcentualComissao() {
        return this.porcentualComissao;
    }

    @Override
    public double getSalario() {
        return getSalarioBase() + this.porcentualComissao / 100.0 * getValorVendidoMes();
    }

    @Override
    public String toString() {
        return String.format("%s: %s %s%n\t%s: $ %.2f%n\t%s: %d%%%n\t%s: $ %.2f%n\t%s: $ %.2f", "Vendedor", getNome(),
                getSobrenome(), "Salário Base", getSalarioBase(), "Comissão", this.getPorcentualComissao(),
                "Vendas no mês", getValorVendidoMes(), "Salário", getSalario());
    }
}// fim da classe
