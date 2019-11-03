package amazonsort;

import static org.junit.Assert.*;

import org.junit.Test;

public class AmazonSortCenterTest {

	@Test
	public void testTrivial() {
		assertNull(AmazonSortCenter.solution(31, null));
		assertNull(AmazonSortCenter.solution(31, new int[] {}));
		assertNull(AmazonSortCenter.solution(30, new int[] {}));
		
		assertNull(AmazonSortCenter.solution(31, new int[] {1}));
		assertNotNull(AmazonSortCenter.solution(32, new int[] {1, 1}));
	}
	
	@Test
	public void testBasic() { // space to fill is 2 units
		int[] result;
		result = AmazonSortCenter.solution(32, new int[] {1, 1});
		assertEquals(0, result[0]);
		assertEquals(1, result[1]);
		
		result = AmazonSortCenter.solution(32, new int[] {1, 1, 2});
		assertEquals(0, result[0]);
		assertEquals(1, result[1]);
		
		result = AmazonSortCenter.solution(32, new int[] {2, 1, 1});
		assertEquals(1, result[0]);
		assertEquals(2, result[1]);
		
		result = AmazonSortCenter.solution(32, new int[] {2, 2});
		assertNull(result);
		
		result = AmazonSortCenter.solution(32, new int[] {2, 1});
		assertNull(result);
	}
	
	@Test
	public void testStress() {
		int[] result;
		result = AmazonSortCenter.solution(90, new int[] {1, 10, 25, 35, 60});
		assertEquals(2, result[0]);
		assertEquals(3, result[1]);
		
		result = AmazonSortCenter.solution(89, new int[] {1, 10, 25, 35, 60});
		assertNull(result);
		
		result = AmazonSortCenter.solution(91, new int[] {1, 10, 25, 35, 60});
		assertEquals(0, result[0]);
		assertEquals(4, result[1]);
		
		result = AmazonSortCenter.solution(90, new int[] {1, 10, 25, 35, 59});
		assertEquals(0, result[0]);
		assertEquals(4, result[1]);
		
		result = AmazonSortCenter.solution(90, new int[] {59, 10, 25, 35, 1});
		assertEquals(0, result[0]);
		assertEquals(4, result[1]);
		
		result = AmazonSortCenter.solution(90, new int[] {50, 10, 25, 35, 1, 59});
		assertEquals(4, result[0]);
		assertEquals(5, result[1]);
	}
	
	@Test
	public void testDP1() {
		assertEquals(4, AmazonSortCenter.solution1(10, new int[] {4, 2, 3, 1, 5}));
		assertEquals(0, AmazonSortCenter.solution1(10, new int[] {11, 12, 13, 14, 15}));
//		assertEquals(1, AmazonSortCenter.solution1(10, new int[] {11, 12, 13, 14, 5}));
	}
}
