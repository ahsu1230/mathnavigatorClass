package hired;

public class LargerSubTree {
	/**
	 * Given an array that depicts a binary tree (non-sorted)
	 * Return "L" if its left subtree is larger depth
	 * Return "R" if its right subtree is larger depth
	 * Return "" if both subtrees are same depth
	 * If a value in array is -1, it means the node doesn't exist
	 * i.e. [6,3,-1] means root is 6 with a left child 3 and no right child
	 * @param s
	 * @return
	 */
	public static String solution(int[] arr) {
		if (arr == null || arr.length <= 1) {
			return "";
		}
		
		int rootIndex = 0;
		int leftIndex = 2 * rootIndex + 1;
		int rightIndex = 2 * rootIndex + 2;
		int left = getDepth(arr, leftIndex);
		int right = getDepth(arr, rightIndex);
		
		if (left > right) {
			return "L";
		} else if (right > left) {
			return "R";
		} else {
			return "";
		}
    }
	
	private static int getDepth(int[] arr, int rootIndex) {
		if (rootIndex >= arr.length) {
			return 0;
		}
		if (arr[rootIndex] < 0) {
			return 0;
		}
		
		int leftIndex = 2 * rootIndex + 1;
		int rightIndex = 2 * rootIndex + 2;
		
		int leftDepth = 1 + getDepth(arr, leftIndex);
		int rightDepth = 1 + getDepth(arr, rightIndex);
		
		return Math.max(leftDepth,  rightDepth);
	}
}
