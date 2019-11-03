package booleans;

import java.util.Scanner;

public class LemonadeStand {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.println("Welcome to your Lemonade Stand Calculator!");
        
        System.out.println("How many lemonades did you sell today?");
        int numLemonades = in.nextInt();
        
        System.out.println("How much $ per lemonade?");
        float costLemonade = in.nextFloat();
        
        System.out.println("How many lemons did you purchase today?");
        int numLemons = in.nextInt();
        
        System.out.println("How much $ per lemon?");
        float costLemon = in.nextFloat();
        
        // For Students to solve on their own!
        float net = numLemonades * costLemonade - numLemons * costLemon;
        System.out.println("Net: " + net);
        
        if (net > 0) {
        	System.out.println("You earned $" + net);
        } else if (net < 0) {
        	System.out.println("You lost $" + net);
        } else {
        	System.out.println("You should've stayed in bed.");
        }
	}

}
