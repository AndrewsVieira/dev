//TesteHorario.java - classe para demonstrar os serviços da classe Horario
public class TesteHorario {
	public static void main(String[] args) {
		Horario horario1 = new Horario();
		Horario horario2 = new Horario();

		System.out.printf("Horario 1 inicial é %s%n", horario1);
		System.out.printf("Horario 2 inicial é %s%n", horario2);

		System.out.println();

		horario1.setHorario(13,27,6);
		System.out.printf("Horario 1 alterado para %s%n", horario1);
		System.out.printf("Horario 2 permanece: %s%n", horario2);

		System.out.println();

		horario2.setHorario(99,99,99);
		System.out.printf("Horario 1 permanece: %s%n", horario1);
		System.out.printf("Horario 2 alterado para: %s%n", horario2);

	}//fim do método main
	
}//fim da classe
