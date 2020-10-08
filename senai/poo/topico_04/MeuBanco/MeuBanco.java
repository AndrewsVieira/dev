import java.util.Scanner;

public class MeuBanco {
    public static void main(String[] args) {
	Scanner scanner =  new Scanner(System.in);

	System.out.print("Informe o nome do primeiro cliente: ");
	String nome1 = scanner.nextLine();
	System.out.print("Informe o saldo inicial do primeiro cliente: ");
	double saldo1 = scanner.nextDouble();
	Conta conta1 = new Conta(nome1, saldo1);

	scanner.nextLine();

	System.out.print("Informe o nome do segundo cliente: ");
	String nome2 = scanner.nextLine();
	System.out.print("Informe o saldo inicial do segundo cliente: ");
	double saldo2 = scanner.nextDouble();
	Conta conta2 = new Conta(nome2, saldo2);

	System.out.printf("%nConta1: Nome = %s, Saldo = $ %.2f%n", conta1.getNome(), conta1.getSaldo());
	System.out.printf("%nConta2: Nome = %s, Saldo = $ %.2f%n%n", conta2.getNome(), conta2.getSaldo());

	System.out.print("Informe o valor do depósito na conta1: ");
	double valor1 = scanner.nextDouble();
	conta1.depositar(valor1);
	System.out.printf("%nNovo saldo conta1: $ %.2f%n%n", conta1.getSaldo());

	System.out.print("Informe o valor do saque na conta2: ");
	double valor2 = scanner.nextDouble();
	conta2.sacar(valor2);
	System.out.printf("%nNovo saldo conta2: $ %.2f%n%n", conta2.getSaldo());
    }
}
