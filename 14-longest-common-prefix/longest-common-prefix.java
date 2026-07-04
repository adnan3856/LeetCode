class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs); // lexographical sort
        StringBuilder sb = new StringBuilder();
        String firstWord = strs[0];
        String lastWord = strs[strs.length - 1];

        for(int i=0; i< (firstWord.length() < lastWord.length() ? firstWord : lastWord).length(); i++) {
           if(firstWord.charAt(i) == lastWord.charAt(i)) {
                sb.append(firstWord.charAt(i));
           }
           else {
            break;
           }
        }
        return sb.toString();
    }
}