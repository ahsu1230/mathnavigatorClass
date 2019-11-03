package treasureisland;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class TreasureIsland {
	
	/**
	 * 	You have a map that marks the location of a treasure island. Some of the map area has jagged rocks and dangerous reefs. 
	 * Other areas are safe to sail in.
		There are other explorers trying to find the treasure. So you must figure out a shortest route to the treasure island.
		Assume the map area is a two dimensional grid, represented by a matrix of characters.
		You must start from the top-left corner of the map and can move one block up, down, left or right at a time.
		The treasure island is marked as ‘X’ in a block of the matrix. ‘X’ will not be at the top-left corner.
		Any block with dangerous rocks or reefs will be marked as ‘D’. You must not enter dangerous blocks. You cannot leave the map area.
		Other areas ‘O’ are safe to sail in. The top-left corner is always safe.
		Output the minimum number of steps to get to the treasure.
		e.g.
		Input
		[
		[‘O’, ‘O’, ‘O’, ‘O’],
		[‘D’, ‘O’, ‘D’, ‘O’],
		[‘O’, ‘O’, ‘O’, ‘O’],
		[‘X’, ‘D’, ‘D’, ‘O’],
		]
		
		Output from aonecode.com
		Route is (0, 0), (0, 1), (1, 1), (2, 1), (2, 0), (3, 0) The minimum route takes 5 steps.
		
		Approach:
		*** DFS - iterative approach. Use a Stack to keep track of current coordinate, path so far, visited so far
		***
		***
		
		Assumptions:
		*** If no valid path, return null
		*** If multiple shortest paths found, return any one
		***
		
		Further Work:
		*** Make a better hashcode function for Coords lol. 
		*   This is used because we want to easily find if we've previously visited a coordinate using a HashSet
		***
		***
	 */
	public static List<Coords> solution(String[][] map) {
		if (map == null || map.length == 0) return null;
		if (map[0] == null || map[0].length == 0) return null;
		
		int numRows = map.length;
		int numCols = map[0].length;
		
		boolean foundPath = false;
		int minDistance = numRows * numCols + 1;
		List<Coords> minPath = new ArrayList<>();
		
		Stack<Journal> stack = new Stack<>();
		Coords coords = new Coords(0, 0);
		List<Coords> path = new ArrayList<>();
		Set<Coords> visited = new HashSet<>();
		
		stack.push(new Journal(coords, path, visited));
		System.out.println("------------------");
		while (!stack.isEmpty()) {
			Journal journal = stack.pop();
			coords = journal.current;
			int i = coords.i;
			int j = coords.j;
			
			path = journal.path;
			// New list needed to save states
			List<Coords> newPath = new ArrayList<>();
			newPath.addAll(path);
			newPath.add(coords);
			
			visited = journal.visited;
			// New set needed to save states
			Set<Coords> newVisited = new HashSet<>();
			newVisited.addAll(visited);
			newVisited.add(coords);
			
			System.out.println("Currently at: " + coords);
			System.out.println("Path so far: " + path.toString());
			System.out.println("Visited: " + visited.toString());
			
			String mapVal = map[i][j];
			if ("X".equals(mapVal) && path.size() < minDistance) {
				minDistance = path.size();
				minPath = path;
				minPath.add(coords);
				foundPath = true;
				System.out.println("X found! " + path.size());
				System.out.println("Min path: " + path);
			} else {
				System.out.println("Push!");
				pushNeighbors(map, stack, coords, newPath, newVisited);
			}
			System.out.println("---");
		}
		
		if (foundPath) {
			return minPath;
		} else {
			return null;
		}
	}
	
	private static void pushNeighbors(
			String[][] map, 
			Stack<Journal> stack, 
			Coords coords, 
			List<Coords> path, 
			Set<Coords> visited) {
		int numRows = map.length;
		int numCols = map[0].length;
		
		int currI = coords.i;
		int currJ = coords.j;
		
		for (int i = -1; i < 2; i++) {
			int newI = currI + i;
			if (newI >= 0 && newI < numRows && !"D".equals(map[newI][currJ])) {
				Coords c = new Coords(newI, currJ);
				if (!visited.contains(c)) {
					Journal journal = new Journal(c, path, visited);
					stack.push(journal);
				}
			}
		}
		
		for (int j = -1; j < 2; j++) {
			int newJ = currJ + j;
			if (newJ >= 0 && newJ < numCols && !"D".equals(map[currI][newJ])) {
				Coords c = new Coords(currI, currJ + j); 
				if (!visited.contains(c)) {
					Journal journal = new Journal(c, path, visited);
					stack.push(journal);
				}
			}
		}
	}
	
	protected static class Coords {
		int i;
		int j;
		
		public Coords(int i, int j) {
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
			return 1234321234 * this.i + this.j;
		}
		
		@Override
		public String toString() {
			return "(" + i + "," + j + ")";
		}
	}
	
	public static class Journal {
		List<Coords> path; // path so far
		Set<Coords> visited; // visited coordinates so far
		Coords current;
		
		public Journal(Coords current, List<Coords> path, Set<Coords> visited) {
			this.current = current;
			this.path = path;
			this.visited = visited;
		}
	}
}
