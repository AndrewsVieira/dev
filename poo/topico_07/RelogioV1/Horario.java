//Horario.java - classe que representa um horário com hora, minuto e segundo.
public class Horario {
	private int hora;// 0-23
	private int minuto;// 0-59
	private int segundo;// 0-59

	public void setHora(int hora) {
		this.hora = (hora >= 0 && hora <= 23 ? hora : 0);
	}

	public int getHora() {
		return this.hora;
	}

	public void setMinuto(int minuto) {
		this.minuto = (minuto >= 0 && minuto <= 59 ? minuto : 0);
	}

	public int getMinuto() {
		return this.minuto;
	}

	public void setSegundo(int segundo) {
		this.segundo = (segundo >= 0 && segundo <= 59 ? segundo : 0);
	}

	public int getSegundo() {
		return this.segundo;
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
		
}//fim da classe 
