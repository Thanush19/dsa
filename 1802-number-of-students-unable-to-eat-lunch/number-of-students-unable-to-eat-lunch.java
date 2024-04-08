class Solution {
    public int countStudents(int[] st, int[] sand) {
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<sand.length;i++){
            q.add(sand[i]);
        }
        Queue<Integer> q1=new LinkedList<>();
        for(int i=0;i<st.length;i++){
            q1.add(st[i]);
        }
        int count=0;
        while(!q.isEmpty()){
            if(count>st.length){
                break;
            }
            if(q.peek()==q1.peek()){
                q.remove();
                q1.remove();
                count=0;
            }else{
                q1.add(q1.remove());
                count++;
            }
        }
        return q1.size();
    }
}