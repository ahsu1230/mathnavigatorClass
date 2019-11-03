package bart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Bart {
	public static class TrainTime implements Comparable<TrainTime> {
		String trainName;
		int arrivalTime;
		
		public static TrainTime create(String name, int time) {
			TrainTime t = new TrainTime();
			t.trainName = name;
			t.arrivalTime = time;
			return t;
		}

		@Override
		public int compareTo(TrainTime o) {
			return this.arrivalTime - o.arrivalTime;
		}
	}
	
	/**
	 * Given a list of train times (train "A" is arriving in 4 minutes)
	 * Return a map of train names to their times in sorted order from decreasing to increasing
	 * "A" trains arriving in 2, 5, 8 minutes
	 * "B" trains arriving in 1, 4 minutes
	 * @param list
	 * @return
	 */
	public static Map<String, List<Integer>> solution1(List<TrainTime> list) {
		Map<String, List<Integer>> map = new HashMap<>();
		
		// Create map (train name -> list of arrival times)
		for (TrainTime t : list) {
			String name = t.trainName;
			int time = t.arrivalTime;
			List<Integer> trainList;
			if (map.containsKey(name)) {
				trainList = map.get(name);
			} else {
				trainList = new ArrayList<>();
			}
			trainList.add(time);
			map.put(name,  trainList);
		}
		
		// Sort train times per train name
		for (String name : map.keySet()) {
			List<Integer> times = map.get(name);
			Collections.sort(times);
			map.put(name, times);
		}
		
		return map;
	}
	
	/**
	 * Given a list of train times (train "A" is arriving in 4 minutes)
	 * Return a list of mappings from train names to their times in sorted order from decreasing to increasing
	 * The trains must be sorted by their first arrival time 
	 * 
	 * "B" trains arriving in 1, 4 minutes
	 * "A" trains arriving in 2, 5, 8 minutes
	 * 
	 * @param list
	 * @return
	 */
	public static List<TrainArrivalTimes> solution2(List<TrainTime> list) {
		Map<String, List<Integer>> map = new HashMap<>();
		
		PriorityQueue<TrainTime> pq = new PriorityQueue<>();
		
		for (TrainTime t : list) {
			pq.add(t); // should sort based on arrival time
			
			String name = t.trainName;
			int time = t.arrivalTime;
			List<Integer> trainList;
			if (map.containsKey(name)) {
				trainList = map.get(name);
			} else {
				trainList = new ArrayList<>();
			}
			trainList.add(time);
			map.put(name,  trainList);
		}
		
		List<TrainArrivalTimes> times = new ArrayList<>();
		
		// Sort by First Arrival Time
		Set<String> set = new HashSet<>();
		while (!pq.isEmpty()) {
			TrainTime tt = (TrainTime) pq.poll();
			String trainName = tt.trainName;
			if (!set.contains(trainName)) {
				TrainArrivalTimes tat = TrainArrivalTimes.create(trainName);
				tat.arrivalTimes = map.get(trainName);
				times.add(tat);
				set.add(trainName);
			}
		}
		
		// Sort each list of arrival times
		for (TrainArrivalTimes tat : times) {
			Collections.sort(tat.arrivalTimes);
		}
		
		return times;
	}
	
	public static class TrainArrivalTimes {
		String trainName;
		List<Integer> arrivalTimes;
		
		public static TrainArrivalTimes create(String s) {
			TrainArrivalTimes t = new TrainArrivalTimes();
			t.trainName = s;
			t.arrivalTimes = new ArrayList<>();
			return t;
		}
	}
}
