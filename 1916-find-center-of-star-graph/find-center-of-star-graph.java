class Solution {
    public int findCenter(int[][] a) {
        int n = a.length;
        List<List<Integer>> adj = new ArrayList<>();
        int max = Arrays.stream(a)            // Stream of int[]
                        .flatMapToInt(Arrays::stream)  // Flatten to IntStream
                        .max()                        // Find max value
                        .orElseThrow(); 
        for(int i =0;i<=max;i++){
            adj.add(new ArrayList<>());
        }
        for(int i =0;i<n;i++){
            adj.get(a[i][0]).add(a[i][1]);
            adj.get(a[i][1]).add(a[i][0]);
        }
        int ans=0;
        for(int i =1;i<=max;i++){
            if(adj.get(i).size()==max-1) {
                ans= i;
                break;
            }

        }
        return ans;
       
        
    }
}