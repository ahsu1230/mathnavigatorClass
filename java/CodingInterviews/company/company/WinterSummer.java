package company;

// Codility from UnitedIncome
// Given an integer array [...]
// Index 0 to k is "winter time"
// Index k to end is "summer time"

public class WinterSummer {
	public static int solution(int[] T) {
		if (T == null) return 0;
		if (T.length == 0) return 0;
		if (T.length == 1) return 1;
		
		int i = 0;
		int indexLocalMax = 0;
		int localMax = T[0];
		
		// find a local max
		while(i < T.length && T[i] >= localMax) {
			localMax = T[i];
			i++;
		}
		
		// no "local max" so winter is only length 1, rest is summer
		if (i >= T.length && localMax > T[0]) {
			return 1; 
		}
		
		// find next number greater than local max
		while (i < T.length && T[i] <= localMax) {
			i++;
		}
		indexLocalMax = i;
		
		return indexLocalMax;
	}
}
