package booleans;

public class Grader {
	public static void main(String[] args) {
        float score1 = 95.5f;
        float score2 = 95.5f;
        float score3 = 95.5f;
        float score4 = 95.5f;
        float score5 = 95.5f;
		float average = (score1 + score2 + score3 + score4 + score5) / 5;
		
        if (average >= 90) {
        	System.out.println("You got an A!");
        } else if (average >= 80) {
        	System.out.println("You got an B!");
        } else if (average >= 70) {
        	System.out.println("You got an C!");
        } else if (average >= 60) {
        	System.out.println("You got a D!");
        } else {
        	System.out.println("Let's not talk about it...");
        }
	}
}
