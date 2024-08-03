class Solution {
    public boolean canBeEqual(int[] t, int[] a) {
        Arrays.sort(a);
        Arrays.sort(t);
        return Arrays.equals(a,t);
        
    }
}