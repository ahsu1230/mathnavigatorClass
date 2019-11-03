package sameFaceDice;

import java.util.ArrayList;
import java.util.List;

public class SameFaceDice {
	/**
	 * A six-sided dice is a small cube with a different number of pips. Each face(side) ranging from 1 to 6.
		On any two opposite side of the cube, the number of pips adds up to 7; that is, there are three pairs of opposite sides: 1 and 6, 2 and 5, and 3 and 4.
		There are N dice lying on a table, each showing the pips on its top face. In one move, you can take one dice and rotate it to an adjacent face.
		For example, you can rotate a dice that shows 1 to show 2, 3, 4 or 5. However, it cannot show 6 in a single move, because the faces with one pip and six pips visible are opposite sides rather than adjacent.
		You want to show the same number of pips on the top face of all N dice. Given that each of the dice can be moved multiple times, count the minimum number of moves needed to get equal faces.
		
		Write a function:
		that, given an array A consisting of N integers describing the number of pips (from 1 to 6) shown on each dice’s top face, returns the minimum number of moves necessary for each dice show the same number of pips.
		
		For example, given:
		• A = [1, 2, 3], the function should return 2, as you can pick the first two dice and rotate each of them in one move so that they all show three pips on the top face. Notice that you can also pick any other pair of dice in this case.
		• A = [1, 1, 6], the function should also return 2. The only optimal answer is to rotate the last dice so that it shows one pip. It is necessary to use two rotations to achieve this.
		• A = [1, 6, 2, 3], the function should return 3. For instance, you can make all dice show 2: just rotate each dice which is not showing 2 (and notice that for each dice you can do this in one move).
		
		Assume that:
		• N is an integer within the range [1…100];
		• each element of the array A is an integer within the range [1…6].
		
		*** Approach:
		* create a 2D array C that is 6x6. Cij = cost of turning a dice from i to j
		* For every face (6), and for every dice, what is total cost to turn every dice to face
		* Use a global minimum to keep track of (num moves, dice face)
		* Complexity Time O(6n) = O(n)
		* Complexity Space O(1)
	 */
	public static int solution(int[] dices) {
		if (dices == null || dices.length == 0) return -1;
		
		int[][] cost = createCosts(6);
		
		int minNumMoves = Integer.MAX_VALUE;
		int numMoves = 0;
		int minFace = 0;
		
		for (int i = 1; i <= 6; i++) {
			for (int j = 0; j < dices.length; j++) {
				int face = dices[j];
				numMoves += cost[face][i];
			}
			if (numMoves < minNumMoves) {
				minNumMoves = numMoves;
				minFace = i;
			}
			numMoves = 0;
		}
		
		return minNumMoves;
	}
	
	private static int[][] createCosts(int numFaces) {
		int size = numFaces + 1;
		int[][] array = new int[size][size];
		
		for (int i=0; i < size; i++) {
			for (int j=0; j < size; j++) {
				if (i == 0 || j == 0)
					array[i][j] = -1;
				else if (i == j) 
					array[i][j] = 0;
				else if (i == size - j) 
					array[i][j] = 2;
				else 
					array[i][j] = 1;
			}
		}
		
		return array;
	}
}
