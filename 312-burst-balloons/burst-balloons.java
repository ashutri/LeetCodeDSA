class Solution {
    public int f(int i, int j, int[] arr, int[][] dp){
        if(i>j) return 0;
        int maxCoins = Integer.MIN_VALUE;
        if(dp[i][j] != -1) return dp[i][j];
        for(int ind = i;ind<=j;ind++){
            int coins = arr[i-1]*arr[ind]*arr[j+1] + f(i, ind-1, arr, dp) + f(ind+1, j, arr, dp);
            maxCoins = Math.max(maxCoins, coins);
        }
        return dp[i][j] = maxCoins;
    }
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] numsNew  = new int[n+2];
        numsNew[0] = 1;
        numsNew[numsNew.length-1] = 1;
        System.arraycopy(nums, 0, numsNew, 1, n);
        int s = numsNew.length;
        int[][] dp = new int[s][s];
        for(int[] row:dp){
            Arrays.fill(row, -1);
        }
        return f(1, n, numsNew, dp);
    }
}