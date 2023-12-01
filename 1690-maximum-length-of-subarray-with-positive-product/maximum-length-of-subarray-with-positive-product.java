import java.util.*;
class Solution {
    public int getMaxLen(int[] nums) {
        int n = nums.length;
        int positiveLen = nums[0] > 0 ? 1 : 0;
        int negativeLen = nums[0] < 0 ? 1 : 0;
        int maxLength = positiveLen;

        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) {
                positiveLen++;
                if (negativeLen > 0) negativeLen++;
            } else if (nums[i] < 0) {
                int temp = positiveLen;
                positiveLen = negativeLen > 0 ? negativeLen + 1 : 0;
                negativeLen = temp + 1;
            } else {
                positiveLen = 0;
                negativeLen = 0;
            }

            maxLength = Math.max(maxLength, positiveLen);
        }

        return maxLength;
    }
}