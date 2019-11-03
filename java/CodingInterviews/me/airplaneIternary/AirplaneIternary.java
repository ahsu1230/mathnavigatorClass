package airplaneIternary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AirplaneIternary {
	public static class Ticket {
		public String start;
		public String dest;
		public static Ticket create(String s, String d) {
			Ticket t = new Ticket();
			t.start = s;
			t.dest = d;
			return t;
		}
	}

	/**
	 * Given a list of tickets and the starting point,
	 * return the list of same tickets, but sorted from start to final destination
	 * @param tickets
	 * @return
	 */
	public static List<Ticket> solution(List<Ticket> tickets, String startPoint) {
		if (startPoint == null) return null;
		if (tickets == null || tickets.size() == 0) return null;
		
		Map<String, Ticket> map = new HashMap<>();
		for (Ticket t : tickets) {
			map.put(t.start, t);
		}
		
		
		List<Ticket> sorted = new ArrayList<>();
		Ticket currentTicket = map.get(startPoint);
		sorted.add(currentTicket);
		
		while (map.containsKey(currentTicket.dest)) {
			currentTicket = map.get(currentTicket.dest);
			sorted.add(currentTicket);
		}
		
		return sorted;
	}

}
