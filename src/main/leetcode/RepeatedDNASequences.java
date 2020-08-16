package main.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Boolean> hash = new HashMap<>();
        List<String> out = new ArrayList<>();
        for(int i=0;i+10<=s.length();i++){
            String curr = s.substring(i,i+10);
            if(hash.containsKey(curr)){
                if(hash.get(curr)==false){
                    out.add(curr);
                    hash.put(curr, true);
                }
            }
            else{
                hash.put(curr, false);
            }
        }
        return out;
    }
}
