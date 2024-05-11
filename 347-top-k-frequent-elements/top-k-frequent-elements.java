class Solution {
    class Pair{
        int e ,f;
        Pair(int e,int f){
            this.e=e;
            this.f=f;
        }
    }
    public int[] topKFrequent(int[] a, int k) {

        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i : a){
            mp.put(i,mp.getOrDefault(i,0)+1);
        }
        int[] ans = new int[k];
        PriorityQueue<Pair> pq  = new PriorityQueue<>((x,y)->y.f-x.f);
        for(Map.Entry<Integer,Integer>  i : mp.entrySet()){
            pq.offer(new Pair(i.getKey(),i.getValue()));
        }
        int i =0;
        while(k-- >0){
            Pair p = pq.poll();
            ans[i++]=p.e;
        }
        return ans;
        
    }
}