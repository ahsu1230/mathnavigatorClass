package hired;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringNoRepeat {
	
	/**
	 * Given a String, return length of longest substring
	 * of non-repeating characters
	 * 
	 * i.e. Given "rasdfersfx", should return 6 because of substring "rasdfe"
	 * 
	 * @param s
	 * @return
	 */
	public static int solution(String s) {
		if (s == null) return 0;
		
		String maxSubstring = "";
		
		Set<Character> set = new HashSet<>();
		String currentSubstring = "";
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (set.contains(c)) {
				// Change max substring (if needed)
				if (currentSubstring.length() > maxSubstring.length()) {
					maxSubstring = currentSubstring;
				}
				
				// remove all characters before previously found char
				currentSubstring = removeCharacters(currentSubstring, c, set);
				set.add(c);
				currentSubstring += c;
			} else {
				set.add(c);
				currentSubstring += c;
			}
		}
		
		if (currentSubstring.length() > maxSubstring.length()) {
			maxSubstring = currentSubstring;
		}
		return maxSubstring.length();
    }
	
	private static String removeCharacters(String substring, char targetC, Set<Character> set) {
		int found = substring.indexOf(targetC);
		if (found >= 0) {
			for (int i=0; i <= found; i++) {
				char removeC = substring.charAt(i);
				set.remove(removeC);
			}
		}
		return substring.substring(found + 1);
	}
}
