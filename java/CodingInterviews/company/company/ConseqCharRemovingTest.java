package company;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConseqCharRemovingTest {

	@Test
	public void testTrivial() {
		assertEquals(null, ConseqCharRemoving.solution(null));
		assertEquals("", ConseqCharRemoving.solution(""));
		assertEquals("a", ConseqCharRemoving.solution("a"));
		assertEquals("aa", ConseqCharRemoving.solution("aa"));
		assertEquals("ab", ConseqCharRemoving.solution("ab"));
		assertEquals("aa", ConseqCharRemoving.solution("aaa"));
	}
	
	@Test
	public void testSimple() {
		assertEquals("xaa", ConseqCharRemoving.solution("xaaa"));
		assertEquals("aax", ConseqCharRemoving.solution("aaax"));
		assertEquals("aaxaa", ConseqCharRemoving.solution("aaxaa"));
		assertEquals("aaxaa", ConseqCharRemoving.solution("aaaxaaa"));
	}
	
	@Test
	public void testMore() {
		assertEquals("eedaad", ConseqCharRemoving.solution("eedaaad"));
		assertEquals("xxtxx", ConseqCharRemoving.solution("xxxtxxx"));
		assertEquals("uuxaaxuu", ConseqCharRemoving.solution("uuuuxaaaaxuuu"));
		assertEquals("asdfqqasdfzzasdf", ConseqCharRemoving.solution("asdfqqqasdfzzzzzzzzzasdf"));
		assertEquals("asdfqqasdfzzasdff", ConseqCharRemoving.solution("asdfqqqasdfzzzzzzzzzasdffffff"));
	}

}
