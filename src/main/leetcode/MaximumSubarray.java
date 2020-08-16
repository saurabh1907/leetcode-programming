package main.leetcode;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
    int maxSoFar = 0;
    int maxTillLast = 0;
    int largestNonPositive = Integer.MIN_VALUE;
    for(int i=0;i<nums.length;i++){
    if(nums[i]<=0 && largestNonPositive<nums[i])
    largestNonPositive = nums[i];
    maxTillLast += nums[i];
    if(maxTillLast<0)
    maxTillLast = 0;
    if(maxSoFar<maxTillLast)
    maxSoFar = maxTillLast;
    }
    maxSoFar = maxSoFar>0? maxSoFar:largestNonPositive;
        return maxSoFar;
    }
}