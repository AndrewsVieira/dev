public class MinhaExcecao extends Exception {
    public MinhaExcecao() {
        super();
    }

    public MinhaExcecao(String menssage){
        super(menssage);
    }

    public MinhaExcecao(Throwable throwable) {
        super(throwable);
    }

    public MinhaExcecao(String menssage, Throwable throwable) {
        super(menssage, throwable);
    }
}
