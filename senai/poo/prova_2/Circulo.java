public class Circulo extends Forma {
    private double raio;
    public Circulo(double raio) {
        super();
        this.raio = raio;
    }

    @Override
    public double calcularArea() {
        return 3.14 * this.raio * this.raio;
    }
}
