package main.leetcode;

public class RemoveDuplicatesFromSortedArray2 {
    public int removeDuplicates(int[] nums) {
        int ptr = 0;
        int count = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i] != nums[i-1]){
                count =1;
                ptr++;
            } else if (nums[i]==nums[i-1] && count <2){
                count++;
                ptr++;
            }
            nums[ptr] = nums[i];
        }
        return ptr+1;
    }
}
