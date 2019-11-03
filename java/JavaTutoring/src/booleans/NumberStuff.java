package booleans;

public class NumberStuff {

	public static void main(String[] args) {
		int num1 = 45;
		int num2 = 30;
		int num3 = 40;
		
		if (num1 % 2 == 0) {
			System.out.println("Number is even!");
		} else { // num1 % 2 == 1
			System.out.println("Number is odd!");
		}
		
		if (num1 % 3 == 0) {
			System.out.println("Number is divisible by 3!");
		} else { // num1 % 2 == 1
			System.out.println("Number is NOT divisible by 3!");
		}
		
		if (num1 % 3 == 0 || num1 % 5 == 0) {
			System.out.println("Number is divisible by 3 OR divisible by 5!");
		}
		
		if (num1 % 3 == 0 && num1 % 5 == 0) {
			System.out.println("Number is divisible by 3 AND divisible by 5!");
		}
		
		if (num1 > 0) {
			System.out.println("Number is positive!");
		} else if (num1 < 0) {
			System.out.println("Number is negative!");
		} else { // num1 == 0
			System.out.println("Number is zero!");
		}
		
		if (num1 >= num2 && num1 >= num3) {
			System.out.println("The largest number is: " + num1);
		} else if (num2 >= num1 && num2 >= num3) {
			System.out.println("The largest number is: " + num2);
		} else if (num3 >= num1 && num3 >= num2) {
			System.out.println("The largest number is: " + num3);
		}
		
		if (num1 <= num2 && num1 <= num3) {
			System.out.println("The smallest number is: " + num1);
		} else if (num2 <= num1 && num2 <= num3) {
			System.out.println("The smallest number is: " + num2);
		} else if (num3 <= num1 && num3 <= num2) {
			System.out.println("The smallest number is: " + num3);
		}

	}

}
