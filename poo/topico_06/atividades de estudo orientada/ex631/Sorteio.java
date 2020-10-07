import java.util.Random;
public class Sorteio {
    public static int sortear() {
        Random random = new Random();
        return random.nextInt(1000) + 1;
    }

    public static String verificarSeSabeOSegredo(int contador){
        String resposta;

        if (contador < 10) {
            resposta = "Você sabe o segredo ou tem muita sorte!";
        } else if (contador == 10) {
            resposta = "Aha! Você sabe o segredo!";
        } else {
            resposta = "Você é capaz de fazer melhor.";
        }

        return resposta;
    }
}