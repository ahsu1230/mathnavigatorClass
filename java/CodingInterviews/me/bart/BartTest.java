package bart;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import bart.Bart.TrainArrivalTimes;
import bart.Bart.TrainTime;

public class BartTest {

	@Test
	public void testMap1() {
		List<TrainTime> list = new ArrayList<>();
		list.add(TrainTime.create("A", 1));
		list.add(TrainTime.create("A", 2));
		Map<String, List<Integer>> map = Bart.solution1(list);
		assertEquals(1, map.get("A").get(0).intValue());
		assertEquals(2, map.get("A").get(1).intValue());
	}
	
	@Test
	public void testMap2() {
		List<TrainTime> list = new ArrayList<>();
		list.add(TrainTime.create("A", 1));
		list.add(TrainTime.create("A", 2));
		list.add(TrainTime.create("B", 4));
		list.add(TrainTime.create("B", 3));
		Map<String, List<Integer>> map = Bart.solution1(list);
		assertEquals(1, map.get("A").get(0).intValue());
		assertEquals(2, map.get("A").get(1).intValue());
		assertEquals(3, map.get("B").get(0).intValue());
		assertEquals(4, map.get("B").get(1).intValue());
	}
	
	@Test
	public void testMap3() {
		List<TrainTime> list = new ArrayList<>();
		list.add(TrainTime.create("A", 1));
		list.add(TrainTime.create("A", 2));
		list.add(TrainTime.create("B", 4));
		list.add(TrainTime.create("B", 3));
		list.add(TrainTime.create("C", 2));
		list.add(TrainTime.create("B", 1));
		Map<String, List<Integer>> map = Bart.solution1(list);
		assertEquals(1, map.get("A").get(0).intValue());
		assertEquals(2, map.get("A").get(1).intValue());
		assertEquals(2, map.get("A").size());
		assertEquals(1, map.get("B").get(0).intValue());
		assertEquals(3, map.get("B").get(1).intValue());
		assertEquals(4, map.get("B").get(2).intValue());
		assertEquals(3, map.get("B").size());
		assertEquals(2, map.get("C").get(0).intValue());
		assertEquals(1, map.get("C").size());
	}
	
	@Test
	public void testSorted1() {
		List<TrainTime> list = new ArrayList<>();
		list.add(TrainTime.create("A", 6));
		list.add(TrainTime.create("A", 7));
		list.add(TrainTime.create("B", 4));
		list.add(TrainTime.create("B", 3));
		list.add(TrainTime.create("C", 2));
		list.add(TrainTime.create("B", 1));
		List<TrainArrivalTimes> result = Bart.solution2(list);
		
		// Correct train ordering?
		assertEquals("B", result.get(0).trainName);
		assertEquals("C", result.get(1).trainName);
		assertEquals("A", result.get(2).trainName);
		
		// Correct arrival time ordering?
		// Check "B" train
		assertEquals(1, result.get(0).arrivalTimes.get(0).intValue());
		assertEquals(3, result.get(0).arrivalTimes.get(1).intValue());
		assertEquals(4, result.get(0).arrivalTimes.get(2).intValue());
		assertEquals(3, result.get(0).arrivalTimes.size());
		
		// Check "C" train
		assertEquals(2, result.get(1).arrivalTimes.get(0).intValue());
		assertEquals(1, result.get(1).arrivalTimes.size());
		
		// Check "A" train
		assertEquals(6, result.get(2).arrivalTimes.get(0).intValue());
		assertEquals(7, result.get(2).arrivalTimes.get(1).intValue());
		assertEquals(2, result.get(2).arrivalTimes.size());
	}
}
