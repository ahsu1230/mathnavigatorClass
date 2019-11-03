package decodeString;

public class DecodeString {
	
	/**
	 * Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
	 * 
	 * Examples
	 * s = "3[a]2[bc]", return "aaabcbc".
	 * s = "3[a2[c]]", return "accaccacc".
	 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
	 * 
	 * @param encoded
	 * @return
	 */
	public static String solution(String s) {
		if (s == null || s.length() == 0) return "";
		
		// find correct bracket indexes
		int indexOpenBracket = s.indexOf('[');
		int indexCloseBracket = -1;
		
		// No recursive case found
		if (indexOpenBracket < 0 && indexCloseBracket < 0) {
			return s;
		}
		
		// Recursive case found!
		int bracketCnt = 0;
		int i = indexOpenBracket;
		while (i < s.length()) {
			char c = s.charAt(i);
			if (c == '[') {
				bracketCnt++;
			} else if (c == ']') {
				indexCloseBracket = i;
				bracketCnt--;
			}
			
			if (bracketCnt == 0 && indexCloseBracket > 0) {
				// corresponding close bracket found!
				break;
			}
			i++;
		}
		
		int indexNumber = -1;
		i = indexOpenBracket - 1;
		while (i >= 0) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				indexNumber = i;
			} else {
				break;
			}
			i--;
		}
		
		int numRepeat = Integer.parseInt(s.substring(indexNumber, indexOpenBracket));
		String strToRepeat = solution(s.substring(indexOpenBracket + 1, indexCloseBracket));
		String repeated = repeat(strToRepeat, numRepeat);
		
		StringBuilder sb = new StringBuilder();
		if (indexNumber > 0) {
			sb.append(solution(s.substring(0, indexNumber)));
		}
		sb.append(repeated);
		sb.append(solution(s.substring(indexCloseBracket + 1)));
		return sb.toString();
	}
	
	private static String repeat(String s, int num) {
		StringBuilder sb = new StringBuilder();
		for (int i=0; i < num; i++) {
			sb.append(s);
		}
		return sb.toString();
	}
}
