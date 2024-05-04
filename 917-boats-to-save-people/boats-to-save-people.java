import java.util.Arrays;

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length - 1;
        int ans = 0;
        while (i <= j) {
            int sum = people[i] + people[j];
            if (sum <= limit) {
                ans++;
                i++;
                j--; // Decrement j instead of incrementing it
            } else { // If sum is greater than the limit
                ans++; // Increment ans only once
                j--; // Decrement j to reduce the sum
            }
        }
        return ans;
    }
}
