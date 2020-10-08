//Mes.java - enumerador de MESes do ano
public enum Mes {
	JANEIRO(1), FEVEREIRO(2), MARCO(3), ABRIL(4), MAIO(5), JUNHO(6), JULHO(7), AGOSTO(8), SETEMBRO(9), OUTUBRO(10),
	NOVEMBRO(11), DEZEMBRO(12);

	private final int mes;
	private int quantidadeDia;

	private Mes(int mes) {
		this.mes = mes;
		switch (mes) {
			case 2:
				this.quantidadeDia = 28;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				this.quantidadeDia = 30;
				break;
			default:
				this.quantidadeDia = 31;
		}
	}

	public int getMes() {
		return this.mes;
	}

	public  int getQuantidadeDia() {
		return this.quantidadeDia;
	}

}
