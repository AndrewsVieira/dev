
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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
			ObjectOutputStream os = null;

			try {
				os = new ObjectOutputStream(new FileOutputStream(arquivo));

				for (Conta conta : contas) {
					os.writeObject(conta);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (os != null) {
					try {
						os.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		} else {
			System.out.println("Nenhum arquivo aberto!");
		}
	}

	public String ler() {
		StringBuffer buffer = new StringBuffer();

		if (arquivo != null) {
			ObjectInputStream is = null;

			try {
				is = new ObjectInputStream(new FileInputStream(arquivo));

				while (true) {
					Conta conta = (Conta) is.readObject();
					
					buffer.append(conta);
				}
			} catch (EOFException e) {
				// lançado quando chegar no final do arquivo
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Nenhum arquivo aberto!");
		}

		return buffer.toString();
	}
} // fim da classe ManipuladorArquivos
