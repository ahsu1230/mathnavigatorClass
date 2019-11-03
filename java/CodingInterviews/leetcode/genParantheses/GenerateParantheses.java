package genParantheses;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/generate-parentheses/
 * LeetCode Medium
 * @author aaronhsu
 * 10/31 11:30pm -> 12:00am
 */
public class GenerateParantheses {
	public static List<String> generateParenthesis(int n) {
        if (n == 0) return new ArrayList<>();
        List<String> result = recurse(n);
        return result;
    }
    
    private static List<String> recurse(int n) {
        if (n == 1) {
            List<String> list = new ArrayList<>();
            list.add("()");
            return list;
        }
        
        List<String> subResults = recurse(n-1);
        
        Set<String> set = new HashSet<>();
        List<String> results = new ArrayList<>();
        for (String sub : subResults) {
            String newStr1 = "(" + sub + ")";
            String newStr2 = "()" + sub;
            String newStr3 = sub + "()";
            if (!set.contains(newStr1)) {
                set.add(newStr1);
                results.add(newStr1);
            }
            if (!set.contains(newStr2)) {
                set.add(newStr2);
                results.add(newStr2);
            }
            if (!set.contains(newStr3)) {
                set.add(newStr3);
                results.add(newStr3);
            }
            if (n % 2 == 0) {
                List<String> subResults2 = recurse(n / 2);
                for (String s2 : subResults2) {
                    String newStr4 = s2 + s2;
                    if (!set.contains(newStr4)) {
                        set.add(newStr4);
                        results.add(newStr4);
                    }
                }
            }
        }
        return results;
    }
	
	public static void main(String[] args) {
		List<String> results = generateParenthesis(4);
		for (String s : results) {
			System.out.println(s);
		}
	}
}
