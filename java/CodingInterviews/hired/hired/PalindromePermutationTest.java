package hired;

import static org.junit.Assert.*;

import org.junit.Test;

public class PalindromePermutationTest {

	@Test
	public void testNull() {
		assertFalse(PalindromePermutation.solution(null));
	}
	
	@Test
	public void testEmpty() {
		assertFalse(PalindromePermutation.solution(""));
	}
	
	@Test
	public void test1() {
		assertTrue(PalindromePermutation.solution("a"));
	}
	
	@Test
	public void test2() {
		assertTrue(PalindromePermutation.solution("aa"));
		assertFalse(PalindromePermutation.solution("ab"));
	}
	
	@Test
	public void test3() {
		assertTrue(PalindromePermutation.solution("aaa"));
		assertTrue(PalindromePermutation.solution("aab"));
		assertTrue(PalindromePermutation.solution("abb"));
		assertFalse(PalindromePermutation.solution("abc"));
	}
	
	@Test
	public void testStress() {
		assertTrue(PalindromePermutation.solution("aabb"));
		assertTrue(PalindromePermutation.solution("aabbc"));
		assertFalse(PalindromePermutation.solution("asdf"));
		assertFalse(PalindromePermutation.solution("aabbasdf"));
	}

}
