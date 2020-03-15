//Time complexity is O(2n) -> O(n)
//Space complexity is O(1) as only 26 Alphabet characters are there
//This solution is submitted on leetcode

import java.util.HashMap;

public class BigN138TaskSchedulerSolution {
	class Solution {
		public int leastInterval(char[] tasks, int n) {
			// edge case
			if (tasks == null || tasks.length == 0)
				return 0;
			int maxFreq = 0;
			int maxCount = 0;
			HashMap<Character, Integer> map = new HashMap<>();
			for (int i = 0; i < tasks.length; i++) {
				if (!map.containsKey(tasks[i])) {
					map.put(tasks[i], 0);
				}
				int count = map.get(tasks[i]) + 1; 
				map.put(tasks[i], count);
				maxFreq = Math.max(maxFreq, count);
			}
			for (int a : map.values()) {
				if (a == maxFreq)
					maxCount++;
			}
			int partition = maxFreq - 1;
			int emptySpace = (n - (maxCount - 1)) * partition;
			int remainingElementsToBePlaced = tasks.length - (maxFreq * maxCount);
			int idle = Math.max(0, emptySpace - remainingElementsToBePlaced);
			return tasks.length + idle;
		}
	}
}