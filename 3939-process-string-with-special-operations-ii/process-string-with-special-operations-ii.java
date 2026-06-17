class Solution {
    public char processStr(String s, long k) {
        long len = 0;

        for(char ch : s.toCharArray()) {
            // Step 1: finding the expected length of string
           if(Character.isLowerCase(ch)) {
                len++;
            } else if(ch =='*') {
                if(len>0) len--;
            } else if(ch =='#') {
                len*=2;
            }
            // for '*' it just reverses, so length remains the same
        }

        if(k >= len) return '.';

        for(int i = s.length() - 1; i>= 0; i--) {
            char ch = s.charAt(i);
            if(Character.isLowerCase(ch)){
                if(k == len-1)
                    return ch;
                len--;
            }
            else if(ch == '*') { // Reverse of deletion, so increase len by 1.
                len++;
            }
            else if(ch == '#') { // Before duplication, length was len / 2. Map k back using k %= len.
                len /= 2; 
                k %= len;
            }
            else if(ch == '%') { // Reverse the index mapping using k = len - 1 - k
                k = len - 1 - k;
            }
        }
        return '.';
    }
}