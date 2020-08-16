package main.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public int romanToInt(String s) {
        Map<Character,Integer> table = new HashMap<>();
        table.put('I',1);
        table.put('V',5);
        table.put('X',10);
        table.put('L',50);
        table.put('C',100);
        table.put('D',500);
        table.put('M',1000);
        table.put('Z',0);

        int sum = 0;
        for(int i=0;i<s.length();i++){
            char current = s.charAt(i);
            char next = (i + 1 !=s.length())?s.charAt(i+1):'Z';
            Integer currDigit = table.get(current);
            Integer nextDigit = table.get(next);
            if(currDigit<nextDigit){
                sum = sum + nextDigit - currDigit;
                i = i+1;
            }
            else{
                sum = sum + currDigit;
            }

        }
        return sum;
    }
}
