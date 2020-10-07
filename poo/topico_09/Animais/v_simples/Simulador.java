public class Simulador {
	private static final int DURACAO = 60;
	private static final int INTERVALO = 5;

	public static void main(String[] args) {
		System.out.println("Simulador de Animais/n");

		FalcaoPeregrino falcaoPeregrino = new FalcaoPeregrino();
		Guepardo guepardo = new Guepardo();
		PeixeAgulhao peixeAgulhao = new PeixeAgulhao();

		for (int t = INTERVALO; t <= DURACAO; t += INTERVALO) {
			System.out.printf("t = %d%n", t);

			falcaoPeregrino.mover(INTERVALO);
			guepardo.mover(INTERVALO);
			peixeAgulhao.mover(INTERVALO);

			System.out.println();
		}
	}// fim do método main
}// fim da classe Simulador 
