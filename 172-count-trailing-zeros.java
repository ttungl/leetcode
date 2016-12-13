// https://leetcode.com/problems/factorial-trailing-zeroes/
// A trailing zero is always produced by prime factors 2 and 5.
// number of 2s in prime factors is always more than or equal to the number of 5s.
// Thus, only count 5s.
// Trailing 0s in n! = Count of 5s in prime factors of n!
//                   = floor(n/5) + floor(n/25) + floor(n/125) + ....


public class Solution {
    public int trailingZeroes(int n) {
        int counter = 0;
        // base case: check n
        if (n<0) return -1;
        // Keep dividing n by powers of 5 and update counter
        for (long i=5; n/i>=1; i*=5){
            counter += n/i;
        }
        // return 
        return counter;
    }
}
