package flightMovies;

import java.util.Arrays;
import java.util.Collections;

public class FlightMovies {
	
	/**
		You are on a flight and wanna watch two movies during this flight.
		You are given int[] movie_duration which includes all the movie durations.
		You are also given the duration of the flight which is d in minutes.
		Now, you need to pick two movies and the total duration of the two movies is less than or equal to (d - 30min).
		Find the pair of movies with the longest total duration. If multiple found, return the pair with the longest movie.
		
		e.g.
		Input
		movie_duration: [90, 85, 75, 60, 120, 150, 125]
		d: 250
		
		Output from aonecode.com
		[90, 125]
		90min + 125min = 215 is the maximum number within 220 (250min - 30min)
		
		Approach:
		* We can sort the array first in ascending order
		* After that, we can have 2 pointers, one pointer I starting from index 0, 
		* the other pointer J from end of array.
		* The idea is to find the max pair less than (d - 30)
		* 
		* We move the pointers accordingly until they meet, in which case we've visited all elements.
		* This also guarantees the pair with the longest movie because pointerJ is starting from
		* the longest movie.
		* If the sum is > (d - 30), we decrement J (pair is too high, should decrease the sum) 
		* If the sum is < (d - 30), we increment I (pair is too low, should increase the sum)
		* If the sum is exactly equal, we can break out early because this pair
		* is guaranteed to have the longest movie (thanks to pointerJ starting from the end)
		* 
		*** Complexity (Time): O(nlogn)
		*** Complexity (Space): O(1)
		
		Assumptions:
		*** No movie has 0 or negative value. You can't have a movie with such length.
		*** If inputs are invalid, we return NULL
		*** If no pair exists, we return NULL
		
		Further Work:
		***
		***
		***
	*/
	public static int[] solution(int[] array, int d) {
		if (array == null || array.length <= 1) return null;
		if (d <= 30) return null;
		
		Arrays.sort(array);
		
		int limit = d - 30;
		int maxSum = -1;
		int maxI = -1;
		int maxJ = -1;
		int i = 0;
		int j = array.length - 1;
		
		while (i < array.length && j >= 0 && i < j) {
			System.out.println("... " + i + "," + j);
			int sum = array[i] + array[j];
			if (sum == limit) {
				maxI = i;
				maxJ = j;
				maxSum = sum;
				break;
			} else if (sum < limit) {
				if (sum > maxSum) {
					maxSum = sum;
					maxI = i;
					maxJ = j;
				}
				i++;
			} else { // sum > limit
				j--;
			}
		}
		
		if (maxSum < 0) { // not found!
			return null;
		} else {
			System.out.println("[" + maxI + "," + maxJ + "]");
			return new int[] { array[maxI], array[maxJ] };
		}
	}
}
