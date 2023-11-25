class Solution {
    
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] numsNew  = new int[n+2];
        numsNew[0] = 1;
        numsNew[numsNew.length-1] = 1;
        System.arraycopy(nums, 0, numsNew, 1, n);
        int s = numsNew.length;
        int[][] dp = new int[s+1][s+1];
        for(int[] row:dp){
            Arrays.fill(row, 0);
        }
        for(int i = n;i>=1;i--){
            for(int j = 1; j<=n;j++){
                if(i>j) continue; //base case
                int maxCoins = Integer.MIN_VALUE;
                for(int ind = i;ind<=j;ind++){
                    int coins = numsNew[i-1]*numsNew[ind]*numsNew[j+1] + dp[i][ind-1] + dp[ind+1][j];
                    maxCoins = Math.max(maxCoins, coins);
                }
                dp[i][j] = maxCoins;
            }
        }
        return dp[1][n];
    }
}