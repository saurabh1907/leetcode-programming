package main.leetcode;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        long reverse = 0;
        for(int i=x;i>0;i=i/10){
            int current = i%10;
            reverse = reverse * 10 + current;
        }
        long temp = 2147483647L;
        if(reverse> temp)
            return false;
        if(x==(int)reverse)
            return true;
        return false;
    }
}
