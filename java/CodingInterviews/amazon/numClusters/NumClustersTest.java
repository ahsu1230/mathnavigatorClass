package numClusters;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class NumClustersTest {

	@Test
	public void test() {
		assertEquals(0, NumClusters.numberAmazonGoStores(0, 0, null));
		
		
		int[][] gridA = new int[][] {
			{1},
			{1},
			{1}
		};
		
		List<List<Integer>> grid = new ArrayList<List<Integer>>();
		for (int i=0; i < gridA.length; i++) {
			List<Integer> asdf = new ArrayList<Integer>();
			for (int j=0; j < gridA[0].length; j++) {
				asdf.add(gridA[i][j]);
			}
			grid.add(asdf);
		}

		assertEquals(1, NumClusters.numberAmazonGoStores(grid.size(), grid.get(0).size(), grid));
	}

}
