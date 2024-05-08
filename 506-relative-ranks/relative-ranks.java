class Solution {
    class Pair{
        int score , idx;
        Pair(int score , int idx){
            this.score=score;
            this.idx=idx;
        }
    }
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->b.score-a.score);
        for(int i = 0 ; i<score.length;i++){
            pq.offer(new Pair(score[i],i));
        }
        String[] ans = new String[score.length];
        int n=1;
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int s=p.score;
            int i= p.idx;
            if(n==1){
                ans[i]="Gold Medal";
            }
            else if(n==2){
                ans[i]="Silver Medal";
            }
            else if(n==3){
                ans[i]="Bronze Medal";
            }
            else{
                ans[i]= Integer.toString(n);
            }
            n++;
        }
        return ans;

        
    }
}