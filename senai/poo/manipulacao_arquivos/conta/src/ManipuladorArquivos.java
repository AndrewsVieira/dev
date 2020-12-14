import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class ManipuladorArquivos {
	private File arquivo;

	public void abrir(String caminhoArquivo) {
		arquivo = new File(caminhoArquivo);

		if (arquivo.exists()) {
			System.out.println("Arquivo '" + caminhoArquivo + "' já existe!");
			arquivo = null;
		} else if (arquivo.isDirectory()) {
			System.out.println("'" + caminhoArquivo + "' é um diretório!");
			arquivo = null;
		}
	}

	public void escrever(Conta[] contas) {
		if (arquivo != null) {
			Formatter saida = null;

			try {
				saida = new Formatter(arquivo);

				for (Conta conta : contas) {
					saida.format("%s %s %.2f%n", conta.getNome(), conta.getSobrenome(), conta.getSaldo());
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} finally {
				if (saida != null) {
					saida.close();
				}
			}
		} else {
			System.out.println("Nenhum arquivo aberto!");
		}
	}

	public String ler() {
		StringBuffer buffer = new StringBuffer();

		if (arquivo != null) {
			Scanner entrada = null;

			try {
				entrada = new Scanner(arquivo);

				while (entrada.hasNext()) {
					String nome = entrada.next();
					String sobrenome = entrada.next();
					double saldo = entrada.nextDouble();

					Conta conta = new Conta(nome, sobrenome, saldo);

					buffer.append(conta);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} finally {
				if (entrada != null) {
					entrada.close();
				}
			}
		} else {
			System.out.println("Nenhum arquivo aberto!");
		}

		return buffer.toString();
	}
} // fim da classe ManipuladorArquivos
