//TesteHorario.java - classe para demonstrar os serviços da classe Horario
public class TesteHorario {
	public static void main(String[] args) {
		Horario horario1 = new Horario();
		
		System.out.printf("Horario 1 inicial é %s%n", horario1);
		
		System.out.println();

		horario1.setHorario(13,27,6);
		System.out.printf("Horario 1 alterado para: %s%n", horario1);
		
		System.out.println();

		horario1.setHorario(10,10,42);
		System.out.printf("Horario 1 alterado para: %s%n", horario1);
		

	}//fim do método main
	
}//fim da classe
