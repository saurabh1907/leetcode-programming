package main.leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>();
        for(String word: wordDict){
            wordSet.add(word);
        }
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int len=1;len<=s.length();len++){
            int a = 1;
            for(int i=0;i<=len;i++){
                if(dp[len] == false){
                    String candidate = s.substring(i, len);
                    if(dp[i] == true && wordSet.contains(candidate)){
                        dp[len] = true;
                        break;
                    }
                }
            }
        }

        return dp[s.length()];
    }
}
