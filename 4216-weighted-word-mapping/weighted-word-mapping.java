class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder res = new StringBuilder();
        for(String word: words) {
            int sum = 0;
            for(char ch : word.toCharArray()) {
                sum += weights[(int)ch - 'a'];
            }
            res.append((char)((int)'z' - sum % 26)) ;
        }
        return res.toString();
    }
}