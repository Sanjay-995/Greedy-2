// Time complexity is O(2n) -> O(n)
// Space complexity is O(n)
// This solution is submitted on leetcode

import java.util.Arrays;

public class BigN137MinimumCandy {
	class Solution {
		public int candy(int[] ratings) {
			// edge case
			if (ratings == null || ratings.length == 0)
				return 0;
			int n = ratings.length;
			int[] candies = new int[n];
			Arrays.fill(candies, 1);
			for (int i = 1; i < n; i++) {
				if (ratings[i] > ratings[i - 1]) {
					candies[i] = candies[i - 1] + 1;
				}
			}
			for (int i = n - 2; i >= 0; i--) {
				if (ratings[i] > ratings[i + 1]) {
					candies[i] = Math.max(candies[i], candies[i + 1] + 1);
				}
			}
			int sum = 0;
			for (int el : candies) {
				sum += el;
			}
			return sum;
		}
	}
}