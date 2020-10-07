import java.util.Scanner;
import java.util.Random;

public class Clerk {
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static void wellcome() {
        System.out.println("Seja bem-vindo(a)!");
    }

    public static void createPassage() {
        System.out.println("Digite 1 para First Class ou 2 para Economy Class: ");
        int numClass = scanner.nextInt();
        int numSeat = 0;

        if (numClass == 1){
            numSeat = random.nextInt(5);
        } else if(numClass == 2){
            numSeat = random.nextInt(5) + 5;
        } else {
            System.out.println("Número inválido.");
        }
        
        if (numClass == 1 || numClass == 2) {
            Passenger newPass = new Passenger(numSeat, numClass);
            System.out.println(newPass.getBoardingPass());
        }
    }


}
