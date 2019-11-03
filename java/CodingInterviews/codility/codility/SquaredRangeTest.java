package codility;

import static org.junit.Assert.*;

import org.junit.Test;

public class SquaredRangeTest {

	@Test
	public void testTrivial() {
		assertEquals(-1, SquaredRange.findNearestRoot(-1));
		assertEquals(0, SquaredRange.findNearestRoot(0));
		assertEquals(1, SquaredRange.findNearestRoot(1));
	}
	
	@Test
	public void testSmall() {
		assertEquals(1, SquaredRange.findNearestRoot(2));
		assertEquals(1, SquaredRange.findNearestRoot(3));
		assertEquals(2, SquaredRange.findNearestRoot(4));
		assertEquals(2, SquaredRange.findNearestRoot(5));
	}
	
	@Test
	public void testLarge() {
		assertEquals(8, SquaredRange.findNearestRoot(80));
		assertEquals(9, SquaredRange.findNearestRoot(81));
		assertEquals(9, SquaredRange.findNearestRoot(82));
	}
	
	@Test
	public void testSolutionTrivial() {
		assertEquals(1, SquaredRange.solution(4, 4));
	}
	
	@Test
	public void testSolutionStress() {
		assertEquals(2, SquaredRange.solution(3, 15));
		assertEquals(3, SquaredRange.solution(4, 16));
		assertEquals(3, SquaredRange.solution(4, 17));
		assertEquals(2, SquaredRange.solution(5, 17));
	}
}
