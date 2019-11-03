package loopsExercises;

public class StringCopy {

	public static void main(String[] args) {
		String string1 = "asdfq";
		System.out.println("String1: " + string1);
		
		// Copy string1 into string2
		String string2 = "";
		for (int i=0; i < string1.length(); i++) {
			char c = string1.charAt(i);
			string2 += c;
		}
		System.out.println("String2: " + string2);
		
		// Copy reverse of string1 into string3
		String string3 = "";
		for (int i = string1.length() - 1; i >= 0; i--) {
			char c = string1.charAt(i);
			string3 += c;
		}
		System.out.println("String3: " + string3);
		
		// Create a string4
		// string4 is a palindrome of string1
		// i.e. if string1 = "asdf", string4 = "asdffdsa"
		String string4 = "";
		for (int i=0; i < string1.length(); i++) {
			char c = string1.charAt(i);
			string4 += c;
		}
		for (int i = string1.length() - 1; i >= 0; i--) {
			char c = string1.charAt(i);
			string4 += c;
		}
		System.out.println("String4: " + string4);
		
		// Create a string5
		// string5 flips in between the first and last letters and works its way inwards.
		// For example...
		// i.e. if string1 = "asdf", string5 = "afsd"
		// i.e. if string1 = "asdfq", string5 = "aqsfd"
		String string5 = "";
		for (int i=0; i < string1.length() / 2; i++) {
			char frontC = string1.charAt(i);
			char backC = string1.charAt(string1.length() - 1 - i);
			string5 += frontC;
			string5 += backC;
		}
		if (string1.length() % 2 == 1) {
			char c = string1.charAt(string1.length() / 2);
			string5 += c;
		}
		
		System.out.println("String5: " + string5);
	}

}
