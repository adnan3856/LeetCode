class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs) {
            char[] wordChar = str.toCharArray();
            Arrays.sort(wordChar);
            String sortedWord = String.valueOf(wordChar);

            if(!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            }
            map.get(sortedWord).add(str);
        }

        return new ArrayList<>(map.values());
    }
}