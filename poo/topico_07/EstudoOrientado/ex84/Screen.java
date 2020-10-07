// Screen.java - class that test the rectangle class.

import java.util.Scanner;
public class Screen {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("type the rectangle length: ");
		double length = scanner.nextDouble();
		System.out.print("type the rectangle width: ");
		double width = scanner.nextDouble();

		Rectangle rectangle = new Rectangle(length, width);

		System.out.printf("The rectangle area is: %.1f.%nThe rectangle perimeter is: %.1f.%n", rectangle.getArea(), rectangle.getPerimeter());

		// test of the simple construnctor
		

		Rectangle rectangle1 = new Rectangle();

		System.out.printf("The simple rectangle area is: %.1f.%nThe simple rectangle perimeter is: %.1f.%n", rectangle1.getArea(), rectangle1.getPerimeter());	
	
	}// end the main metode

}// end the class
