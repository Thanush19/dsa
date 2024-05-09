class Solution {
    public List<List<Integer>> permute(int[] a) {
        List<List<Integer>> ans = new ArrayList<>();
        fn(a,ans,new ArrayList<>(), a.length);
        return ans;
    }
    void fn(int[] a, List<List<Integer>> ans , List<Integer> temp,int n ){
        if(temp.size()==n){
            ans.add(new ArrayList<>(temp));
        }
        else{
            for(int i = 0 ;i<n;i++){
                if(temp.contains(a[i])) continue;
                temp.add(a[i]);
                fn(a, ans , temp,n);
                temp.remove(temp.size()-1);


            }

        }
    }
}