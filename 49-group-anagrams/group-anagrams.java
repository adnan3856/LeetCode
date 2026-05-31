class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       Map<String, List<String>> map = new HashMap<>();

       for(String str: strs) {
            char[] words = str.toCharArray();
            Arrays.sort(words);
            String sorted = String.valueOf(words);

            if(!map.containsKey(sorted))
                map.put(sorted, new ArrayList<>());
            
            map.get(sorted).add(str);
       }

       return new ArrayList<>(map.values());
    }
}