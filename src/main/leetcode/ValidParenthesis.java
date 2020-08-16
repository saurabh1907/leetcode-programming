package main.leetcode;

import java.util.Stack;

public class ValidParenthesis {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        try{
            for(Character ch : s.toCharArray()){
                if(isOpening(ch)){
                    stack.push(ch);
                }
                else{
                    Character top = stack.pop();
                    if(getOpposite(top)!=ch){
                        return false;
                    }
                }
            }
            return stack.empty();
        } catch(Exception e){
            return false;
        }
    }

    boolean isOpening(Character ch){
        if (ch =='{'||ch =='('|| ch =='[')
            return true;
        return false;
    }

    Character getOpposite(Character ch){
        switch(ch){
            case '(': return ')';
            case '{': return '}';
            case '[': return ']';
            default: return null;
        }
    }
}
