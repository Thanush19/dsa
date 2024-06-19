class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int s = 0, e = (int)1e9;
        int ans = -1;

        while (s <= e) {
            int mid = s + (e - s) / 2;
            int con = 0, buk = 0;

            for (int i = 0; i < bloomDay.length; i++) {
                if (bloomDay[i] <= mid) {
                    con++;
                    if (con >= k) {
                        buk++;
                        con = 0;
                    }
                } else {
                    con = 0;
                }
            }

            if (buk >= m) {
                ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return ans;
    }
}