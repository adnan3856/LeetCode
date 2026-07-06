class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String word = String.valueOf(ch);

            while(!map.containsKey(word)) {
               map.put(word, new ArrayList<>()); 
            }
            map.get(word).add(str);
        }
        return new ArrayList<>(map.values());
    }
}