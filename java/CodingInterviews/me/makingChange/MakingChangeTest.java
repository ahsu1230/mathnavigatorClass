package makingChange;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class MakingChangeTest {
	
	@Test
	public void testNoAmount() {
		List<Integer> denoms = Arrays.asList(1);
		assertEquals(0, MakingChange.makingChange(0, denoms).size());
    }
	
	@Test
	public void testNoCoinsLeft() {
		int amount = 1;
		List<Integer> denoms = Arrays.asList(2);
		assertEquals(0, MakingChange.makingChange(amount, denoms).size());
    }
	
	@Test
	public void testOneCoin() {
		int amount = 1;
		List<Integer> denoms = Arrays.asList(1);
		List<List<Integer>> changes = MakingChange.makingChange(amount, denoms);
		assertEquals(1, changes.size());
		assertEquals("[1]", changes.get(0).toString());
    }
	
	@Test
	public void testTwoCoins() {
		int amount = 2;
		List<Integer> denoms = Arrays.asList(1, 2);
		List<List<Integer>> changes = MakingChange.makingChange(amount, denoms);
		assertEquals(2, changes.size());
		System.out.println("--- " + amount + "---" + denoms);
		System.out.println(changes.get(0));
		System.out.println(changes.get(1));
    }
	
	@Test
	public void test3() {
		int amount = 4;
		List<Integer> denoms = Arrays.asList(1, 2);
		List<List<Integer>> changes = MakingChange.makingChange(amount, denoms);
		assertEquals(3, changes.size());
		System.out.println("---" + amount + "---" + denoms);
		System.out.println(changes.get(0));
		System.out.println(changes.get(1));
		System.out.println(changes.get(2));
    }
	
	@Test
	public void test4() {
		int amount = 4;
		List<Integer> denoms = Arrays.asList(1, 2, 3);
		List<List<Integer>> changes = MakingChange.makingChange(amount, denoms);
		assertEquals(4, changes.size());
		System.out.println("---" + amount + "---" + denoms);
		System.out.println(changes.get(0));
		System.out.println(changes.get(1));
		System.out.println(changes.get(2));
		System.out.println(changes.get(3));
    }
	
	@Test
	public void test5() {
		String str1 = "A";
		String str2 = "B";
		swap(str1, str2);
		assertEquals("A", str1);
		assertEquals("B", str2);
    }
	
	@Test
	public void test6() {
		Something s1 = new Something();
		s1.val = 1;
		Something s2 = new Something();
		s2.val = 2;
		swap(s1, s2);
		assertEquals(1, s1.val);
		assertEquals(2, s2.val);
		
		changeValue(s1);
		assertEquals(4, s1.val);
		assertEquals(2, s2.val);
    }
	
	public class Something {
		int val;
	}
	
	private void swap(Object o1, Object o2) {
		Object o = o1;
		o1 = o2;
		o2 = o;
	}
	
	private void changeValue(Something s) {
		s.val = 4;
	}
}
