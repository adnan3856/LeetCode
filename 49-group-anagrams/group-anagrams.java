class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs) {
            char[] words = str.toCharArray();
            Arrays.sort(words);
            String sortedWord = String.valueOf(words);
            if(!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            }
             map.get(sortedWord).add(str);
        }
        return new ArrayList<>(map.values());

    }
}