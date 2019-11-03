package flood2darray;

import static org.junit.Assert.*;

import org.junit.Test;

public class Flood2DArrayTest {

	@Test
	public void testTrivial() {
		assertEquals(-1, Flood2DArray.solution(null));
		String[][] array = new String[][] {};
		assertEquals(0, Flood2DArray.solution(array));
	}
	
	@Test
	public void test1() {
		String[][] array = new String[][] {{"A"}};
		assertEquals(1, Flood2DArray.solution(array));
	}
	
	@Test
	public void test1x3() {
		String[][] array = new String[][] {{"A", "A", "A"}};
		assertEquals(3, Flood2DArray.solution(array));
		
		array = new String[][] {{"A", "A", "C"}};
		assertEquals(2, Flood2DArray.solution(array));
		
		array = new String[][] {{"C", "A", "A"}};
		assertEquals(2, Flood2DArray.solution(array));
		
		array = new String[][] {{"A", "C", "A"}};
		assertEquals(1, Flood2DArray.solution(array));
	}
	
	@Test
	public void test3x1() {
		String[][] array = new String[][] {{"A"}, {"A"}, {"A"}};
		assertEquals(3, Flood2DArray.solution(array));
		
		array = new String[][] {{"A"}, {"A"}, {"C"}};
		assertEquals(2, Flood2DArray.solution(array));
		
		array = new String[][] {{"C"}, {"A"}, {"A"}};
		assertEquals(2, Flood2DArray.solution(array));
		
		array = new String[][] {{"A"}, {"C"}, {"A"}};
		assertEquals(1, Flood2DArray.solution(array));
	}
	
	@Test
	public void test2() {
		// 2x2
		String[][] array = new String[][] {{"A", "A"}, {"A", "A"}};
		assertEquals(4, Flood2DArray.solution(array));
		
		// 2x3
		array = new String[][] {{"A", "A", "B"}, {"A", "A", "C"}};
		assertEquals(4, Flood2DArray.solution(array));
		
		// 3x2
		array = new String[][] {{"A", "A"}, {"A", "C"}, {"B", "C"}};
		assertEquals(3, Flood2DArray.solution(array));
		
		// 3x3
		array = new String[][] {
			{"A", "A", "B"}, 
			{"A", "C", "C"}, 
			{"B", "B", "A"}
		};
		assertEquals(3, Flood2DArray.solution(array));
		
		array = new String[][] {
			{"A", "A", "B"}, 
			{"C", "C", "B"}, 
			{"B", "B", "A"}
		};
		assertEquals(2, Flood2DArray.solution(array));
		
		array = new String[][] {
			{"A", "A", "B"}, 
			{"C", "C", "B"}, 
			{"B", "B", "B"}
		};
		assertEquals(5, Flood2DArray.solution(array));
		
		array = new String[][] {
			{"A", "A", "B"}, 
			{"A", "C", "A"}, 
			{"B", "A", "A"}
		};
		assertEquals(3, Flood2DArray.solution(array));
	}

}
