import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int n = nums.length;
        int ans = nums[0] + nums[1] + nums[n - 1];
        int MIN = nums[0] + nums[1] + nums[2], MAX = nums[n - 3] + nums[n - 2] + nums[n - 1];
        if (target > MAX) {
            return MAX;
        }
        if (target < MIN) {
            return MIN;
        }

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1, r = n - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                ans = Math.abs(target - sum) < Math.abs(target - ans) ? sum : ans;
                if (sum > target) {
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    r--;
                } else if (sum < target) {
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    l++;
                }
                if (sum == target) {
                    return sum;
                }
            }
        }
        return ans;
    }
}
