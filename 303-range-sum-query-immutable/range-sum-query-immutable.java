class NumArray {
    public int[] arr2;
    public NumArray(int[] arr) {
        arr2=new int[arr.length+1];
        for(int i=0;i<arr.length;i++){
            arr2[i+1]=arr2[i]+arr[i];
        }
    }
    
    public int sumRange(int l, int r) {
        return arr2[r+1]-arr2[l];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */