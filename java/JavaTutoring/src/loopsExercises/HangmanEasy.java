package loopsExercises;

import java.util.Scanner;

public class HangmanEasy {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String secretWord = "banana";
		int guessLimit = 5;
		int numGuesses = 0;
		
		boolean guessed = false;
		while (!guessed && numGuesses < guessLimit) {
			String input = in.next();
			System.out.println("You entered: " + input);
			numGuesses++;
			
			if (secretWord.equals(input)) {
				guessed = true;
			} else {
				System.out.println("Nope!");
				System.out.println("Guesses left: " + (guessLimit - numGuesses));
			}
		}
		
		if (guessed) {
			System.out.println("You guessed correctly!");
		} else {
			System.out.println("You ran out of guesses :(");
		}
		System.out.println("Done");
	}

}
