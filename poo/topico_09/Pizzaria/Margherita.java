public class Margherita extends Pizza {

    private static final String[] INGREDIENTES = { "Molho", "Queijo", "Tomate", "Manjericão" };

    private static final int TEMPO = 10;

    public Margherita(String nome, Tamanho tamanho) {
            super(nome, tamanho);
        }

    public void preparar() {
        System.out.printf(  "%n%s %s:%n%s %s%n%s %s%n%s %s%n%s %s%n%n", 
                            "Preparando pizza de", super.getNome(), 
                            "Colocando", INGREDIENTES[0], 
                            "Colocando", INGREDIENTES[1], 
                            "Colocando", INGREDIENTES[2], 
                            "Colocando", INGREDIENTES[3]                );
    }

    public void assar() {
        System.out.printf("Pizza %s assando, isso leva %d minutos.%n%n", super.getNome(), TEMPO);
    }
}
