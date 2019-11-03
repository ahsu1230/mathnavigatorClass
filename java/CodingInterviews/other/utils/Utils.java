package utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Utils {
	public static List<List<Integer>> convert(int[][] array) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for (int i=0; i < array.length; i++) {
			List<Integer> newList = new ArrayList<>();
			for (int j=0; j < array[i].length; j++) {
				newList.add(array[i][j]);
			}
			result.add(newList);
		}
		return result;
	}
	
	public static void print2DArray(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j=0; j < array[i].length; j++) {
				System.out.print(array[i][j] + "\t");
			}
			System.out.println("");
		}
	}
	
	public static void print2DList(List<List<Integer>> list2D) {
		for (int i = 0; i < list2D.size(); i++) {
			for (int j=0; j < list2D.get(i).size(); j++) {
				System.out.print(list2D.get(i).get(j) + "\t");
			}
			System.out.println("");
		}
	}
	
	public static <E> E getOnlyElement(Set<E> set) {
		Iterator<E> iterator = set.iterator();

		if (!iterator.hasNext()) {
		    throw new RuntimeException("Collection is empty");
		}

		E element = iterator.next();

		if (iterator.hasNext()) {
		    throw new RuntimeException("Collection contains more than one item");
		}

		return element;
	}
	
	public static void main(String[] args) {
		int[][] A = new int[][] {
			{1, 2, 3},
			{1, 2, 3}
		};
		print2DArray(A);
		System.out.println("\n");
		print2DList(convert(A));
	}
}
