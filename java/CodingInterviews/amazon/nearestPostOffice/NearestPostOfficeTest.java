package nearestPostOffice;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import nearestPostOffice.NearestPostOffice.Coords;
import nearestPostOffice.NearestPostOffice.PostOffice;

public class NearestPostOfficeTest {

	@Test
	public void testTrivial() {
	}
	
	@Test
	public void testBasic() {
		Coords myCoords = new Coords(0,0);
		List<Coords> poCoords = new ArrayList<>();
		poCoords.add(new Coords(1, 1));
		List<PostOffice> results = NearestPostOffice.solution(myCoords, poCoords, 1);
		assertEquals(Math.sqrt(2), results.get(0).distance, 0.1);
		assertEquals(1, results.size());
	}
	
	@Test
	public void testK1() {
		Coords myCoords = new Coords(0,0);
		List<Coords> poCoords = new ArrayList<>();
		poCoords.add(new Coords(7, 7));
		poCoords.add(new Coords(3, 4));
		poCoords.add(new Coords(4, 0));
		poCoords.add(new Coords(1, 4));
		List<PostOffice> results = NearestPostOffice.solution(myCoords, poCoords, 1);
		assertEquals(Math.sqrt(16), results.get(0).distance, 0.1);
		assertEquals(1, results.size());
	}
	
	@Test
	public void testK2() {
		Coords myCoords = new Coords(0,0);
		List<Coords> poCoords = new ArrayList<>();
		poCoords.add(new Coords(7, 7));
		poCoords.add(new Coords(3, 4));
		poCoords.add(new Coords(4, 0));
		poCoords.add(new Coords(1, 4));
		List<PostOffice> results = NearestPostOffice.solution(myCoords, poCoords, 2);
		assertEquals(Math.sqrt(16), results.get(0).distance, 0.1);
		assertEquals(Math.sqrt(17), results.get(1).distance, 0.1);
		assertEquals(2, results.size());
	}
	
	@Test
	public void testKStress() {
		Coords myCoords = new Coords(0,0);
		List<Coords> poCoords = new ArrayList<>();
		poCoords.add(new Coords(7, 7));
		poCoords.add(new Coords(3, 4));
		poCoords.add(new Coords(4, 0));
		poCoords.add(new Coords(1, 4));
		
		
		List<PostOffice> results = NearestPostOffice.solution(myCoords, poCoords, 3);
		assertEquals(Math.sqrt(16), results.get(0).distance, 0.1);
		assertEquals(Math.sqrt(17), results.get(1).distance, 0.1);
		assertEquals(Math.sqrt(9+16), results.get(2).distance, 0.1);
//		assertEquals(Math.sqrt(49+49), results.get(3).distance, 0.1);
		assertEquals(3, results.size());
	}

}
