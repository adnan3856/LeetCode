class Solution {
    public boolean isHappy(int n) {
        
        Set<Integer> set = new HashSet<>();
        while(set.add(n)){
            if(n == 1)
                return true;
            n = square(n);
        }
        return false;
    }
    
    public int square(int n){
        int sum = 0;
        while(n > 0){
            int rem = n%10;
            sum += rem*rem;
            n /= 10;   
        }
        return sum;
    }
}