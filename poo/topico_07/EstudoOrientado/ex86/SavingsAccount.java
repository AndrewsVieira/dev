/*SavingsAccount.java
 * Class that calculates the monthly interest of the saving customers.*/

public class SavingsAccount {
	public static double annualInterestRate = 0.04;
	private double savingsBalance;

	public SavingsAccount(double savingsBalance) {
		this.savingsBalance = (savingsBalance >= 0.0 ? savingsBalance : 0.0);
	
	}

	private void setSavingsBalance(double savingsBalance) {
		this.savingsBalance = savingsBalance;
	}

	// metode calculateMonthlyInterest = (savingBalance * annualInterestRate) / 12
	
	public double calculateMonthlyInterest() {
		return (this.savingsBalance * this.annualInterestRate) / 12;
	}
	public String toString() {
		String stringMonthlyInterest = ""; 
		for (int i = 1; i <= 12; i++) {
			double newAmount = this.savingsBalance + calculateMonthlyInterest();
			setSavingsBalance(newAmount);
			stringMonthlyInterest += (String.format("Balance of the month %d: US$ %.2f.%n", i,this.savingsBalance));  
		}
		return stringMonthlyInterest;
	}

       	// static metode modifyInterestRate --> annualInterestRate with a new value

	public static void modifyInterestRate(double annualInterestRate) {
		SavingsAccount.annualInterestRate = annualInterestRate;
	}

} // end the class
