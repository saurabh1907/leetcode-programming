package main.leetcode;

public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int K) {
        quickSelect(points, 0 , points.length - 1, K);
        int[][] answer = new int[K][2];
        int temp = 0;
        while(temp<K){
            answer[temp] = points[temp];
            temp++;
        }
        return answer;
    }

    public void quickSelect(int[][] points, int start, int end, int K){
        if(start>=end){
            return;
        }
        int pivotIndex = end;
        int[] pivot = points[pivotIndex];
        int i = start;
        int j = end;
        while(i<j){
            while(i<=end && getValue(points[i])<getValue(pivot)){
                i++;
            }
            while(j>=0 && getValue(points[j])>=getValue(pivot)){
                j--;
            }
            if(i<j){
                swap(points, i, j);
            }
        }
        swap(points, pivotIndex, i);
        if(i < K)
            quickSelect(points, i + 1, end, K);
        else if(i > K)
            quickSelect(points, start, i - 1, K);
        else
            return;
    }

    private double getValue(int[] point){
        return Math.sqrt(point[0] * point[0] + point[1]* point[1]);
    }

    private void swap(int[][] points, int i, int j){
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }
}
