public abstract class Funcionario implements Pagavel{
    private String nome;
    private String sobrenome;

    public Funcionario(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.nome, this.sobrenome);
    }

    public abstract double calcularSalarioMensal();

    @Override
    public double obterValorPagar() {
    	return calcularSalarioMensal();
    }
}
