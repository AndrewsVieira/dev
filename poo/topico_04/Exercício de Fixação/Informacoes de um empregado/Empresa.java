import java.util.Scanner;

public class Empresa {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Bem-vindo a Empresa.");
		System.out.print("Digite o nome do primeiro empregado: ");
		String nome1 = scanner.nextLine();
		System.out.print("Digite o sobrenome do primeiro empregado: ");
		String sobrenome1 = scanner.nextLine();
		System.out.print("Digite o salário do primeiro empregado: ");
		double salario1 = scanner.nextDouble();

		Empregado empregado1 = new Empregado(nome1, sobrenome1, salario1);

		System.out.printf("Empregado %s %s; Salário R$%.2f e salário anual R$%.2f%n%n", empregado1.getNome(), empregado1.getSobrenome(), empregado1.getSalario(), empregado1.getSalarioAnual());

		scanner.nextLine();

		System.out.print("Digite o nome do segundo empregado: ");
		String nome2 = scanner.nextLine();
		System.out.print("Digite o sobrenome do segundo empregado: ");
		String sobrenome2 = scanner.nextLine();
		System.out.print("Digite o salário do segundo empregado: ");
		double salario2 = scanner.nextDouble();

		Empregado empregado2 = new Empregado(nome2, sobrenome2, salario2);
		System.out.printf("Empregado %s %s; Salário R$%.2f e salário anual R$%.2f%n%n", empregado2.getNome(), empregado2.getSobrenome(), empregado2.getSalario(), empregado2.getSalarioAnual());

		System.out.print("Digite o percentual (sem o %) de aumento do empregado 1: ");
		float aumento1 = scanner.nextFloat();
		empregado1.darAumento(aumento1);

		System.out.printf("Empregado %s %s; Salário R$%.2f e salário anual R$%.2f%n%n", empregado1.getNome(), empregado1.getSobrenome(), empregado1.getSalario(), empregado1.getSalarioAnual());
	}
}