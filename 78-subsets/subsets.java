class Solution {
    public List<List<Integer>> subsets(int[] a) {
         List<List<Integer>> ans = new ArrayList<>();
         fn(ans,a,0,new ArrayList<>());
         return ans; 
    }
    void fn(List<List<Integer>> ans, int[] a , int idx , List<Integer> temp){
        ans.add(new ArrayList<>(temp));
        for(int i = idx;i<a.length; i++){
            temp.add(a[i]);
            fn(ans,a, i+1,temp);
            temp.remove(temp.size()-1);

        }
    }
}