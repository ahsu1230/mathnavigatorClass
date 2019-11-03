package codility;

public class SquaredRange {
	/**
	 * Given two integer ranges (start inclusive, end inclusive),
	 * Return the number of squared integers within that range
	 * 
	 * @param start
	 * @param end
	 * @return -1 if error
	 */
	public static int solution(int start, int end) {
		if (start < 0 || end < 0) return -1;
		if (start > end) return -1;
		
		int rootStart = findNearestRoot(start);
		int rootStart2 = rootStart * rootStart;
		if (rootStart2 < start) {
			rootStart += 1;
		}
		
		int rootEnd = findNearestRoot(end);
		
		return rootEnd - rootStart + 1;
	}
	
	public static int findNearestRoot(int num) {
		if (num < 0) return -1;
		if (num == 0) return 0;
		if (num == 1) return 1;
		
		int max = num;
		int k = max / 2;
		int prev = k;
		
		while (k < max) {
			int k2 = k*k;
			
			if (k+1 == max) {
				if (k2 <= num) {
					break;
				} else {
					k = prev;
					break;
				}
			}
			
			if (k2 == num) {
				break;
			} else if (k2 > num) {
				max = k;
				prev = k;
				k = max / 2;
			} else if (k2 < num) {
				prev = k;
				k = k + ((max - k) / 2);
			}
		}
		
		return k;
	}
}
