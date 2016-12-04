// https://leetcode.com/problems/valid-number/
// #65
// Note: trim() is used to return a copy of the string \
//       without leading and trailing whitespaces.

public class Solution {
    public boolean isNumber(String s) {
        // check isEmpty
        if(s==null) return false;
        // method 1: use regex analysis (picked).
        // method 2: use substring/(charAt() and isDigit()) to analyze each element in string s. (optional)
        
        String regex = "[-+]?(\\d+\\.?|\\.\\d+)\\d*(e[-+]?\\d+)?";
        
        if (s.trim().matches(regex)){
            return true;
        } else {
            return false;
        }
    }
}