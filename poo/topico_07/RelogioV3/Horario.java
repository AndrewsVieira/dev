public class Horario {
	private int segundos;

	public void setHora(int hora) {
		int h = (hora >= 0 && hora <= 23 ? hora : 0);
		this.segundos += (h - getHora()) * 3600;
	}

	public int getHora() {
		return (this.segundos / 3600);
	}

	public void setMinuto(int minuto) {
		int min = (minuto >= 0 && minuto <= 59 ? minuto : 0);
		this.segundos += (min - getMinuto()) * 60;
	}

	public int getMinuto() {
		return (this.segundos % 3600) / 60;
	}

	public void setSegundo(int segundo) {
		int seg = (segundo >= 0 && segundo <= 59 ? segundo : 0);
		this.segundos += seg - getSegundo();
	}

	public int getSegundo() {
		return ((this.segundos % 3600) % 60);
	}

	public void setHorario(int hora, int minuto, int segundo) {
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
