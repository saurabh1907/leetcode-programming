package main.leetcode;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int i = 0;
        int j=height.length - 1;
        int max = 0;
        while(i<j){
            int ht = Math.min(height[i],height[j]);
            int width = j - i;
            int capacity = ht * width;
            if(capacity> max)
                max = capacity;
            if(height[i]<height[j])
                i++;
            else
                j--;
        }
        return max;
    }
}
