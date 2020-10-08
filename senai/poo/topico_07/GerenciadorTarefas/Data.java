//Data.java - classe que estrutura uma data
public class Data {

	private int dia;
	private Mes mes;
	private int ano;

	private boolean bissexto;

	public Data(int dia, Mes mes, int ano) {
		this.ano = ano;

		bissexto = (this.ano % 400 == 0 || (this.ano % 4 == 0 && this.ano % 100 != 0));

		this.mes = mes;

		if (dia == 29 && this.mes == Mes.FEVEREIRO && bissexto) {
			this.dia = dia;
		} else {
			this.dia = (dia > 0 && dia <= mes.getQuantidadeDia() ? dia : 0);
		}
	}

	public void setDia(int dia) {
		this.dia = (dia > 0 && dia <= mes.getQuantidadeDia() ? dia : 0);
	}

	public int getDia() {
		return this.dia;
	}

	public void setMes(Mes mes) {
		this.mes = mes;
	}

	public Mes getMes() {
		return this.mes;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getAno() {
		return this.ano;
	}

	public String toString() {
		return String.format("%02d/%02d/%02d", getDia(), getMes().getMes(), getAno());
	}

}
