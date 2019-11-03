package nearestPostOffice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class NearestPostOffice {
	
	/**
	 * Find the k post offices located closest to you, given your location and a list of locations of all post offices available.
		Locations are given in 2D coordinates in [X, Y], where X and Y are integers.
		Euclidean distance is applied to find the distance between you and a post office.
		Assume your location is [m, n] and the location of a post office is [p, q], 
		the Euclidean distance between the office and you is SquareRoot((m - p) * (m - p) + (n - q) * (n - q)).
		K is a positive integer much smaller than the given number of post offices. from aonecode.com
		
		e.g.
		Input
		you: [0, 0]
		post_offices: [[-16, 5], [-1, 2], [4, 3], [10, -2], [0, 3], [-5, -9]]
		k = 3
		
		Output from aonecode.com
		[[-1, 2], [0, 3], [4, 3]]

	 * Approach: 
	 * Go through array of coordinates, calc distance to you, and place in priority queue
	 * When finished with array, dequeue k times
	 * 
	 * Time: O(nlogn)
	 * Space: O(n)
	 * 
	 * Future Work:
	 * Time: O(n * klogk)
	 * Space: O(k) by only keeping track of k elements at a time 
	 * 
	 * @return
	 */
	public static List<PostOffice> solution(Coords myPosition, List<Coords> postOffices, int k) {
		PriorityQueue<PostOffice> pq = new PriorityQueue();
		
		System.out.println("------------");
		for (int i = 0; i < postOffices.size(); i++) {
			Coords c = postOffices.get(i);
			double distance = calcDistance(myPosition, c);
			
			PostOffice po = new PostOffice(c, distance);
			if (pq.size() < k) {
				System.out.println("Add " + i + "..." + distance);
				pq.add(po);
			} else {
				PostOffice peek = pq.peek();
				if (distance < peek.distance) {
					System.out.println("add " + i + "..." + distance);
					pq.remove();
					pq.add(po);
					System.out.println("PQ: " + pq.toString());
				} else {
					System.out.println("no-add " + i + "..." + distance);
				}
			}
		}
		
		System.out.println("Final PQ: " + pq.toString());
		
		List<PostOffice> result = new ArrayList<>();
		int index = 0;
		while (index < k && !pq.isEmpty()) {
			result.add(pq.poll());
			index++;
		}
		Collections.reverse(result);
		return result;
	}
	
	private static double calcDistance(Coords c1, Coords c2) {
		double x2 = (c1.i - c2.i) *  (c1.i - c2.i);
		double y2 = (c1.j - c2.j) *  (c1.j - c2.j);
		return Math.sqrt(x2 + y2);
	}
	
	protected static class PostOffice implements Comparable {
		public Coords coords;
		public double distance;
		
		PostOffice(Coords c, double d) {
			this.coords = c;
			this.distance = d;
		}

		@Override
		public int compareTo(Object o) {
			PostOffice po = (PostOffice) o;
			return (int)(po.distance - this.distance);
		}
		@Override
		public String toString() {
			return "[(" + coords.i + "," + coords.j + ")::" + distance + "]";
		}
	}
	
	protected static class Coords {
		int i;
		int j;
		
		Coords(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}
