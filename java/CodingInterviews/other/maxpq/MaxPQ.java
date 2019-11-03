package maxpq;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxPQ {
	
	private static void addAndPrint(int[] array, PriorityQueue<Integer> pq) {
		for (int i = 0; i < array.length; i++) {
			pq.add(array[i]);
		}
		while (!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}
	
	public static void main(String[] args) {
		int[] array = new int[] {1, 2, 5, 4, 3, 2, 10, 7};
		
		PriorityQueue<Integer> pq0 = new PriorityQueue<>(array.length, Collections.reverseOrder());
		addAndPrint(array, pq0);
		
		System.out.println("------");
		
		// Or you can try the following:
		PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>(array.length, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2){
				return o2 - o1;
			}
		});
		addAndPrint(array, pq1);
	}
}
