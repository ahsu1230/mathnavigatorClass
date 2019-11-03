package airplaneIternary;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import airplaneIternary.AirplaneIternary.Ticket;

public class AirplaneIternaryTest {

	@Test
	public void testTrivial() {
		assertNull(AirplaneIternary.solution(null,  null));
		assertNull(AirplaneIternary.solution(new ArrayList<>(),  "S"));
	}
	
	@Test
	public void testOne() {
		List<Ticket> list = new ArrayList<>();
		list.add(Ticket.create("S", "A"));
		
		List<Ticket> result = AirplaneIternary.solution(list, "S");
		
		assertEquals("S", result.get(0).start);
		assertEquals("A", result.get(0).dest);
		assertEquals(1, result.size());
	}
	
	@Test
	public void testTwoA() {
		List<Ticket> list = new ArrayList<>();
		list.add(Ticket.create("S", "A"));
		list.add(Ticket.create("A", "B"));
		
		List<Ticket> result = AirplaneIternary.solution(list, "S");
		
		assertEquals("S", result.get(0).start);
		assertEquals("A", result.get(0).dest);
		
		assertEquals("A", result.get(1).start);
		assertEquals("B", result.get(1).dest);
		assertEquals(2, result.size());
	}
	
	@Test
	public void testTwoB() {
		List<Ticket> list = new ArrayList<>();
		list.add(Ticket.create("A", "B"));
		list.add(Ticket.create("S", "A"));
		
		List<Ticket> result = AirplaneIternary.solution(list, "S");
		
		assertEquals("S", result.get(0).start);
		assertEquals("A", result.get(0).dest);
		
		assertEquals("A", result.get(1).start);
		assertEquals("B", result.get(1).dest);
		assertEquals(2, result.size());
	}
	
	@Test
	public void testThree() {
		List<Ticket> list = new ArrayList<>();
		list.add(Ticket.create("A", "B"));
		list.add(Ticket.create("S", "A"));
		list.add(Ticket.create("B", "C"));
		
		List<Ticket> result = AirplaneIternary.solution(list, "S");
		
		assertEquals("S", result.get(0).start);
		assertEquals("A", result.get(0).dest);
		
		assertEquals("A", result.get(1).start);
		assertEquals("B", result.get(1).dest);
		
		assertEquals("B", result.get(2).start);
		assertEquals("C", result.get(2).dest);
		assertEquals(3, result.size());
	}

}
