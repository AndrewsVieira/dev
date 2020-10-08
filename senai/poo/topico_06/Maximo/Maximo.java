// programa que encontra o valor máximo de uma lista de ints ou doubles.

public class Maximo {
    public static void main(String[] args) {
        if (args.length == 1) {
            int exemplo = Integer.parseInt(args[0]);

            switch (exemplo) {
                case 1:
                    System.out.printf("Máximo é: %d%n", max(7, 9));
                    break;
                case 2:
                    System.out.printf("Máximo é: %d%n", max(-1234, 12, 23, 9908293, -9908293));
                    break;
                case 3:
                    System.out.printf("Máximo é %f%n", max(2.9, 6.5));
                    break;
                case 4:
                    System.out.printf("Máximo é: %f%n", max(94.2, 76.588, 33.46, -982, 12345.67));
                    break;
                default:
                    System.out.println("Número de exemplo inválido! Abortando.");
            }// fim do switch
        } else {
            System.out.println("Número de exemplo não informado! Abortando.");
        }// fim do if
    }// fim do método main

    public static int max(int... numeros) {
        int max = Integer.MIN_VALUE;

        for (int num: numeros) {
            if (num > max) {
                max = num;
            }
        }

        return max;
    }// fim do método max de doubles.

    public static double max(double... numeros) {
        double max = Double.MIN_VALUE;

        for(double num: numeros) {
            if (num > max) {
                max = num;
            }
        }

        return max;
    }// fim do método max de doubles
}// fim da classe Maximo.