public class Fatorial {
    private int numero;

    public Fatorial(int numero) {
        this.numero = numero;
    }

    public int getFatorial() {
        int fatorial = 1;
        if (this.numero > 0) {
            for (int i = this.numero; i > 0; i--) {
                fatorial *= i;
            }
        }
        return fatorial;
    }
}