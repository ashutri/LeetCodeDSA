class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] cnt = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(cnt, 1);
        int maxCount = 1;
        for(int i = 0;i<n;i++){
            for(int prev = 0;prev<i;prev++){
                if(nums[prev] < nums[i] && 1 + dp[prev] > dp[i]){
                    dp[i] = 1 + dp[prev];
                    cnt[i] = cnt[prev];
                } else if(nums[prev] < nums[i] && 1 + dp[prev] == dp[i]){
                    cnt[i] += cnt[prev];
                }
            }
            maxCount = Math.max(maxCount, dp[i]);
        }
        int res = 0;
        for(int i = 0;i<n;i++){
            if(dp[i] == maxCount) res += cnt[i];
        }
        return res;
    }
}