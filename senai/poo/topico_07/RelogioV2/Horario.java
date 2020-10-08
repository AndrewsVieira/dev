//Horario.java - classe que representa um horário com o número de segundos depois da meia-noite.
public class Horario {
	private int segundos;// numero de segundos depois da meia-noite.

	public Horario() {
		this(0,0,0);
	}

	public Horario(int hora) {
		this(hora,0,0);	
	}

	public Horario (int hora, int minuto) {
		this(hora,minuto,0);
	}

	public Horario(int hora, int minuto, int segundo) {
		setHorario(hora,minuto,segundo);
	}

	public Horario(Horario horario) {
		setHorario(	horario.getHora(),
				horario.getMinuto(),
				horario.getSegundo());
	}

	// Soma a diferença entre a hora armazenada e a nova hora ao número de segundos.

	public void setHora(int hora) {
		int h = (hora >= 0 && hora <= 23 ? hora : 0);
		this.segundos += (h - getHora()) * 3600;
	}

	//Obtem o número de horas completas fazendo a divisão inteira do número de segundos por 3600, que corresponde ao número de segundos em uma hora(60 minutos * 60 segundos).

	public int getHora() {
		return segundos / 3600;
	}

	public void setMinuto(int minuto) {
		int m = (minuto >= 0 && minuto <= 59 ? minuto : 0);
		this.segundos += (m - getMinuto()) * 60;
	}

	//Obtem o número de minutos completos extraindo o número de horas completas (resto da divisão) e fazendo a divisão por 60.

	public int getMinuto() {
		return (segundos % 3600) / 60;
	}

	public void setSegundo(int segundo) {
		int s = (segundo >= 0 && segundo <= 59 ? segundo : 0);
		this.segundos += (s - getSegundo());
	}

	//Obtem o número de segundos completos extraindo o número de horas e minutos completos (resto da divisão).

	public int getSegundo() {
		return (segundos % 3600) % 60;
	}

	public void setHorario(int hora, int minuto, int segundo) {
		// perguntar para o professor se o this. aqui não é necessário.
		setHora(hora);
		setMinuto(minuto);
		setSegundo(segundo);
	}

	public String toString() {
		return String.format(	"%02d:%02d:%02d",
					getHora(),
					getMinuto(),
					getSegundo()	);
	}

	public boolean equals(Object obj) {
		//verifica se tem a mesma referência.
		if (this == obj) { return true; }

		//verifica se é nulo.
		if (obj == null) { return false; }

		//verifica se tem o mesmo tipo.
		if (getClass() != obj.getClass()) { return false; }

		//verifica se tem o mesmo número de segundos.
		Horario horario = (Horario) obj;
		return this.segundos == horario.segundos;
	}
		
}//fim da classe 
