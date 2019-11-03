package longest3Consec;

import java.util.PriorityQueue;

public class Longest3Consec {
	
	/**
	 * Given A, B, C, find any string of maximum length that can be created such that no 3 consecutive characters are same. There can be at max A 'a', B 'b' and C 'c'.

		Example 1:
		
		Input: A = 1, B = 1, C = 6
		Output: "ccbccacc"
		Example 2:
		
		Input: A = 1, B = 2, C = 3
		Output: "acbcbc"
	 * 
	 * Solution complexity O(N), N = a + b + c
	 * space: O(1), I use a PQ, but it only has 3 elements in it at all times
	 */
	public static String solution(int a, int b, int c) {
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		if (a > 0) pq.add(new Pair('a', a));
		if (b > 0) pq.add(new Pair('b', b));
		if (c > 0) pq.add(new Pair('c', c));
		
		int limit = 3;
		
		System.out.println("---------");
		
		char lastLetter = 'd'; // different character
		int lastLetterCnt = 0;
		String result = "";
		
		
		
		while (!pq.isEmpty()) {
			Pair p = pq.poll();
			
			if (p.letter == lastLetter) {
				
				if (lastLetterCnt + 1 >= limit) {
					if (pq.isEmpty()) continue; // no next letter to add to string!
					else {
						Pair p2 = pq.poll();
						result += p2.letter;
						p2.cnt--;
						lastLetter = p2.letter;
						lastLetterCnt = 1;
						if (p2.cnt > 0) pq.add(p2);
					}
				} else {
					result += p.letter;
					p.cnt--;
					lastLetterCnt++;
				}
				
			} else { // different from last letter
				result += p.letter;
				p.cnt--;
				lastLetter = p.letter;
				lastLetterCnt = 1;
			}
			
			if (p.cnt > 0) pq.add(p);
			
			System.out.println(result);
		}
		
		System.out.println("******");
		
		return result;
	}
	
	static class Pair implements Comparable {
		char letter;
		int cnt;
		
		Pair(char letter, int cnt) {
			this.letter = letter;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Object o) {
			Pair p = (Pair) o;
			return p.cnt - this.cnt;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(solution(4, 1, 1));
	}
}
