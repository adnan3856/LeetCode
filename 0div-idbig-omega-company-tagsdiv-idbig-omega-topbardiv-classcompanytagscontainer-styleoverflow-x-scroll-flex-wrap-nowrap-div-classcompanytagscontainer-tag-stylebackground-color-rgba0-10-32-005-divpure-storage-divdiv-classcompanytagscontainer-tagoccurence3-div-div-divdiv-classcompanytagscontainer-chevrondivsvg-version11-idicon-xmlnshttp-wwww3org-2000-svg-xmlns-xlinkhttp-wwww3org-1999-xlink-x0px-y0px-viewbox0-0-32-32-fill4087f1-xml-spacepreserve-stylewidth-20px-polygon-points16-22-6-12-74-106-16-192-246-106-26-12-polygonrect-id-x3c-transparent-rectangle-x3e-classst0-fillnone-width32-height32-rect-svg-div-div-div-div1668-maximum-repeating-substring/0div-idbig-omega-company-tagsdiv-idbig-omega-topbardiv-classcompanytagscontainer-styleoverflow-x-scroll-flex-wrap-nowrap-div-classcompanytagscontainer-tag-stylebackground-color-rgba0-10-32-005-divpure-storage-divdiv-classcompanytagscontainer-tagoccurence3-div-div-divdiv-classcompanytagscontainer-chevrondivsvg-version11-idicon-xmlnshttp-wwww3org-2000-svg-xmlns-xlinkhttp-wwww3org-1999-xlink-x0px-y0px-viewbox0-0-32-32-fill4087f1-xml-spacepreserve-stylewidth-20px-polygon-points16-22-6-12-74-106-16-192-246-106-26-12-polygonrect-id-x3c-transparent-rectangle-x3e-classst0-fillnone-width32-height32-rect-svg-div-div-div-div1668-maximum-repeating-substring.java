class Solution {
     public int maxRepeating(String sequence, String word) {
        int count=0;
        String add=word;
        while(sequence.contains(word))
        {
            count++;
            word += add;
            System.out.println(word);
        }
        return count;
    }
}