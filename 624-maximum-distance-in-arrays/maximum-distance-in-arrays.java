import java.util.List;

class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int maxDist = 0;
        int minVal = arrays.get(0).get(0);
        int maxVal = arrays.get(0).get(arrays.get(0).size() - 1);
        
        for (int i = 1; i < arrays.size(); i++) {
            int currentMin = arrays.get(i).get(0);
            int currentMax = arrays.get(i).get(arrays.get(i).size() - 1);
            
            // Calculate distance with the previous global min and max
            maxDist = Math.max(maxDist, Math.abs(currentMax - minVal));
            maxDist = Math.max(maxDist, Math.abs(maxVal - currentMin));
            
            // Update global min and max
            minVal = Math.min(minVal, currentMin);
            maxVal = Math.max(maxVal, currentMax);
        }
        
        return maxDist;
    }
}
