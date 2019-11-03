package flightMovies;

import static org.junit.Assert.*;

import org.junit.Test;

public class FlightMoviesTest {

	@Test
	public void testTrivial() {
		assertEquals(null, FlightMovies.solution(null, 230));
		assertEquals(null, FlightMovies.solution(new int[] {}, 230));
		assertEquals(null, FlightMovies.solution(new int[] {2}, 0));
		assertEquals(null, FlightMovies.solution(new int[] {2}, 230));
	}
	
	@Test
	public void testOnePair() {
		int[] pair;
		pair = FlightMovies.solution(new int[] {1, 1}, 230);
		assertEquals(1, pair[0]);
		assertEquals(1, pair[1]);
		
		pair = FlightMovies.solution(new int[] {1, 2}, 230);
		assertEquals(1, pair[0]);
		assertEquals(2, pair[1]);
		
		pair = FlightMovies.solution(new int[] {1, 199}, 230);
		assertEquals(1, pair[0]);
		assertEquals(199, pair[1]);
		
		pair = FlightMovies.solution(new int[] {1, 200}, 230);
		assertNull(pair);
	}
	
	@Test
	public void testMany() {
		int[] pair;
		pair = FlightMovies.solution(new int[] {90, 85, 75, 60, 120, 150, 125}, 250);
		assertEquals(90, pair[0]);
		assertEquals(125, pair[1]);
		
		pair = FlightMovies.solution(new int[] {90, 90, 90, 90, 90}, 250);
		assertEquals(90, pair[0]);
		assertEquals(90, pair[1]);
		
		pair = FlightMovies.solution(new int[] {90, 90, 91, 90, 90}, 250);
		assertEquals(90, pair[0]);
		assertEquals(91, pair[1]);
		
		pair = FlightMovies.solution(new int[] {70, 120, 75, 180}, 230);
		assertEquals(75, pair[0]);
		assertEquals(120, pair[1]);
		
		pair = FlightMovies.solution(new int[] {170, 120, 175, 180}, 230);
		assertNull(pair);
	}

}
