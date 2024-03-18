class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)->Integer.compare(a[1],b[1]));
        int cnt=1;
        int prev = points[0][1];
        for(int i =0;i<points.length;i++){
            if(points[i][0]>prev){
                prev= points[i][1];
                cnt++;
            }
        }
        return cnt;
    }
}