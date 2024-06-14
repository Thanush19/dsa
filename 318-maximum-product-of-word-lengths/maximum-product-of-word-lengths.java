class Solution {
    public int maxProduct(String[] words) {
        int[] arr = new int[words.length];
        int max = 0;

        for(int i = 0; i < words.length; i++){
            int sum = 0;
            HashSet<Character> hs = new HashSet<>();

            for(int j = 0; j < words[i].length(); j++){
                if(!hs.contains(words[i].charAt(j))){
                    sum += (int)Math.pow(2, words[i].charAt(j)-'a'+1);
                    hs.add(words[i].charAt(j));
                }
            }

            arr[i] = sum;
        }

        for(int i = 0; i < arr.length; i++)
            for(int j = 0; j < arr.length; j++){
                if(i == j)
                    continue;
                
                if(arr[i]+arr[j] == (arr[i]|arr[j]))
                    max = Math.max(words[i].length()*words[j].length(), max);
            }

        return max;
    }
}
// UP-VOTE IF HELPFUL