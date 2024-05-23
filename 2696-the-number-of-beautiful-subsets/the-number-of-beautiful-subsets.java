class Solution {
     int ans =0;
    void fn(int[] a , int k , int idx ,boolean[] vis){
        if(idx==a.length){
            ans++;
            return;
        } 
        fn(a,k,idx+1,vis);

        
         boolean canPick = true;
        for (int i = 0; i < idx; i++) {
            if (vis[i] && Math.abs(a[idx] - a[i]) == k) {
                canPick = false;
                break;
            }
        }
        
        if (canPick) {
            vis[idx] = true;
            fn(a, k, idx + 1, vis);
            vis[idx] = false;
        }

    }

    public int beautifulSubsets(int[] a, int k) {
        if(a.length==1) return 1;
        Arrays.sort(a);
        boolean[] vis = new boolean[a.length];
        fn(a,k,0,vis);
        return ans-1;


        
        
    }
}