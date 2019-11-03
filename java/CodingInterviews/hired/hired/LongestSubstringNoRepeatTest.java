package hired;

import static org.junit.Assert.*;

import org.junit.Test;

public class LongestSubstringNoRepeatTest {

	@Test
	public void testTrivial() {
		assertEquals(0, LongestSubstringNoRepeat.solution(null));
		assertEquals(0, LongestSubstringNoRepeat.solution(""));
		assertEquals(1, LongestSubstringNoRepeat.solution("a"));
		assertEquals(2, LongestSubstringNoRepeat.solution("ab"));
		assertEquals(3, LongestSubstringNoRepeat.solution("abc"));
	}
	
	@Test
	public void test() {
		assertEquals(1, LongestSubstringNoRepeat.solution("aaa"));
		assertEquals(2, LongestSubstringNoRepeat.solution("aabb"));
		assertEquals(3, LongestSubstringNoRepeat.solution("abca"));
		assertEquals(4, LongestSubstringNoRepeat.solution("abcad"));
		assertEquals(7, LongestSubstringNoRepeat.solution("abcdbefgh"));
		assertEquals(5, LongestSubstringNoRepeat.solution("qwaeraq"));
		assertEquals(6, LongestSubstringNoRepeat.solution("rasdfersfx"));
	}

}
