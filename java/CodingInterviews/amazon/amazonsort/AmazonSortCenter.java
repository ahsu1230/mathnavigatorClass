package amazonsort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AmazonSortCenter {
	/**
	 * In Amazon’s sort center, a computer system decides what packages are to be loaded on what trucks. 
	 * All rooms and spaces are abstracted into space units which is represented as an integer. 
	 * For each type of truck, they have different space units. 
	 * For each package, they will be occupying different space units. 
	 * As a software development engineer in sort centers, you will need to write a method:

		Given truck space units and a list of product space units, 
		find out exactly TWO products that fit into the truck. 
		You will also implement an internal rule that the truck has to reserve exactly 30 space units for safety purposes. 
		Each package is assigned a unique ID, numbered from 0 to N-1.
		
		Assumptions:
		You will pick up exactly 2 packages.
		You cannot pick up one package twice.
		If you have multiple pairs, select the pair with the largest package.
		
		Input:
		The input to the function/method consists of two arguments :
		truckSpace , an integer representing the truck space.
		packagesSpace , a list of integers representing the space units occupying by packages.
		
		Output:
		Return a list of integers representing the IDs of two packages whose combined space will 
		leave exactly 30 space units on the truck.
		
		Example
		Input :
		truckSpace = 90
		packagesSpace = [1, 10, 25, 35, 60]
		Output :
		[2, 3]
		Explanation : Given a truck of 90 space units, a list of packages space units [1, 10, 25, 35, 60], 
		Your method should select the third(ID-2) and fourth(ID-3) package since you have to 
		reserve exactly 30 space units.
	 */
	public static int[] solution(int truckSpace, int[] packageSpace) {
		if (packageSpace == null || packageSpace.length <= 1) return null;
		if (truckSpace <= 30) return null;
		
		Map<Integer, Integer> map = new HashMap<>();
		
		// We need 30 space units for safety
		// We must fulfill exactly 'truckSpace - 30' spaces
		int remainingSpace = truckSpace - 30;
		
		for (int i=0; i < packageSpace.length; i++) {
			int currPackage = packageSpace[i];
			map.put(currPackage, i); // value -> index
		}
		
		int pairIndex1 = -1;
		int pairIndex2 = -1;
		int largestPairBox = 0;
		for (int i=0; i < packageSpace.length; i++) {
			int currPackage = packageSpace[i];
			int remainder = remainingSpace - currPackage;
			if (map.containsKey(remainder) && map.get(remainder) != i) { // pair found!
				if (largestPairBox < Math.max(currPackage, remainder)) {
					pairIndex1 = i;
					pairIndex2 = map.get(remainder);
					largestPairBox = Math.max(currPackage, remainder);
				}
			}
		}
		
		if (pairIndex1 < 0 && pairIndex2 < 0) {
			return null;
		} else {
			int[] result = new int[] {-1, -1};
			result[0] = Math.min(pairIndex1, pairIndex2);
			result[1] = Math.max(pairIndex1, pairIndex2);
			return result;
		}
	}
	
	
	// Just for fun! What if we wanted as many boxes as possible? (Max number)
	// 1 package picked once
	// 30 units reserved for safety purposes
	public static int solution1(int truckSpace, int[] boxes) {
		System.out.println("---");
		if (boxes == null || boxes.length == 0) return -1;
//		if (truckSpace <= 30) return -1;
		int limit = truckSpace + 1;
		
//		int limit = truckSpace - 30;
		
		// A[i][j] represents max weight of boxes that can fit using boxes 0->i, with max size limit j
		int[][] A = new int[boxes.length][limit];
		for (int i = 0; i < boxes.length; i++) {
			for (int j = 0; j < limit; j++) {
				if (j == 0) A[i][j] = 0;
				else if (i == 0 && boxes[i] <= j) A[i][j] = boxes[i];
				else A[i][j] = 0;
			}
		}
		
		// Populate 2D-Array
		for (int j = 1; j < limit; j++) {
			for (int i = 0; i < boxes.length; i++) {
				int size = boxes[i];
				
				if (i > 0) {
					if (j - size >= 0 && A[i-1][j - size] + size <= j) { // is valid
						A[i][j] = Math.max(A[i-1][j], size + A[i-1][j - size]);
					} else { // not valid
						A[i][j] = A[i-1][j];
					}
				}
				System.out.print(A[i][j]+ ", ");
			}
			System.out.println("");
		}
		
		// No need to backtrack if nothing works
		if (A[boxes.length - 1][limit - 1] == 0) {
			return 0;
		}
		
		// Backtrack to count
		// Start at A[boxes.length - 1][limit]
		
		int backtrackI = boxes.length - 1;
		int backtrackJ = limit - 1;
		int cnt = 1;
		while (backtrackI >= 0 && backtrackJ >= 0) {
			int curr = A[backtrackI][backtrackJ];
			int nextI = backtrackI - 1;
			int nextJ = backtrackJ - boxes[backtrackI];
			if (nextI >= 0 && nextJ >= 0 && curr != A[nextI][nextJ]) {	
				backtrackJ = nextJ;
				cnt++;
				System.out.println("*" + backtrackI + "," + backtrackJ + "." + curr);
			}
			backtrackI = backtrackI - 1;
		}
		System.out.println("finish " + backtrackI + "," + backtrackJ);
		
		return cnt;
	}
}
