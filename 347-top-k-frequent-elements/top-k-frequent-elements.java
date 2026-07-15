class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] topKFrequent = new int[k];
      Map<Integer,Integer> countMap = new HashMap<>();
      for(int num : nums){
        countMap.put(num,countMap.getOrDefault(num,0)+1 );
      }
      PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> countMap.get(a) - countMap.get(b));
    
    for(int frequency : countMap.keySet()){
        minHeap.offer(frequency);
        if(minHeap.size()>k){
            minHeap.poll();
        }
    }
    for(int i=k-1; i>=0; i--){
       topKFrequent[i] =  minHeap.poll();
    }
    return topKFrequent;

    }
}