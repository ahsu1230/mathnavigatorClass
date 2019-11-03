package hired;

import static org.junit.Assert.*;

import org.junit.Test;

public class StockPricingTest {

	@Test
	public void testTrivial() {
		assertEquals(0, StockPricing.solution(null));
		assertEquals(0, StockPricing.solution(new int[] {}));
		assertEquals(0, StockPricing.solution(new int[] {1}));
	}
	
	@Test
	public void testTwo() {
		assertEquals(0, StockPricing.solution(new int[] {1, 1}));
		assertEquals(1, StockPricing.solution(new int[] {1, 2}));
		assertEquals(0, StockPricing.solution(new int[] {2, 1}));
	}
	
	@Test
	public void testStress() {
		assertEquals(0, StockPricing.solution(new int[] {4, 4, 4, 4}));
		assertEquals(3, StockPricing.solution(new int[] {1, 2, 3, 4}));
		assertEquals(0, StockPricing.solution(new int[] {4, 3, 2, 1}));
		
		assertEquals(7, StockPricing.solution(new int[] {5, 2, 7, -1, 4, 6}));
		assertEquals(7, StockPricing.solution(new int[] {5, 2, 7, -1, 4, 6, 2}));
		
		assertEquals(50, StockPricing.solution(new int[] {1, 2, 3, 51, -1, 2}));
		assertEquals(42, StockPricing.solution(new int[] {1, 2, 3, 4, -40, 2}));
		assertEquals(43, StockPricing.solution(new int[] {1, 2, 3, 4, -40, 2, 3}));
		assertEquals(42, StockPricing.solution(new int[] {1, 2, 3, 4, -40, 2, -1, -4}));
	}
}
