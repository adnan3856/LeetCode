class Solution {
    public boolean isPowerOfTwo(int n) { // 8
        if(n > 0 && ((n & (n-1)) == 0))    // (8 > 0, i.e., positive and 8 = 1000, 7 = 0111, AND operator of 8 & 7 is 0)
            return true;
        return false;
    }
}