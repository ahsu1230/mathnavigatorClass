package teamFormation;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TeamFormationTest {

	@Test
	public void testTrivial() {
		assertEquals(0, TeamFormation.teamFormation(null, 1, 1));
		
		List scores;
		scores = Arrays.asList(2);
		assertEquals(0, TeamFormation.teamFormation(scores, 0, 1));
		assertEquals(0, TeamFormation.teamFormation(scores, 1, 0));
		assertEquals(2, TeamFormation.teamFormation(scores, 1, 1));
	}
	
	@Test
	public void testBasic() {
		List scores;
		
		scores = Arrays.asList(1, 2, 3, 4);
		assertEquals(4, TeamFormation.teamFormation(scores, 1, 1));
		assertEquals(4, TeamFormation.teamFormation(scores, 1, 2));
		assertEquals(4, TeamFormation.teamFormation(scores, 1, 3));
		assertEquals(4, TeamFormation.teamFormation(scores, 1, 4));
		assertEquals(4, TeamFormation.teamFormation(scores, 1, 5));
		
		scores = Arrays.asList(4, 3, 2, 1);
		assertEquals(4, TeamFormation.teamFormation(scores, 1, 4));
		assertEquals(7, TeamFormation.teamFormation(scores, 2, 4));
		
		scores = Arrays.asList(4, 3, 2, 1);
		assertEquals(10, TeamFormation.teamFormation(scores, 4, 4));
		
		scores = Arrays.asList(4, 3, 2, 4);
		assertEquals(8, TeamFormation.teamFormation(scores, 2, 1));
		assertEquals(8, TeamFormation.teamFormation(scores, 2, 4));
		assertEquals(13, TeamFormation.teamFormation(scores, 4, 4));
		
		scores = Arrays.asList(4, 4, 1, 1);
		assertEquals(8, TeamFormation.teamFormation(scores, 2, 1));
		scores = Arrays.asList(1, 1, 4, 4);
		assertEquals(8, TeamFormation.teamFormation(scores, 2, 1));
		assertEquals(8, TeamFormation.teamFormation(scores, 2, 2));
		assertEquals(9, TeamFormation.teamFormation(scores, 3, 1));
		assertEquals(9, TeamFormation.teamFormation(scores, 3, 2));
	}
	
	@Test
	public void testStress() {
		
	}
}
