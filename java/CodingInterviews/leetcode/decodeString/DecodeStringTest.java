package decodeString;

import static org.junit.Assert.*;

import org.junit.Test;

public class DecodeStringTest {

	@Test
	public void testTrivial() {
		assertEquals("", DecodeString.solution(null));
		assertEquals("", DecodeString.solution(""));
		assertEquals("a", DecodeString.solution("a"));
		assertEquals("ab", DecodeString.solution("ab"));
	}
	
	@Test
	public void testBasic() {
		assertEquals("abc", DecodeString.solution("abc"));
		assertEquals("abcabc", DecodeString.solution("2[abc]"));
		assertEquals("abcc", DecodeString.solution("ab2[c]"));
		assertEquals("aabc", DecodeString.solution("2[a]bc"));
		
	}
	
	@Test
	public void testStress() {
		assertEquals("aabcc", DecodeString.solution("2[a]b2[c]"));
		assertEquals("abcccabccc", DecodeString.solution("2[ab3[c]]"));
		assertEquals("aaabaaab", DecodeString.solution("2[3[a]b]"));
		assertEquals("abcabccdcdcdef", DecodeString.solution("2[abc]3[cd]ef"));
		assertEquals("afafafafafafafafafaf", DecodeString.solution("10[af]"));
	}
}
