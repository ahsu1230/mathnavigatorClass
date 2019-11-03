package hired;

import java.util.HashMap;
import java.util.Map;

public class FirstCharAppearOnce {
	
	/**
	 * Given a String, return the first character that appears only once
	 * @param String
	 * @return character (as String)
	 */
	public static String solution(String s) {
		if (s == null || s == "") {
			return "";
		}
		
		Map<Character, Integer> map = new HashMap<>();
		for (int i=0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				int cnt = map.get(c);
				map.put(c, cnt + 1);
			} else {
				map.put(c, 1);
			}
		}
		
		String result = "";
		for (int i=0; i < s.length(); i++) {
			char c = s.charAt(i);
			int cnt = map.get(c);
			if (cnt == 1) {
				result = "" + c;
				break;
			}
		}
		return result;
    }
}
