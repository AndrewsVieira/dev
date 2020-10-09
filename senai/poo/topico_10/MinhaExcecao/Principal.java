public class Principal {
    public static void main(String[] args) {
        Principal principal = new Principal();
        principal.metodo1();
    }

    public void metodo1() {
        try {
            System.out.println("try no metodo1");
            metodo2();
        } catch (Exception exception) {
            System.out.println("catch Exception no metodo1");
            exception.printStackTrace();
        } finally {
            System.out.println("finally no metodo1");
        }
    }

    public void metodo2()throws Exception {
        try {
            System.out.println("try no metodo2");
            metodo3();
        } catch (MinhaExcecao minhaExcecao) {
            System.out.println("catch MinhaExcecao no metodo 2");
            throw new Exception("Relançando MinhaExcecao", minhaExcecao);
        } finally {
            System.out.println("finally no metodo2");
        }
    }

    public void metodo3() throws MinhaExcecao {
        throw new MinhaExcecao("Esta é a minha exceção!");
    }
}
