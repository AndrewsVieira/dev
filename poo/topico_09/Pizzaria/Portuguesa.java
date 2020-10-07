public class Portuguesa extends Pizza{
    private static final String[] INGREDIENTES = { 
        "Molho", 
        "Queijo", 
        "Presunto", 
        "Tomate", 
        "Ovo", 
        "Cebola" 
    };

    private static final int TEMPO = 13;

    public Portuguesa(String nome, Tamanho tamanho) {
            super(nome, tamanho);
        }

    public void preparar() {
        System.out.printf(  "%n%s %s:%n%s %s%n%s %s%n%s %s%n%s %s%n%s %s%n%s %s%n%n", 
                            "Preparando pizza de", super.getNome(), 
                            "Colocando", INGREDIENTES[0], 
                            "Colocando", INGREDIENTES[1], 
                            "Colocando", INGREDIENTES[2], 
                            "Colocando", INGREDIENTES[3],
                            "Colocando", INGREDIENTES[4],
                            "Colocando", INGREDIENTES[5]                );
    }

    public void assar() {
        System.out.printf("Pizza %s assando, isso leva %d minutos.%n%n", super.getNome(), TEMPO);
    }
}
