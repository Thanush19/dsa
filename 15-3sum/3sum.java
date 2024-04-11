class Solution {
    public List<List<Integer>> threeSum(int[] a) {
        int n = a.length;
        int t=0;
        Arrays.sort(a);
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<List<Integer>> s = new HashSet<>();
        for(int i =0;i<n;i++){
            int j = i+1;
            int k = n-1;
            while(j<k){
                int sum = a[i]+a[j]+a[k];
                if(sum==t){
                    s.add(Arrays.asList(a[i],a[j],a[k]));
                    j++;
                    k--;
                }
                else if(sum>t){
                    k--;
                }
                else if(sum<t) j++;
            }
        }
        ans.addAll(s);
        return ans;

        
    }
}