public class CalcularPi {
    public static void main(String[] args) {
        double pi = 0.0;
        boolean proximoPi = pi >= 3.14159;
        double cont = 1;
        double CONST = 4;

        while (!proximoPi) {  
                   
            pi += (CONST / cont) - (CONST / (cont + 2));
            if (cont == 100) {
                System.out.print(".");
            }
            cont += 2;
            proximoPi = pi >= 3.14159; 
        }
        System.out.printf("%n%.5f%n%n", pi);
    }
}