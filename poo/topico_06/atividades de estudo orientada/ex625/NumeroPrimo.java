// exercício 6.25 - Números primos

public class NumeroPrimo {
    
    public static boolean verificarNumeroPrimo(int numero) {
        int cont = 0;
        boolean primo = false;
        for (int i = 1; i <= numero; i++) {
            if (numero % i == 0) {
                cont++;
            }
        }
        if (cont == 2) {
            primo = true;
        } 
        return primo;
    }
}