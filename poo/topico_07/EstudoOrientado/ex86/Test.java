public class Test {
	public static void main(String[] args) {
		SavingsAccount saver1 = new SavingsAccount(2000.00);
		SavingsAccount saver2 = new SavingsAccount(3000.00);

		System.out.printf("Saver 1 %n%s%n", saver1.toString());

		System.out.printf("Saver 2 %n%s%n", saver2.toString());

		SavingsAccount.modifyInterestRate(0.5);

		System.out.printf("Saver 1 %n%s%n", saver1.toString());

                System.out.printf("Saver 2 %n%s%n", saver2.toString());



	}// end the main metode	
}// end the class
