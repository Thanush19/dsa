class Solution {
    class Pair{
        int h ;
        String na;
        Pair(int o , String p){
            h=o;
            na=p;
        }
    }
    public String[] sortPeople(String[] n, int[] h) {
        int len = n.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->b.h-a.h);
        for(int i =0;i<len;i++){
            pq.offer(new Pair(h[i],n[i]));
        }
        String[] ans = new String[len];
        int i =0;
        while(i<len){
            Pair p =pq.poll();
            String temp = p.na;
            ans[i++]=temp;
        }
        return ans;
        
    }
}