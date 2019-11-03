package flood2darray;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Flood2DArray {
	
	
	/**
	 * Given a 2d array each cell labeled with a color name,
	 * Return the largest connected group with the same color name
	 * @param array
	 * @return
	 */
	public static int solution(String[][] array) {
		if (array == null) return -1;
		if (array.length == 0) return 0;
		if (array[0].length == 0) return 0;
		int numRows = array.length;
		int numCols = array[0].length;
		
		int max = 0;
		for (int i=0; i < numRows; i++) {
			for (int j=0; j < numCols; j++) {
				max = Math.max(max, findConnections(array, i, j));
			}
		}
		return max;
	}
	
	/**
	 * Given an array and a starting point (i,j), 
	 * return the number of connected groups from this starting point
	 * @param array
	 * @param startI
	 * @param startJ
	 * @return
	 */
	private static int findConnections(String[][] array, int startI, int startJ) {
		Stack<Coords> s = new Stack<>();
		
		s.push(new Coords(startI, startJ));
		String startColor = array[startI][startJ];
		
		Set<Coords> visited = new HashSet<>();
		
		int numConnected = 0;
		while (!s.isEmpty()) {
			Coords c = s.pop();
			String currentColor = array[c.i][c.j];
			
			if (visited.contains(c)) {
				continue;
			} else {
				if (startColor.equals(currentColor)) {
					numConnected++;
					// adds all valid neighbors to stack
					addAllNeighbors(array, c.i, c.j, s);
				}
				visited.add(c);
			}
		}
		
		return numConnected;
	}
	
	private static void addAllNeighbors(String[][] array, int i, int j, Stack<Coords> s) {
		int numRows = array.length;
		int numCols = array[0].length;

		// Add only "+" surrounding neighbors
		for (int x = -1; x < 2; x++) {
			int I = i + x;
			if (I >= 0 && I < numRows) {
				s.push(new Coords(I, j));
			}
		}
		
		for (int y = -1; y < 2; y++) {
			int J = j + y;
			if (J >= 0 && J < numCols) {
				s.push(new Coords(i, J));
			}
		}
		
		// Add diagonals neighbors
//		for (int x = -1; x < 2; x++) {
//			for (int y = -1; y < 2; y++) {
//				int I = i + x;
//				int J = j + y;
//				if (I >= 0 && I < numRows && J >= 0 && J < numCols) {
//					s.push(new Coords(I, J));
//				}
//			}
//		}
	}
	
	private static class Coords {
		int i;
		int j;
		
		Coords(int i, int j) {
			this.i = i;
			this.j = j;
		}
		
		@Override
		public boolean equals(Object o) {
			Coords c = (Coords) o;
			return this.i == c.i && this.j == c.j;
		}
		
		@Override
		public int hashCode() {
			return 12345678 * i + j;
		}
	}
}
