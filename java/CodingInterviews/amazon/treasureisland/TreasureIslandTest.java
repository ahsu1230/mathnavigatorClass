package treasureisland;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import treasureisland.TreasureIsland.Coords;

public class TreasureIslandTest {

	@Test
	public void testTrivial() {
//		assertEquals(null, TreasureIsland.solution(null));
//		assertEquals(null, TreasureIsland.solution(new String[][] {}));
//		assertEquals(null, TreasureIsland.solution(new String[][] {{"D"}}));
//		assertEquals(null, TreasureIsland.solution(new String[][] {{"O"}}));
	}
	
	@Test
	public void testBasic() {
//		List<Coords> minPath;
//		String[][] map;
//		
//		map = new String[][] {
//			{"O", "X"}
//		};
//		minPath = TreasureIsland.solution(map);
//		assertEquals(2, minPath.size());
//		
//		map = new String[][] {
//			{"O"},
//			{"X"}
//		};
//		minPath = TreasureIsland.solution(map);
//		assertEquals(2, minPath.size());
//		
//		map = new String[][] {
//			{"O", "D", "X"}
//		};
//		minPath = TreasureIsland.solution(map);
//		assertNull(minPath);
//		
//		map = new String[][] {
//			{"O"},
//			{"D"},
//			{"X"}
//		};
//		minPath = TreasureIsland.solution(map);
//		assertNull(minPath);
	}
	
	@Test
	public void test2x2() {
		List<Coords> minPath;
		String[][] map;
		
		map = new String[][] {
			{"O", "O"},
			{"X", "O"}
		};
		minPath = TreasureIsland.solution(map);
		assertEquals(2, minPath.size());
		
		map = new String[][] {
			{"O", "D"},
			{"O", "X"}
		};
		minPath = TreasureIsland.solution(map);
		assertEquals(3, minPath.size());
		
		map = new String[][] {
			{"O", "D"},
			{"D", "X"}
		};
		minPath = TreasureIsland.solution(map);
		assertEquals(null, minPath);
	}
	
	@Test
	public void testStress() {
		List<Coords> minPath;
		String[][] map;
		
		map = new String[][] {
			{"O", "O", "O", "O"},
			{"D", "O", "D", "O"},
			{"X", "O", "O", "O"},
		};
		minPath = TreasureIsland.solution(map);
		assertEquals(5, minPath.size());
		
		map = new String[][] {
			{"O", "O", "O", "O"},
			{"D", "O", "D", "O"},
			{"D", "O", "X", "O"},
		};
		minPath = TreasureIsland.solution(map);
		assertEquals(5, minPath.size());
		
		map = new String[][] {
			{"O", "O", "O", "O"},
			{"D", "O", "D", "O"},
			{"D", "D", "X", "O"},
		};
		minPath = TreasureIsland.solution(map);
		assertEquals(7, minPath.size());
		
		map = new String[][] {
			{"O", "O", "O", "D"},
			{"D", "O", "D", "O"},
			{"D", "D", "X", "O"},
		};
		minPath = TreasureIsland.solution(map);
		assertEquals(null, minPath);
	}

}
