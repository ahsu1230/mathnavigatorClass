package hired;

import java.util.HashMap;
import java.util.HashSet;

public class PalindromePermutation {
	
	/**
	 * Given a String, return whether it is the permutation of a palindrome
	 * i.e. "aabb" should be true, because it can be "abba"
	 * 
	 * @param s
	 * @return
	 */
    public static boolean solution(String s) {
    	if (s == null || s == "") {
    		return false;
    	}
    	
    	HashMap<Character, Integer> map = new HashMap<>();
    	
    	for (int i=0; i < s.length(); i++) {
    		char c = s.charAt(i);
    		if (map.containsKey(c)) {
    			int cnt = map.get(c);
    			map.put(c, cnt + 1);
    		} else {
    			map.put(c, 1);
    		}
    	}
    	
    	// s is a palindrome if 1 or 0 characters have an odd count.
    	int numOdds = 0;
    	for (Character c : map.keySet()) {
    		if (map.get(c) % 2 == 1) {
    			numOdds++;
    		}
    	}
    	boolean isPalindrome = numOdds <= 1;
    	return isPalindrome;
    }
	
	public static void main(String[] args) {
		System.out.println(solution("qwaeraqwQWEef"));
	}
}
