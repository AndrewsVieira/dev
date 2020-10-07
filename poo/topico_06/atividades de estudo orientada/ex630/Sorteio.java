import java.util.Random;
public class Sorteio {
    public static int sortear() {
        Random random = new Random();
        return random.nextInt(1000) + 1;
    }
}