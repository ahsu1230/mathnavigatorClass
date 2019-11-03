package cryptoSubstitute;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CryptoSubstitute {
	/**
	 * A substitution cipher (also sometimes known as cryptogram) is a simple form of cryptography where each letter in the target string is replaced with a unique replacement letter.

for instance, given the string "banana" the following would be possible substitution ciphers:
"adndnd", "efgfgf", but the following would not  "abcdef", ("b", "d", and "f" all map to "a", "c" and "e" maps to "n") and  "bttttt" ("t" maps to both "a" and "n"), or "adndn" (this could be "banan", but it's too short to be "banana")

Write a function that, given 2 strings, returns true if it's possible for the two strings to be substitution cyphers of each other.

	 * @param s1
	 * @param s2
	 * @return
	 */
	public boolean solution(String s1, String s2) {
		if (s1 == null) {
			return s2 == null;
		}
		
		if (s1.length() != s2.length()) { return false; }
		
		Map<Character, Character> forwardMap = new HashMap<>();
		Map<Character, Character> backMap = new HashMap<>();
		
		// fill in maps!
		for (int i=0; i < s1.length(); i++) {
			char c1 = s1.charAt(i);
			char c2 = s2.charAt(i);

			if (forwardMap.containsKey(c1)) {
				char inMap = forwardMap.get(c1);
				if (c2 != inMap) return false;
			} else {
				forwardMap.put(c1, c2);
			}

			if (backMap.containsKey(c2)) {
				char inMap = backMap.get(c2);
				if (c1 != inMap) return false;
			} else {
				backMap.put(c2, c1);
			}
	} 
	return true;
	}

	
	// What if given 2 sets of Strings that could potentially match
	// return a subset of ciphers
	// s.t. string is a match in texts
	// banana or ytrtrtr <-> efdfdfd or qmnmnmn
	// abcbcbc -> Set<cipher strings>
	// in texts,
	// bcdcdcd -> Set<texts strings>
	// abcbcbc matches bcdcdcd
	Set<String> Solution(Set<String> ciphers, Set<String> texts) {
		
		Map<String, Set<String>> cipherMap = new HashMap<>();
		Map<String, Set<String>> textMap = new HashMap<>();
		
		for (String s : ciphers) {
			String pattern = createPattern(s);
			if (cipherMap.containsKey(pattern)) {
				Set<String> set = cipherMap.get(pattern);
				set.add(s);
				cipherMap.put(pattern, set);
			} else {
				Set<String> set = new HashSet<>();
				set.add(s);
			cipherMap.put(pattern, set);
			}
		}

	for (String s : texts) {
			String pattern = createPattern(s);
			if (textMap.containsKey(pattern)) {
				Set<String> set = textMap.get(pattern);
				set.add(s);
				textMap.put(pattern, set);
			} else {
				Set<String> set = new HashSet<>();
				set.add(s);
			textMap.put(pattern, set);
			}
		}

		// go through cipherMap
		// if pattern is ALSO in textMap
		// add cipherMap.get(pattern) to big Set
		Set<String> result = new HashSet<>();
		for(String pattern : cipherMap.keySet()) {
			if (textMap.containsKey(pattern)) {
				result.addAll(cipherMap.get(pattern));
			}
		}
		return result;
	}

	String createPattern(String s) {
		String pattern = "";
		char c = 'a';
		// character in s -> character in pattern
		Map<Character, Character> map = new HashMap<>();
		for (int i=0; i < s.length(); i++) {
			char si = s.charAt(i);
			if (map.containsKey(si)) {
				pattern += map.get(si);
			} else {
				map.put(si, c);
				pattern += map.get(si);
				c++;
			}
		}
		return pattern;
	}

}
