package loopsForArray;

public class ForWhat {
	public static void main(String[] args) {
		// basic for loop practicing
		int[] array = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		int sum = 0;
		int product = 1;
		int cntEven = 0;
		for (int i=0; i < array.length; i++) {
			sum += array[i];
			product *= array[i];
			if (array[i] % 2 == 0) {
				cntEven++;
			}
		}
		System.out.println("Total sum is: " + sum);
		System.out.println("Total product is: " + product);
		System.out.println("Count of evens: " + cntEven);
		
		// Double every number in array!
		for (int i=0; i < array.length; i++) {
			int original = array[i];
			array[i] = original * 2;
			System.out.print(array[i] + " ");
		}
		System.out.println("");
		
		// Is 6 in the array?
		// Is 11 in the array?
		boolean has6 = false;
		boolean has11 = false;
		for (int i=0; i < array.length; i++) {
			if (array[i] == 6) has6 = true;
			if (array[i] == 11) has11 = true;
		}
		if (has6) {
			System.out.println("Array contains 6");
		} else {
			System.out.println("Array does not contain 6");
		}
		
		if (has11) {
			System.out.println("Array contains 11");
		} else {
			System.out.println("Array does not contain 11");
		}
		
		// Now "delete" everything in the array
		// by setting everything back to 0
		for (int i=0; i < array.length; i++) {
			array[i] = 0;
			System.out.print(array[i] + " ");
		}
		System.out.println("");
	}
}
