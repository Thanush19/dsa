class NumArray {

    int[] segment;
    int n;
    public NumArray(int[] nums) {
        n = nums.length;
        segment = new int[4*n];
        createSegmentTree(nums, 0, 0, n-1);
    }

    private int createSegmentTree(int[] nums, int idx, int start, int end) {
        if(start == end) {
            segment[idx] = nums[start];
        } else{
            int mid = start + (end-start)/2;
            segment[idx] = createSegmentTree(nums, 2*idx+1, start, mid) + createSegmentTree(nums, 2*idx+2, mid+1, end);
        }

        return segment[idx];
    }

    public void update(int index, int val) {
        updateUtil(0, 0, n-1, index, val);
    }

    private int updateUtil(int idx, int start, int end, int updateIdx, int val) {
        if(start==end && start==updateIdx) {
            segment[idx] = val;
        } else if(start<=updateIdx && end>=updateIdx) {
            int mid = start + (end-start)/2;
            segment[idx] = updateUtil(2*idx+1, start, mid, updateIdx, val) + updateUtil(2*idx+2, mid+1, end, updateIdx, val);
        }

        return segment[idx];
    }

    public int sumRange(int left, int right) {
        return getSumRange(0, left, right, 0, n-1);
    }

    private int getSumRange(int idx, int left, int right, int treeStart, int treeEnd) {
        if(left>treeEnd || right<treeStart) {
            return 0;
        } else if(left<=treeStart && right>=treeEnd) {
            return segment[idx];
        } else {
            int mid = treeStart + (treeEnd - treeStart)/2;
            return getSumRange(2*idx+1, left, right, treeStart, mid) + getSumRange(2*idx+2, left, right, mid+1, treeEnd);
        }
    }
}