class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs) {
            char[] word = str.toCharArray();
            Arrays.sort(word);
            String sortedWord = String.valueOf(word);
            if(!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            }
             map.get(sortedWord).add(str);
        }
        return new ArrayList<>(map.values());
    }
}