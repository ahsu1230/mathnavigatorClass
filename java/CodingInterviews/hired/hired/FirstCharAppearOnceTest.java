package hired;

import static org.junit.Assert.*;

import org.junit.Test;

public class FirstCharAppearOnceTest {

	@Test
	public void testNull() {
		assertEquals("", FirstCharAppearOnce.solution(null));
	}
	
	@Test
	public void testEmpty() {
		assertEquals("", FirstCharAppearOnce.solution(""));
	}
	
	@Test
	public void test1() {
		assertEquals("a", FirstCharAppearOnce.solution("a"));
	}
	
	@Test
	public void test2() {
		assertEquals("", FirstCharAppearOnce.solution("aa"));
		assertEquals("a", FirstCharAppearOnce.solution("ab"));
		assertEquals("b", FirstCharAppearOnce.solution("ba"));
	}
	
	@Test
	public void test3() {
		assertEquals("", FirstCharAppearOnce.solution("aaa"));
		assertEquals("b", FirstCharAppearOnce.solution("aab"));
		assertEquals("a", FirstCharAppearOnce.solution("abb"));
		assertEquals("a", FirstCharAppearOnce.solution("bba"));
		assertEquals("a", FirstCharAppearOnce.solution("abc"));
		assertEquals("c", FirstCharAppearOnce.solution("aca"));
	}
}
