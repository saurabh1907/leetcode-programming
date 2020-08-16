package main.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty())
            return 0;
        Map<Character, Integer> hash = new HashMap<>();
        int length = 0;
        int maxLength = Integer.MIN_VALUE;
        char[] chars = s.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(hash.containsKey(chars[i])){
                length = Math.min(i-hash.get(chars[i]),length+1);
            } else{
                length++;
            }
            if(length > maxLength)
                maxLength = length;

            hash.put(chars[i],i);
        }
        return maxLength;
    }
}
