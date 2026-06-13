class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        String res = "";
        for(String word: words) {
            int sum = 0;
            for(char ch : word.toCharArray()) {
                sum += weights[(int)ch - 'a'];
            }
            res += (char)((int)'z' - sum % 26) ;
        }
        return res;
    }
}