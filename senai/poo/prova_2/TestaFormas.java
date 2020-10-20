public class TestaFormas {
    public static void main(String[] args) {
        Forma[] formas = new Forma[3];

        // criando um círculo
        double raio = 7.5;
        formas[0] = new Circulo(raio);
        // criando um quadrado
        double lado = 17;
        formas[1] = new Quadrado(lado);
        // criando um triângulo
        double base = 9.7;
        double altura = 12.3;
        formas[2] = new Triangulo(base, altura);

        for (Forma forma : formas) {
            System.out.printf("Área do %s: %.2f%n", 
                              forma.getClass().getName(),
                              forma.calcularArea());
        }
    }
} // fim da classe TestaFormas
