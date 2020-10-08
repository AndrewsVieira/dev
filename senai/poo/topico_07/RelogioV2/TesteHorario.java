// TesteHorario.java - calsse para demonstar os contrutores sobrecarregados da classe Horario.
public class TesteHorario {
	public static void main(String[] args) {
		Relogio relogio1 = new Relogio(14, 13, 58);
		Relogio relogio2 = new Relogio(18, 30, 0);

		relogio1.setHorarioAlarme(16, 0, 0);
		relogio2.setHorarioAlarme(18, 30, 0);

		System.out.println("Verificando o alarme relogio1:");
		relogio1.despertar();

		System.out.println("Verificando o alarme do relogio2:");
		relogio2.despertar();

	}// fim do método main
}//fim da classe
