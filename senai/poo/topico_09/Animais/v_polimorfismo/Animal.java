public class Animal {
    private double metrosPercorridos;

    public Animal() {
        this.metrosPercorridos = 0.0;
    }

    public void somaMetrosPercorridos(double metrosPercorridos) {
        this.metrosPercorridos += metrosPercorridos;
    }

    public double getMetrosPercorridos() {
        return this.metrosPercorridos;
    }

    public void mover(int segundos) {}
} // fim da classe Animal