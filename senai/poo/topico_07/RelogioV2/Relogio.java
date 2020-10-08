// Relogio.java - classe que implementa um relógio com função alarme.
public class Relogio {
	public Horario horarioAtual;
	public Horario horarioAlarme;

	public Relogio(int hora, int minuto, int segundo) {
		horarioAtual = new Horario(hora, minuto, segundo);
	}

	public String getHorarioAtual() {
		return horarioAtual.toString();
	}

	public void setHorarioAlarme(int hora, int minuto, int segundo) {
		horarioAlarme = new Horario(hora, minuto, segundo);
	}

	public String getHorarioAlarme() {
		return horarioAlarme.toString();
	}

	public void despertar() {
		if (horarioAtual.equals(horarioAlarme)) {
			System.out.println("ALARME TOCANDO!!");
		} else {
			System.out.println("Ainda não está na hora...");
		}
	}

}//fim da classe
