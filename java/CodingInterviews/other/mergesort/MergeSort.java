package mergesort;

import java.util.Arrays;

public class MergeSort {
	
	private static int[] merge(int[] arr1, int[] arr2) {
		System.out.println("-------");
		if (arr1 == null || arr2 == null) return null;
		int len1 = arr1.length;
		int len2 = arr2.length;
		
		int[] merged = new int[len1 + len2];
		int m = 0; // index for merged
		int i = 0; // index of arr1
		int j = 0; // index of arr2
		while (i < len1 && j < len2) {
			int a1 = arr1[i];
			int a2 = arr2[j];
			if (a1 <= a2) {
				merged[m] = a1;
				i++;
			} else {
				merged[m] = a2;
				j++;
			}
			m++;
		}
		
		while (m < merged.length) {
			if (i < len1) {
				merged[m] = arr1[i];
				i++;
			} else if (j < len2) {
				merged[m] = arr2[j];
				j++;
			}
			m++;
		}
		
		return merged;
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(merge(new int[] {}, new int[] {})));
		System.out.println(Arrays.toString(merge(new int[] {1}, new int[] {1})));
		System.out.println(Arrays.toString(merge(new int[] {1, 2, 3}, new int[] {})));
		System.out.println(Arrays.toString(merge(new int[] {}, new int[] {1, 2, 3})));
		System.out.println(Arrays.toString(merge(new int[] {1, 2, 3}, new int[] {4, 5})));
		System.out.println(Arrays.toString(merge(new int[] {4, 5}, new int[] {1, 2, 3})));
		System.out.println(Arrays.toString(merge(new int[] {1, 4, 5}, new int[] {1, 2, 3})));
	}
}
