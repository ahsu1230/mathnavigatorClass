package loopsWhile;

public class MathyStuff {
	public static void main(String args[]) {
//		int i = 1;
//		int sum = 0;
//		int product = 1;
//		
//		while (i <= 5) {
//			System.out.println("Sequence: " + i);
//			sum += i;
//			product *= i;
//			i++;
//		}
//		
//		System.out.println("Total sum is: " + sum);
//		System.out.println("Total product is: " + product);
//		
//		i = 1;
//		while (i <= 10) {
//			int num = i * 5;
//			System.out.println("Sequence: " + num);
//			if (num % 2 == 1) {
//				System.out.println("Odd!");
//			}
//			if (num % 7 == 0) {
//				System.out.println("%7");
//			}
//			i++;
//		}
		int sum = 0;
		int i = 0;
		int product = 0;
		product = 1;
		i = 1;
		
		while(i < 5) {
			//System.out.println("1. i="+i);
			i++;
			//System.out.println("2. i="+i);
			product = product * i;
			//System.out.println("3. product="+product);
			
		}
		System.out.println("the product is " + product);
	}

}
