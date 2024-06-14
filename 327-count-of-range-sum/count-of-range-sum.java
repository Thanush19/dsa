class Solution {
class TreeNode {
    long val;
    int count;
    int leftCount;
    int rightCount;
    TreeNode left;
    TreeNode right;

    public TreeNode(long val) {
        this.val = val;
        this.count = 1;
        this.leftCount = 0;
        this.rightCount = 0;
        this.left = null;
        this.right = null;
    }
}

public int countRangeSum(int[] nums, int lower, int upper) {
    int n = nums.length;
    long[] prefixSum = new long[n + 1];
    for (int i = 0; i < n; i++) {
        prefixSum[i + 1] = prefixSum[i] + nums[i];
    }
    return countRangeSumMergeSort(prefixSum, 0, n, lower, upper);
}

private int countRangeSumMergeSort(long[] prefixSum, int start, int end, int lower, int upper) {
    if (start >= end) {
        return 0; // No valid ranges in a single element array
    }

    // Divide the array into two halves and recursively count the range sums
    int mid = (start + end) / 2;
    int count = countRangeSumMergeSort(prefixSum, start, mid, lower, upper) +
                countRangeSumMergeSort(prefixSum, mid + 1, end, lower, upper);

    // Count the number of valid ranges that span across the two halves
    int left = mid + 1;
    int right = mid + 1;
    for (int leftIndex = start; leftIndex <= mid; leftIndex++) {
        while (left <= end && prefixSum[left] - prefixSum[leftIndex] < lower) {
            left++;
        }
        while (right <= end && prefixSum[right] - prefixSum[leftIndex] <= upper) {
            right++;
        }
        count += right - left;
    }

    // Merge the two sorted halves and update the prefix sums array
    long[] sorted = new long[end - start + 1];
    int sortedIndex = 0;
    int leftIndex = start;
    int rightIndex = mid + 1;
    while (leftIndex <= mid && rightIndex <= end) {
        if (prefixSum[leftIndex] <= prefixSum[rightIndex]) {
            sorted[sortedIndex++] = prefixSum[leftIndex++];
        } else {
            sorted[sortedIndex++] = prefixSum[rightIndex++];
        }
    }
    while (leftIndex <= mid) {
        sorted[sortedIndex++] = prefixSum[leftIndex++];
    }
    while (rightIndex <= end) {
        sorted[sortedIndex++] = prefixSum[rightIndex++];
    }
    System.arraycopy(sorted, 0, prefixSum, start, sorted.length);

    return count;
}

}