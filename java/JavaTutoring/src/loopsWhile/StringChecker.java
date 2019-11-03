package loopsWhile;

public class StringChecker {
	public static void main(String args[]) {
		String string1 = "asdf1";
		String string2 = "asdf1";
		
		boolean isSame = true;
		
		if (string1.length() != string2.length()) {
			isSame = false;
		} else {
			int i=0;
			while (i < string1.length()) {
				char c1 = string1.charAt(i);
				char c2 = string2.charAt(i);
				if (c1 != c2) {
					isSame = false;
				}
				i++;
			}
		}
		
		if (isSame) {
			System.out.println("Strings are the same!");
		} else {
			System.out.println("Strings are not the same!");
		}
	}

}
