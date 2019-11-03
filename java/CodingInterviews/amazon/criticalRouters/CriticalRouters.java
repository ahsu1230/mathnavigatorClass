package criticalRouters;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import utils.Utils;

public class CriticalRouters {
	public List<Integer> criticalRouters(int numRouters, int numLinks, 
            ArrayList<Link> links) {
        Map<Integer, Set<Integer>> neighborMap = new HashMap<>();
        
        for (int i=0; i < links.size(); i++) {
            Link pair = links.get(i);
            int u = pair.u;
            int v = pair.v;
            
            // add neighbor map
            addNeighbor(neighborMap, u, v);
            addNeighbor(neighborMap, v, u);
        }
        
        Set<Integer> critical = new HashSet<>();
        
        boolean foundOne = false; 
        do {
        	for (Integer u : neighborMap.keySet()) {
            	Set<Integer> neighbors = neighborMap.get(u);

            	// node u is "danger" node and only has one neighbor
            	if (neighbors.size() == 1) {
            		critical.add(u);
            		foundOne = true;
            		
            		Integer v = Utils.getOnlyElement(neighbors);
            		
            		// removes u from v's neighbors
            		Set<Integer> neighborV = neighborMap.get(v);
            		neighborV.remove(u);
            		
            		// remove u from map
            		neighborMap.remove(u);
            	}
            }
        	foundOne = false;
        } while (foundOne); 

        List<Integer> criticalList = new ArrayList<>(critical);
        Collections.sort(criticalList);
        return criticalList;
	}
	
	private static void addNeighbor( Map<Integer, Set<Integer>> neighborMap, int u, int v) {
		Set<Integer> neighbors;
		if (neighborMap.containsKey(u)) {
        	neighbors = neighborMap.get(u);
        } else {
        	neighbors = new HashSet<>();
        }
		neighbors.add(v);
		neighborMap.put(u, neighbors);
	}
	
	static class Link {
		int u;
		int v;
		
		public static Link create(int u, int v) {
			Link l = new Link();
			l.u = u;
			l.v = v;
			return l;
		}
	}
}
