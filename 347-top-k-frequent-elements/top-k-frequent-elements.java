class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        return Arrays.stream(nums)
                .boxed()
                // Step 1: Group and count frequencies
                .collect(Collectors.groupingBy(
                        Function.identity(), 
                        Collectors.counting()
                ))
                // Step 2: Stream the map entries
                .entrySet()
                .stream()
                // Step 3: Sort by frequency in descending order
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                // Step 4: Keep only the top K entries
                .limit(k)
                // Step 5: Unbox the key (Integer) back to a primitive int
                .mapToInt(Map.Entry::getKey)
                // Step 6: Collect elements into a primitive int[] array
                .toArray();
                     
    }
}
