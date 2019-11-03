package connectingropes;

import java.util.PriorityQueue;

public class ConnectingRopes {

	/**
	 * Given n ropes of different lengths, you need to connect these ropes into one rope. You can connect only 2 ropes at a time. The cost required to connect 2 ropes is equal to sum of their lengths. The length of this connected rope is also equal to the sum of their lengths. This process is repeated until n ropes are connected into a single rope. Find the min possible cost required to connect all ropes.

		Input
		ropes, an int arrary representing the rope length.
		
		Output
		Return the min possible cost required to connect all ropes.
		
		Examples 1
		Input:
		ropes = [8, 4, 6, 12]
		
		Output:
		58
		
		Explanation: The optimal way to connect ropes is as follows
		1. Connect the ropes of length 4 and 6 (cost is 10). Ropes after connecting: [8, 10, 12]
		2. Connect the ropes of length 8 and 10 (cost is 18). Ropes after connecting: [18, 12]
		3. Connect the ropes of length 18 and 12 (cost is 30).
		Total cost to connect the ropes is 10 + 18 + 30 = 58
		
		Examples 2
		Input:
		ropes = [20, 4, 8, 2]
		
		Output:
		54
		
		Examples 3
		Input:
		ropes = [1, 2, 5, 10, 35, 89]
		
		Output:
		224
		
		Examples 4
		Input:
		ropes = [2, 2, 3, 3]
		
		Output:
		20

	 * @return
	 */
	public static int solution(int[] ropes) {
		if (ropes == null || ropes.length <= 1) return 0;
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		// Enqueue all ropes into min-heap
		for (int i=0; i < ropes.length; i++) {
			pq.add(ropes[i]);
		}
		
		// Calculate total cost by repeatedly removing 2 min elements
		// And adding the total cost element back in
		int totalCost = 0;
		int cnt =0;
		while (cnt < ropes.length - 1 && !pq.isEmpty()) {
			Integer rope1 = pq.poll();
			Integer rope2 = pq.poll();
			
			int cost = rope1 + rope2;
			totalCost += cost;
			pq.add(cost);
			
			cnt++;
		}
		
		return totalCost;
	}
}
