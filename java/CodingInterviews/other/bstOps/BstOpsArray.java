package bstOps;

import java.util.ArrayList;
import java.util.List;

public class BstOpsArray {
	
	public static void insert(List<Integer> list, int value) {
		if (list == null) return;
		if (list.size() == 0) {
			list.add(value);
			return;
		}
		
		int start = 0;
		int end = list.size(); // exclusive
		
		while (start < end) {
			int middle = start + (end - start) / 2;
			if (start == middle) {
				if (value < list.get(start)) {
					list.add(start, value);
				} else {
					list.add(start + 1, value);
				}
				break;
			} else {
				if (value < list.get(middle)) {
					end = middle;
				} else {
					start = middle;
				}
			}
		}
	}
	
	public static void delete(List<Integer> list, int value) {
		if (list == null) return;
		if (list.size() == 0) return;
		if (list.size() == 1 && list.get(0) == value) {
			list.remove(0);
			return;
		}
		
		int start = 0;
		int end = list.size(); // exclusive
		
		while (start < end) {
			int middle = start + (end - start) / 2;
			if (start == middle) {
				if (list.get(start) == value) {
					list.remove(start);
				}
				break;
			} else {
				if (value < list.get(middle)) {
					end = middle;
				} else {
					start = middle;
				}
			}
		}
	}
	
//	public static boolean find(List<Integer> list, int value) {
//		if (list == null) return false;
//	}
//	
	
	public static void traverse(List<Integer> list) {
		list.forEach(i -> System.out.println(i));
		System.out.println("------");
	}
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		insert(list, 6);
		insert(list, 2);
		insert(list, 3);
		insert(list, 2);
		insert(list, 4);
		traverse(list);
		delete(list, 4);
		traverse(list);
	}
}
