class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] a) {
        List<List<Integer>> ans = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
            ans.add(new ArrayList<>());
        }
        for(int i =0;i<a.length;i++){
            adj.get(a[i][1]).add(a[i][0]);
            //child ---> par
        }
        for(int i =0;i<n;i++){
            List<Integer> par = new ArrayList<>();
            fn(par,adj,i , new boolean[n]);
            Collections.sort(par);
            ans.set(i,par);
        }

        return ans;  
    }

    void fn(List<Integer> ans ,List<List<Integer>> adj,int child , boolean[] vis){
        if(vis[child]) return ;
        vis[child]=true;

        for(int par : adj.get(child)){
            if(!ans.contains(par)){
                ans.add(par);
                fn(ans,adj,par,vis);
            }
        }

    }
}