// https://leetcode.com/problems/wildcard-matching/

public class Solution {
    public boolean isMatch(String s, String p){

    	// init params
    	int slen=s.length()+1, plen=p.length()+1;
    	int i=1, j=1, sMarkIdx=0, asterMark=0; 

    	// Check two strings, if asterisk "*" is detected in p,
    	// mark both indices of strings s and p at the
    	// current positions. Then, try to match the 
    	// other part of string p from asterisk position.
    	while(i<slen){
    		if (j<plen && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))){
    			i++;
    			j++;
    		} else if(j<plen && p.charAt(j)=='*'){
    			asterMark = j;
    			j++;
    			sMarkIdx = i;
    		} else if(asterMark !=-1){
    			j=asterMark +1;
    			// i++; // incorrect
    			i=sMarkIdx++;
    		} else {
    			return false;
    		}
    	}
    	// check if one or more asterisks in string p, 
    	// treat the same.
    	while(j<plen && p.charAt(j)=='*'){
    		j++;
    	}
    	return (j==plen);
    }
}