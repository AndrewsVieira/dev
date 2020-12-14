
public class Programa {

	public static void main(String[] args) {
		Conta[] contas = new Conta[3];

		contas[0] = new Conta("Alan", "Turing", 1234.56);
		contas[1] = new Conta("Donald", "Knuth", 987.65);
		contas[2] = new Conta("Linus", "Torvalds", 49.58);

		ManipuladorArquivos manipuladorArquivos = new ManipuladorArquivos();
		manipuladorArquivos.abrir("/tmp/contas.serial");

		manipuladorArquivos.escrever(contas);

		String contasLidas = manipuladorArquivos.ler();
		System.out.printf("Contas Lidas do Arquivo ----------------------%n%s", contasLidas);

		System.out.println("Terminei!");
	}

} // fim da classe Programa
