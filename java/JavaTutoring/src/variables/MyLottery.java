package variables;

public class MyLottery {
	
	public static void main(String[] args) {
		int num1 = (int)(Math.random() * 100);
		int num2 = (int)(Math.random() * 100);
		int num3 = (int)(Math.random() * 100);
		int num4 = (int)(Math.random() * 100);
		int num5 = (int)(Math.random() * 100);
		
		String ticket = "The winning lottery ticket is: ";
		ticket += num1 + " ";
		ticket += num2 + " ";
		ticket += num3 + " ";
		ticket += num4 + " ";
		ticket += num5;
		
		System.out.println(ticket);
	}
}
