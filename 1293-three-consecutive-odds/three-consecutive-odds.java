class Solution {
    public boolean threeConsecutiveOdds(int[] a) {
        int n = a.length;
        boolean flag = false;
      
        for(int i =0;i<n-2;i++){
            if(a[i]%2!=0 && a[i+1]%2!=0 && a[i+2]%2!=0){
                flag=true;
                break;
            } 
        }
        return flag;
        
    }
}