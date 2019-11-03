package shopkeeper;

import static org.junit.Assert.*;

import org.junit.Test;

public class ShopKeeperTest {

	@Test
	public void testTrivial() {
		assertEquals(0, ShopKeeper.solution(null));
		assertEquals(0, ShopKeeper.solution(new int[] {}));
		assertEquals(3, ShopKeeper.solution(new int[] {3}));
	}
	
	@Test
	public void testBasic() {
		assertEquals(3, ShopKeeper.solution(new int[] {3, 3}));
		assertEquals(3, ShopKeeper.solution(new int[] {3, 2}));
		assertEquals(7, ShopKeeper.solution(new int[] {3, 4}));
	}
	
	@Test
	public void testStress() {
		assertEquals(3, ShopKeeper.solution(new int[] {3, 3, 3, 3}));
		assertEquals(4, ShopKeeper.solution(new int[] {3, 2, 1, 1}));
		assertEquals(18, ShopKeeper.solution(new int[] {3, 4, 5, 6}));
		
		assertEquals(8, ShopKeeper.solution(new int[] {2, 3, 1, 2, 4, 2}));
		assertEquals(14, ShopKeeper.solution(new int[] {5,1,3,4,6,2}));
		assertEquals(10, ShopKeeper.solution(new int[] {1,3,3,2,5}));
	}

}
