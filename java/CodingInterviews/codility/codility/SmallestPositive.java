package codility;

import java.util.HashSet;
import java.util.Set;

public class SmallestPositive {
	/**
	 * Given an array of integers (can be negative),
	 * Find smallest positive integer (starting from 1) that is NOT in array
	 * [1,3,6,4,1,2] should return 5
	 * [-1,-3] should return 1
	 * @param A
	 * @return
	 */
	 public int solution(int[] A) {
		 Set<Integer> set = new HashSet<>();
		 for (int i=0; i < A.length; i++) {
			 int num = A[i];
			 set.add(num);
		 }
		 
		 int k = 1;
		 while (true) {
			 if (!set.contains(k)) {
				 break;
			 }
			 k++;
		 }
		 return k;
    }
}
