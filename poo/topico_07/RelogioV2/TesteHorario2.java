/*TesteHorario2.java
 * classe que demonstra a sobrecarga dos contrutores da classe horario*/
public class TesteHorario2 {
	public static void main(String[] args){
		Horario h1 = new Horario();
		Horario h2 = new Horario(2);
		Horario h3 = new Horario(21, 34);
		Horario h4 = new Horario(12, 25, 42);
		Horario h5 = new Horario(30, 77, 99);
		Horario h6 = new Horario(h4);

		System.out.printf("Com construtor padrão: %s%n", h1);
		System.out.printf("Construtor com 1 int: %s%n", h2);
		System.out.printf("Construtor com 2 ints: %s%n", h3);
		System.out.printf("Construtor cocm 3 ints: %s%n", h4);
		System.out.printf("Passando valores inconsistentes: %s%n", h5);
		System.out.printf("Construtor com 1 objeto: %s%n", h6);
	}

}
