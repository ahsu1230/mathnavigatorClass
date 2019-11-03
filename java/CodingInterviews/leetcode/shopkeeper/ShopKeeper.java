package shopkeeper;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ShopKeeper {

	/**
	*** Problem: *** 
	A shopkeeper has a sale to complete and has arranged the items being sold in a list. Starting from the left, the shop keeper rings up each item at its full price less the price of the first lower or equally priced item to its right. If there is no item to the right that costs less than or equal to the current item's price the current item is sold at full price.

	For example, assume there are items priced [2, 3, 1, 2, 4, 2].
	The first and second items would each be discounted by 1 unit, the first equal or lower price to the right.
	The item priced 1 unit would sell at a full price.
	The next item, at 2 units, would be discounted 2 units as would the 4 unit item.
	The sixth and final item must be purchased at full price.
	The total cost is 1+2+1+0+2+2 = 8 units.
	
	Print total cost of all items on the first line.
	On the second line print a space separated list of integers representing the indexes of the non- discounted items in ascending index order.
	
	1 <= size(prices) <= 100000
	1 <= prices <= 1000000
	
	Output:
	8
	2 5
	
	Input 2: [5,1,3,4,6,2]
	Output:
	14
	1 5
	
	Input 3: [1,3,3,2,5]
	Output:
	9 <- I think it's actually 10
	0 3 4
	
	Approach:
	* Use two pointers. One pointer (i) will be processing every item
	* Another pointer (j) will be finding the next local min price after i
	* When a local min is found, pointer i will process every item up to that local min
	* Once i meets j, we process item i as full price, and then find next local min
	*
	* Complexity (Time): O(2n) => O(n) every item in array is visited once by both pointers
	* Complexity (Space): O(1)
	
	Edge Cases:
	* null array or empty array => 0
	* 1 item in array => full price of item
	* only increasing array
	* only decreasing array
	
	Assumptions:
	* All prices are positive (given)
	
	Further Work:
	*
	*
	*
	*/
	public static int solution(int[] items) {
		if (items == null || items.length == 0) return 0;
		
		System.out.println("---------");
		Stack<Integer> stack = new Stack<>();
		
		// find all elements that will be full priced
		int j = items.length - 1;
		int localMin = Integer.MAX_VALUE; // always push last element in list!
		while (j >= 0) {
			if (items[j] < localMin) {
				localMin = items[j];
				stack.push(j);
			}
			j--;
		}
		
		List<Integer> fullPriced = new ArrayList<>();
		
		int sum = 0;
		int i = 0;
		while (!stack.isEmpty()) {
			j = stack.pop();
			fullPriced.add(j);
			
			while (i < j) {
				sum += (items[i] - items[j]); // calculate discount
				System.out.println(i + " Disc: " + sum);
				i++;
			}
			// i == j
			sum += items[i]; // calculate full priced
			System.out.println(i + " Full: " + sum);
			i++;
		}
		
		System.out.println(fullPriced.toString());
		return sum;
	}
	
	
	public static void main(String[] args) {
		System.out.println(solution(new int[] {3}));
		System.out.println(solution(new int[] {3, 3, 3}));
		System.out.println(solution(new int[] {3, 2, 1}));
		System.out.println(solution(new int[] {3, 4, 5}));
	}

}
