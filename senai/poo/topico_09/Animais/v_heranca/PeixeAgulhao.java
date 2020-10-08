public class PeixeAgulhao extends Animal {
        private static final int VELOCIDADE_KMH = 115;

        public void mover(int segundos) {
                if (segundos > 0) {
                        somaMetrosPercorridos(VELOCIDADE_KMH * 1000 / 3600 * segundos);
                        System.out.printf("O peixe-agulhão nadou %.1f metros.%n", getMetrosPercorridos());
                }
        }
}// fim da classe PeixeAgulhao
