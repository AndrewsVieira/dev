public class Vendedor {
    private String nome;
    private double totalVendas = 0.0;
    
    public Vendedor (String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setTotalVendas(double venda) {
        this.totalVendas += venda;
    }

    public double getTotalVendas() {
        return this.totalVendas;
    }
    public double getSalario(double salarioBase) {
        double salario = salarioBase;
        double salarioTotal = salario + (this.totalVendas * 0.05);

        return salarioTotal;
    }
}