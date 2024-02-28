class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = max(piles);
        int result = right;

        while (left <= right){
            int mid = left + (right - left) /2;
            int hours = 0;
            for(int p : piles){
                hours += Math.ceil((double) p / mid);
            }
            if(hours <= h){
                result = Math.min(result, mid);
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return result;
    }

    static int max(int[] arr){
        int max = arr[0];
        for(int num : arr){
            if(num > max){
                max = num;
            }
        }
        return max;
    }
}