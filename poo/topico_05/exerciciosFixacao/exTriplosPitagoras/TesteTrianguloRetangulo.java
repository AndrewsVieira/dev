public class TesteTrianguloRetangulo {
    public static void main(String[] args) {
        String tabelaTrianguloRetangulo = "lado1\tlado2\thipotenusa\n";
        int cont = 0;

        for (int i = 1; i <= 500; i++) {
            for (int j = 1; j <= 500; j++) {
                for (int k = 1; k < 500; k++) {
                    TrianguloRetangulo trianguloRetangulo = new TrianguloRetangulo(i, j, k);
                    
                    if(trianguloRetangulo.verificarTrianguloRetangulo()) {
                        tabelaTrianguloRetangulo += trianguloRetangulo.getLado1() + "\t" + trianguloRetangulo.getLado2() + "\t" + trianguloRetangulo.getHipotenusa() + "\n";
                        cont++;
                    }

                }
            }
        }

        System.out.println(tabelaTrianguloRetangulo);
        System.out.printf("São %d trinagulos retângulos", cont);
    }
}