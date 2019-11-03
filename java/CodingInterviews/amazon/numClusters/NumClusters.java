package numClusters;

import java.util.List;
import java.util.Stack;

public class NumClusters {
	static int numberAmazonGoStores(int rows, int column, List<List<Integer>> grid)
    {
        if (grid == null) return 0;
        if (rows == 0 || column == 0) return 0;
        if (grid.size() == 0 || grid.get(0).size() == 0) return 0;
        
        int cnt = 0; // represents number of components found
        int[][] visited = new int[rows][column]; // visited[i][j] is 0 if not visited, >0 if visited
        
        for (int i=0; i < rows; i++) {
        	for (int j=0; j < column; j++) {
        		System.out.println("----");
        		System.out.println("       Visited? " + i + "," + j + " " + visited[i][j]);
        		if (grid.get(i).get(j) == 1 && visited[i][j] == 0) {
        			cnt++;
        			System.out.println("Found! " + i + "," + j);
        			startDfs(grid, rows, column, i, j, visited, cnt);
        		}
        	}
        }
		return cnt;
    }
	
	
	static void startDfs(List<List<Integer>> grid, int rows, int column, int startI, int startJ, int[][] visited, int cnt) {
		Stack<Coords> stack = new Stack<>();
		stack.push(Coords.create(startI,startJ));
		
		while (!stack.isEmpty()) {
			Coords c = stack.pop();
			
			int currI = c.i;
			int currJ = c.j;
			
			// Mark position as visited
			visited[currI][currJ] = cnt;
			
			// Push neighboring valid positions
			// A position is valid if its in bounds, is occupied space (marked 1 in grid) and not visited yet
			for (int y = -1; y < 2; y++) {
				int nextI = currI + y;
				boolean inBound = nextI >= 0 && nextI < rows;
				if (inBound && grid.get(nextI).get(currJ) != 0 && visited[nextI][currJ] == 0) {
					stack.push(Coords.create(nextI, currJ));
				}
			}
			
			for (int x = -1; x < 2; x++) {
				int nextJ = currJ + x;
				boolean inBound = nextJ >= 0 && nextJ < column;
				if (inBound && grid.get(currI).get(nextJ) != 0 && visited[currI][nextJ] == 0) {
					stack.push(Coords.create(currI,  nextJ));
				}
			}
		}
	}
	
	
	static class Coords {
		int i;
		int j;
		
		static Coords create(int i, int j) {
			Coords c = new Coords();
			c.i = i;
			c.j = j;
			return c;
		}
	}
}
