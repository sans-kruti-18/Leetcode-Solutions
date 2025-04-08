import java.util.*;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); // Sort to handle duplicates
        backtrack(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] nums, int index, List<Integer> tempList, List<List<Integer>> res) {
        res.add(new ArrayList<>(tempList));

        for (int i = index; i < nums.length; i++) {
            // Skip duplicates
            if (i > index && nums[i] == nums[i - 1]) continue;
            tempList.add(nums[i]);
            backtrack(nums, i + 1, tempList, res);
            tempList.remove(tempList.size() - 1); // backtrack
        }
    }
}
