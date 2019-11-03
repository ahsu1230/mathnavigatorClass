package teamFormation;

import java.util.List;
import java.util.PriorityQueue;

public class TeamFormation {
	public static long teamFormation(List<Integer> score, int team_size, int k) {
		if (score == null || score.size() == 0) return 0;
		if (team_size == 0 || k == 0) return 0;
		
		// Create 2 max PQs which represent sets in score list
		PriorityQueue<Score> pqL = new PriorityQueue<>(k);
		PriorityQueue<Score> pqR = new PriorityQueue<>(k);
		
		// Indexes (inclusive) keep track of employees from both sets
		int indexL = Math.min(k - 1, score.size() - 1);		// Keeps track of right-most employee of Left Set
		int indexR = Math.max(0,  score.size() - k);		// Keeps track of left-most employee of Right Set
		
		// Initialize PriorityQueues
		initPQ(score, pqL, 0, indexL);
		initPQ(score, pqR, indexR, score.size() - 1);
		
		long teamSum = 0;
		int teamCnt = 0;
		while (teamCnt < team_size && !pqL.isEmpty() && !pqR.isEmpty()) {
			Score sL = pqL.peek();
			Score sR = pqR.peek();
			
			if (sL.score > sR.score) { // Left score is bigger
				sL = pqL.poll();
				teamSum += sL.score;
				indexL++;
				if (indexL < score.size()) pqL.add(new Score(score.get(indexL), indexL));
			} else if (sR.score > sL.score) { // Right score is bigger
				sR = pqR.poll();
				teamSum += sR.score;
				indexR--;
				if (indexR >= 0) pqR.add(new Score(score.get(indexR), indexR));
			} else { // both are equal
				if (sL.index == sR.index) { // if indices match, its the same element!
					sL = pqL.poll();
					sR = pqR.poll();
					teamSum += sL.score;
					indexL++;
					if (indexL < score.size()) pqL.add(new Score(score.get(indexL), indexL));
					indexR--;
					if (indexR >= 0) pqR.add(new Score(score.get(indexR), indexR));
				} else { // otherwise, remove from left PQ
					sL = pqL.poll();
					teamSum += sL.score;
					indexL++;
					if (indexL < score.size()) pqL.add(new Score(score.get(indexL), indexL));
				}
			}
			teamCnt++;
		}
		
		return teamSum;
	}
	
	// indices are inclusive
	private static void initPQ(List<Integer> score, PriorityQueue<Score> pq, int start, int end) {
		for (int i = start; i <= end; i++) {
			pq.add(new Score(score.get(i), i));
		}
	}
	
	static class Score implements Comparable {
		int score;
		int index;
		
		Score(int score, int index) {
			this.score = score;
			this.index = index;
		}

		@Override
		public int compareTo(Object o) {
			Score s = (Score) o;
			return s.score - this.score;
		}
	}
}
