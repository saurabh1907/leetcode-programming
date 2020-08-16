package main.leetcode;

public class ReverseInteger {
    public int reverse(int x) {
        Boolean isNegative = x<0?true:false;
        if(isNegative)
            x = x * -1;
        //String noDigits = String.parseInt(x).length();
        long answer = 0;
        while(x>0){
            int last = x % 10;
            answer = answer * 10 + last;
            if(answer>2147483648L)
                return 0;
            x = x / 10;
        }
        int answerint = (int) answer;
        return isNegative? answerint * -1: answerint;
    }
}
