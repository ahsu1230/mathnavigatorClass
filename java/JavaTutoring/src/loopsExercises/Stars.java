package loopsExercises;

public class Stars {

	public static void main(String[] args) {
		// Create this pattern
		// *
		// **
		// ***
		// ****
		// *****
		// ****
		// ***
		// **
		// *
		String stars = "";
		
		for (int i=0; i < 5; i++) {
			stars = stars.concat("*");
			System.out.println(stars);
		}
		
		for (int i=0; i < 5; i++) {
			stars = stars.substring(0, stars.length() - 1);
			System.out.println(stars);
		}
	}

}
