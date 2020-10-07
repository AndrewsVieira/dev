public class FalcaoPeregrino {
	private static final int VELOCIDADE_KMH = 390;
	private double metrosPercorridos;

	public FalcaoPeregrino() {
		metrosPercorridos = 0.0;
	}

	public void mover(int segundos) {
		if (segundos > 0) {
			metrosPercorridos += VELOCIDADE_KMH * 1000 / 3600 * segundos;
			System.out.printf("O falcão peregrino voou %.1f metros.%n", metrosPercorridos);
		}
	}
}// fim da classe FalcaoPeregrino 
