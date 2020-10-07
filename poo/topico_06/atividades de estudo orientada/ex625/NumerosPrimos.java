public class NumerosPrimos {
    public static void main(String[] args) {
        int cont = 0;
        String numerosPrimos = "Números primos menores que 10.000: ";

        for (int i = 1; i < 10000; i++) {
            boolean primo = NumeroPrimo.verificarNumeroPrimo(i);
            if (primo) {
                cont++;
                numerosPrimos += i + ";"; 
            }
        }
        numerosPrimos += "\nTotal de " + cont + " números primos.";

        System.out.println(numerosPrimos);
    }
}
