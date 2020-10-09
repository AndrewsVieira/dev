public class Calculadora {
    public static int dividir(int numerador, int denominador) throws DivisionByZeroException {
        try {
            return numerador / denominador;        
        } catch (ArithmeticException arithmeticException) {
            throw new DivisionByZeroException();
        }

    }
}