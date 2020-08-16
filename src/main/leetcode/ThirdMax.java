package main.leetcode;

public class ThirdMax {
    public int thirdMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int thirdMax = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                thirdMax = secondMax;
                secondMax = max;
                max = nums[i];

            } else if (nums[i] > secondMax && nums[i] < max) {
                thirdMax = secondMax;
                secondMax = nums[i];
            } else if (nums[i] > thirdMax && nums[i] < secondMax) {
                thirdMax = nums[i];
            }
        }
        if (thirdMax == Integer.MIN_VALUE) {
            return max;

        } else {
            return thirdMax;
        }
    }

    public static void main(String[] args) {
        ThirdMax s = new ThirdMax();
        int[] nums = {1,1,3};
        System.out.print(s.thirdMax(nums));
    }
}
