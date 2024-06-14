import java.util.*;

class Solution {

    // very complicated to solve directly => guess using binary search !!!
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int l = 0;
        int r = Math.max(heaters[heaters.length - 1], houses[houses.length - 1] - houses[0]);
        int min = r;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            int heaterId = 0;
            int houseId = 0;
            for (; houseId < houses.length && heaterId < heaters.length; houseId++) {
                if (houses[houseId] < heaters[heaterId] - mid) break;
                if (houses[houseId] > heaters[heaterId] + mid) {
                    heaterId++;
                    houseId--;
                }
            }

            if (houseId == houses.length) {
                min = Math.min(mid, min);
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return min;
    }

}