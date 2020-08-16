package main.leetcode;

public class AddBinary {
    public String addBinary(String a, String b) {
        int carry = 0;
        int aLen = a.length();
        int bLen = b.length();
        int lenDiff = aLen - bLen;
        String answer = "";
        int i = Math.max(aLen, bLen);
        for(i= i-1;i>=0;i--){
            int aIter = i,bIter = i;
            if(lenDiff>0){
                aIter = i;
                bIter = i - lenDiff;
            } else if(lenDiff<0){
                aIter = i + lenDiff;
                bIter = i;
            }
            int aDigit = (aIter>=0)?Integer.parseInt(a.substring(aIter,aIter+1)):0;
            int bDigit = (bIter>=0)?Integer.parseInt(b.substring(bIter,bIter+1)):0;
            String ansBit = null;
            if(aDigit + bDigit + carry == 0){
                ansBit = "0";
                carry = 0;
            }
            else if(aDigit + bDigit + carry == 1){
                ansBit = "1";
                carry = 0;
            }
            else if(aDigit + bDigit + carry == 2){
                ansBit = "0";
                carry = 1;
            }
            else {
                ansBit = "1";
                carry = 1;
            }
            answer = ansBit + answer;
        }
        if(carry ==1)
            answer = "1" + answer;

        return answer;
    }
}
