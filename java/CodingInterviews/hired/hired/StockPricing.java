package hired;

public class StockPricing {
	
	/**
	 * Given an integer array (can be negative) of stock prices throughout the day
	 * Return the maximum profit you can make from buying at one point in time,
	 * and selling at a larger point in time.
	 * Larger index in array means later in time.
	 * i.e. [5,2,7,-1,4,6] should return 7 because you buy at -1 and sell at 6
	 * 
	 * @param prices
	 * @return
	 */
	public static int solution(int[] prices) {
		if (prices == null || prices.length <= 1) {
			return 0;
		}
		
		int maxProfit = 0;
		
		boolean foundLocalMin = false;
		boolean foundLocalMax = false;
		int localMinValue = Integer.MAX_VALUE;
		int localMaxValue = Integer.MIN_VALUE;
		int currentProfit = 0;
		
		int i = 0;
		
		while (i < prices.length) {
			
			// Find local min
			while (i < prices.length && prices[i] <= localMinValue) {
				foundLocalMin = true;
				localMinValue = prices[i];
				i++;
			}
			
			// From here, find local max
			while (i < prices.length && prices[i] >= localMaxValue) {
				foundLocalMax = true;
				localMaxValue = prices[i];
				i++;
			}
			
			if (!foundLocalMin || !foundLocalMax) {
				break;
			}
			
			currentProfit = localMaxValue - localMinValue;
			if (currentProfit > maxProfit) {
				maxProfit = currentProfit;
			}
			localMinValue = Integer.MAX_VALUE;
			localMaxValue = Integer.MIN_VALUE;
			foundLocalMin = false;
			foundLocalMax = false;
		}
		
		return maxProfit;
    }
}
