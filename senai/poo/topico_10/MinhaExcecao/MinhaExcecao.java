public class MinhaExcecao extends Exception {
    public MinhaExcecao() {
        super();
    }

    public MinhaExcecao(String message){
        super(message);
    }

    public MinhaExcecao(Throwable throwable) {
        super(throwable);
    }

    public MinhaExcecao(String message, Throwable throwable) {
        super(message, throwable);
    }
}