package loopsWhile;

public class Warmup {
	public static void main(String args[]) {
		int num1 = 45;
		int num2 = 3;
		
		int sum = num1;
		int count = 0;
		while (count < num2) {
			sum++;
			count++;
		}
		System.out.println("The sum is " + sum);
		
		int diff = num1;
		count = 0;
		while (count < num2) {
			diff--;
			count++;
		}
		System.out.println("The diff is " + diff);
	}
}
