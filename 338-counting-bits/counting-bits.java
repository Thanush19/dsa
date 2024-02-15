class Solution {
    public static int binary(int n)
    {
        int i=0;
        while(n>0)
        {
            if(n%2==1)
            i++;
            n/=2;
        }
        return i;
    }
    public int[] countBits(int n) {
        int[] ans= new int[n+1];
        for(int i=0;i<=n;i++)
        {
            ans[i]=binary(i);
        }
        return ans;
    }
}