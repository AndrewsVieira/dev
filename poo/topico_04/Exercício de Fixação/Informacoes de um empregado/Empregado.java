public class Empregado {
	private String nome;
	private String sobrenome;
	private double salario;

	public Empregado(String nome, String sobrenome, double salario) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		if (salario > 0.0) {
			this.salario = salario;
		}
	}

	public void setNome(String nome){
		this.nome = nome;
	}
	public String getNome(){
		return this.nome;
	}

	public void setSobrenome(String sobrenome){
		this.sobrenome = sobrenome;
	}
	public String getSobrenome(){
		return this.sobrenome;
	}

	public void setSalario(double salario){
		this.salario = salario;
	}

	public double getSalario(){
		return this.salario;
	}

	public void darAumento(float percentual){
		this.salario = this.salario*(1 + (percentual/100));
	}
	public double getSalarioAnual(){
		return this.salario*12;
	}
}
