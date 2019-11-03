package hired;

import static org.junit.Assert.*;

import org.junit.Test;

public class LargerSubTreeTest {

	@Test
	public void testNull() {
		assertEquals("", LargerSubTree.solution(null));
	}
	
	@Test
	public void testEmpty() {
		int[] arr1 = new int[]{};
		assertEquals("", LargerSubTree.solution(arr1));
		
		int[] arr2 = new int[]{-1};
		assertEquals("", LargerSubTree.solution(arr2));
	}
	
	@Test
	public void testOne() {
		int[] arr1 = new int[]{2};
		assertEquals("", LargerSubTree.solution(arr1));
	}
	
	@Test
	public void testTwo() {
		int[] arr1 = new int[]{2, 3, -1};
		assertEquals("L", LargerSubTree.solution(arr1));
		
		int[] arr2 = new int[]{2, -1, 3};
		assertEquals("R", LargerSubTree.solution(arr2));
	}
	
	@Test
	public void testStress() {
		int[] arr1 = new int[]{2, 3, 4};
		assertEquals("", LargerSubTree.solution(arr1));
		
		int[] arr2 = new int[]{2, 5, 6, 4, -1, -1, -1};
		assertEquals("L", LargerSubTree.solution(arr2));
		
		int[] arr3 = new int[]{2, 5, 6, -1, -1, 9, 8};
		assertEquals("R", LargerSubTree.solution(arr3));
	}

}
