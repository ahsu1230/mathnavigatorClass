package makingChange;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MakingChange {
	public static List<List<Integer>> makingChange(int amount, List<Integer> denoms) {
		List<List<Integer>> results = new ArrayList<>();
		
		for (int i=0; i < denoms.size(); i++) {
			Integer coin = denoms.get(i).intValue();
			int remain = amount - coin;
			if (remain >= 0) {
				List<Integer> progress = new ArrayList<Integer>();
				progress.add(coin);
				helper(remain, splice(denoms, coin), progress, results);
			}
		}
		return results;
	}
	
	private static void helper(int amount, List<Integer> denoms, List<Integer> progress, List<List<Integer>> results) {
		System.out.println("Helper: " + amount + " " + denoms + " " + progress);
		if (amount == 0) {
			results.add(progress);
			return;
		}
		
		for (int i=0; i < denoms.size(); i++) {
			int coin = denoms.get(i).intValue();
			int remain = amount - coin;
			if (remain >= 0) {
				List<Integer> newProgress = new ArrayList<>(progress);
				newProgress.add(coin);
				helper(remain, splice(denoms, coin), newProgress, results);
			}
		}
	}
	
	private static List<Integer> splice(List<Integer> list, int value) {
		List<Integer> result = new ArrayList<>(list);
		Set<Integer> setToRemove = new HashSet<>();
		for (int i=0; i < list.size(); i++) {
			if (list.get(i).intValue() > value) {
				setToRemove.add(list.get(i));
			}
		}
		if (!setToRemove.isEmpty()) {
			result.removeAll(setToRemove);
		}
		return result;
	}
	
	public static List<List<Integer>> makingChange1(int amount, List<Integer> denoms) {
		List<List<Integer>> results = new ArrayList<>();
		
		for (int i=0; i < denoms.size(); i++) {
			Integer coin = denoms.get(i).intValue();
			int remain = amount - coin;
			if (remain >= 0) {
				List<Integer> progress = new ArrayList<Integer>();
				progress.add(coin);
				helper(remain, splice(denoms, coin), progress, results);
			}
		}
		return results;
	}
}
