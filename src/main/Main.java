package main;

import main.leetcode.ValidParenthesis;

import java.util.*;



public class Main {

    public static void main(String[] args) {
        // write your code here
        Integer[] arr = {1,1,1,1,3,1,1,3,1,3};
        List<Integer> count = Arrays.asList(arr);
        ValidParenthesis obj = new ValidParenthesis();
        System.out.println(obj.isValid("(())"));
    }

}

