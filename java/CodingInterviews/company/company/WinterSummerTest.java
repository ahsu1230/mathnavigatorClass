package company;

import static org.junit.Assert.*;

import org.junit.Test;

public class WinterSummerTest {

	@Test
	public void testTrivial() {
		assertEquals(0, WinterSummer.solution(null));
		assertEquals(0, WinterSummer.solution(new int[] {}));
		assertEquals(1, WinterSummer.solution(new int[] {1}));
	}
	
	@Test
	public void testTwo() {
		assertEquals(2, WinterSummer.solution(new int[] {1, 1}));
		assertEquals(1, WinterSummer.solution(new int[] {1, 2}));
		assertEquals(2, WinterSummer.solution(new int[] {2, 1}));
	}
	
	@Test
	public void testMore() {
		assertEquals(5, WinterSummer.solution(new int[] {3, 3, 3, 3, 3}));
		assertEquals(1, WinterSummer.solution(new int[] {1, 2, 3, 4, 5}));
		assertEquals(5, WinterSummer.solution(new int[] {5, 4, 3, 2, 1}));
		assertEquals(5, WinterSummer.solution(new int[] {3, 2, 1, 2, 3}));
		assertEquals(5, WinterSummer.solution(new int[] {3, 2, 1, 2, 3, 4}));
		assertEquals(5, WinterSummer.solution(new int[] {1, 2, 3, 2, 1}));
		assertEquals(5, WinterSummer.solution(new int[] {1, 2, 3, 2, 1, 4}));
		assertEquals(6, WinterSummer.solution(new int[] {1, 2, 3, 2, 1, -1}));
		
		assertEquals(3, WinterSummer.solution(new int[] {5, -2, 3, 8, 6}));
		assertEquals(4, WinterSummer.solution(new int[] {-5, -5, -5, -42, 6, 12}));
		
		assertEquals(5, WinterSummer.solution(new int[] {-5, 5, 3, 2, -12, 16, 21, 24, 23}));
//		assertEquals(6, WinterSummer.solution(new int[] {-5, 5, 3, 2, -12, 16, 17, 24, 23}));
	}

}
