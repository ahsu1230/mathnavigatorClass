package connectingropes;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConnectingRopesTest {

	@Test
	public void testTrivial() {
		assertEquals(0, ConnectingRopes.solution(null));
		assertEquals(0, ConnectingRopes.solution(new int[] {}));
		assertEquals(0, ConnectingRopes.solution(new int[] {1}));
	}
	
	@Test
	public void testTwo() {
		assertEquals(2, ConnectingRopes.solution(new int[] {1, 1}));
		assertEquals(3, ConnectingRopes.solution(new int[] {1, 2}));
		assertEquals(3, ConnectingRopes.solution(new int[] {2, 1}));
		assertEquals(0, ConnectingRopes.solution(new int[] {-1, 1}));
	}
	
	@Test
	public void testMore() {
		assertEquals(58, ConnectingRopes.solution(new int[] {4, 6, 8, 12}));
	}
}
