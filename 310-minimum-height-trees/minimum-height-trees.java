class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer>  ans = new ArrayList<>();
        if(n==1){
             ans.add(0);
             return ans;

        } 

        List<List<Integer>> adj= new ArrayList<>();
        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int[] deg = new int[n];
        
        for(int[] e : edges){
            deg[e[0]]++;
            deg[e[1]]++;
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);    
        }
        Queue<Integer> leaves = new LinkedList<>();
        for(int i =0;i<n;i++){
           if(deg[i]==1) leaves.offer(i);
        }
        while(n>2){
            int size = leaves.size();
            n-=size; //we are removeing this because thre leaves nodes cant be  root
            for(int i =0;i<size;i++){
                int leaf= leaves.poll();
                for(int nei : adj.get(leaf)){
                    if(--deg[nei]==1) leaves.offer(nei);
                }
            }
        }
        ans.addAll(leaves);
        return ans;
         


    }
}