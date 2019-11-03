package phoneNumberAlpha;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumberAlpha {
	public static List<String> letterCombinations1(String digits) {
		Map<String, List<String>> map = createMap1();
		return recurse(digits, map, new ArrayList<>());
	}
	
	private static List<String> recurse(String digits, 
			Map<String, List<String>> map, List<String> previous) {
		if (digits == null || digits.length() == 0) {
			return previous;
		}
		
		String digit = "" + digits.charAt(digits.length() - 1);
		List<String> mappedStrings = map.get(digit);
		
		if (digits.length() == 1) {
			return mappedStrings;
		}
		
		
		List<String> results = recurse(digits.substring(0, digits.length() - 1), map, previous);
		
		List<String> newResults = new ArrayList<>();
		for (String result : results) {
			 for (String s : mappedStrings) {
				 newResults.add(result + s);
			 }
		}
		return newResults;
	}
	
	private static Map<String, List<String>> createMap1() {
        Map<String, List<String>> map = new HashMap<>();
        map.put("2", Arrays.asList("a", "b", "c"));
        map.put("3", Arrays.asList("d", "e", "f"));
        map.put("4", Arrays.asList("g", "h", "i"));
        map.put("5", Arrays.asList("j", "k", "l"));
        map.put("6", Arrays.asList("m", "n", "o"));
        map.put("7", Arrays.asList("p", "q", "r", "s"));
        map.put("8", Arrays.asList("t", "u", "v"));
        map.put("9", Arrays.asList("w", "x", "y", "z"));
        return map;
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return null;
        
        Map<Integer, List<Character>> map = createMap();
        
        List<String> results = new ArrayList<>();
        
        for (int i=0; i < digits.length(); i++) {
            char c = digits.charAt(i);
            int numKey = Integer.valueOf("" + c);
            List<Character> cList = map.get(numKey);
            
            List<String> subResults = new ArrayList<>();
            for (Character cL : cList) {
                subResults.addAll(appendToPrevious(cL, results));
            }
            results = subResults;
        }
        
        return results;
    }
    
    private static List<String> appendToPrevious(Character c, List<String> previous) {
        List<String> L = new ArrayList<>();
        
        if (previous == null || previous.size() == 0) {
        	String s = "" + c;
        	L.add(s);
        } else {
        	for (String prev : previous) {
                String s = prev + c;
                L.add(s);
            }
        }
        
        return L;
    }
    
    private static Map<Integer, List<Character>> createMap() {
        Map<Integer, List<Character>> map = new HashMap<>();
        map.put(2, Arrays.asList('a', 'b', 'c'));
        map.put(3, Arrays.asList('d', 'e', 'f'));
        map.put(4, Arrays.asList('g', 'h', 'i'));
        map.put(5, Arrays.asList('j', 'k', 'l'));
        map.put(6, Arrays.asList('m', 'n', 'o'));
        map.put(7, Arrays.asList('p', 'q', 'r', 's'));
        map.put(8, Arrays.asList('t', 'u', 'v'));
        map.put(9, Arrays.asList('w', 'x', 'y', 'z'));
        return map;
    }
	
	public static void main(String[] args) {
		List<String> asdf = letterCombinations1("2323");
		for (String s : asdf) {
			System.out.println(s);
		}
		System.out.println("--- " + asdf.size());
	}
}
