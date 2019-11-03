package sameFaceDice;

import static org.junit.Assert.*;

import org.junit.Test;

public class SameFaceDiceTest {

	@Test
	public void testTrivial() {
		assertEquals(-1, SameFaceDice.solution(null));
		assertEquals(-1, SameFaceDice.solution(new int[] {}));
		assertEquals(0, SameFaceDice.solution(new int[] {1}));
	}
	
	@Test
	public void testBasic() {
		assertEquals(0, SameFaceDice.solution(new int[] {1, 1}));
		assertEquals(1, SameFaceDice.solution(new int[] {1, 2}));
		assertEquals(2, SameFaceDice.solution(new int[] {1, 6}));
		assertEquals(1, SameFaceDice.solution(new int[] {2, 1}));
		assertEquals(2, SameFaceDice.solution(new int[] {6, 1}));
		assertEquals(2, SameFaceDice.solution(new int[] {2, 5}));
		assertEquals(2, SameFaceDice.solution(new int[] {5, 2}));
		assertEquals(2, SameFaceDice.solution(new int[] {3, 4}));
		assertEquals(2, SameFaceDice.solution(new int[] {4, 3}));
	}
	
	@Test
	public void testStress() {
		assertEquals(0, SameFaceDice.solution(new int[] {1, 1, 1, 1}));
		assertEquals(1, SameFaceDice.solution(new int[] {1, 1, 1, 2}));
		assertEquals(2, SameFaceDice.solution(new int[] {1, 1, 2, 2}));
		assertEquals(1, SameFaceDice.solution(new int[] {1, 2, 2, 2}));
		
		assertEquals(2, SameFaceDice.solution(new int[] {1, 6, 6, 6}));
		assertEquals(4, SameFaceDice.solution(new int[] {1, 6, 6, 1}));
		
		assertEquals(3, SameFaceDice.solution(new int[] {1, 6, 2, 3}));
	}

}
