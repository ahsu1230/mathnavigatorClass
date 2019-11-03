package loopsForArray;

public class MaxMin {
	// create an array of size 10
	// fill each element in array as a random number from 1 to 100.
	// After that, go through array again, 
	// and grab the maximum number in array
	// and grab the minimum number in array
	
	public static void main(String[] args) {
		int[] A = new int[20];
		for (int i=0; i < A.length; i++) {
			A[i] = (int) (Math.random() * 100);
			System.out.print(A[i] + " ");
		}
		System.out.println("");
		
		// Why do you think max and min start at these numbers?
		int max = 0;
		int min = 100;
		for (int i=0; i < A.length; i++) {
			if (A[i] > max) {
				max = A[i];
			}
			if (A[i] < min) {
				min = A[i];
			}
		}
		
		System.out.println("Max: " + max);
		System.out.println("Min: " + min);
	}
}
