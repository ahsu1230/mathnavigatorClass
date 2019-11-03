package loopsExercises;

import java.util.Scanner;

public class GuessMyNumber {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int secretNumber = 43;
		
		boolean stillGuessing = true;
		while (stillGuessing) {
			int input = in.nextInt();
			System.out.println("You entered: " + input);
			
			if (input > secretNumber) {
				System.out.println("Too high!");
			} else if (input < secretNumber) {
				System.out.println("Too low!");
			} else {
				System.out.println("You got it!");
				stillGuessing = false;
			}
		}
		System.out.println("Done");
	}

}
