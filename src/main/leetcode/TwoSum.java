package main.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> myMap = new HashMap();
        for(int i=0;i<nums.length;i++){
            myMap.put(nums[i],-1);
        }

        for(int i=0;i<nums.length;i++){
            if(myMap.get(nums[i])==-1)
                myMap.put(nums[i], i);
            int secondNum = target - nums[i];
            if(myMap.containsKey(secondNum) && myMap.get(secondNum)>-1 &&               myMap.get(secondNum)!=i){
                return new int[]{i,myMap.get(target - nums[i])};
            }
        }
        return new int[0];
    }
}
