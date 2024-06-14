class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][];
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        Stack<Integer> pq1 = new Stack<>();
        Stack<Integer> pq2 = new Stack<>();
        for(int[] arr : intervals)
        {
           if(pq1.isEmpty()&& pq2.isEmpty())
           {
           pq1.add(arr[0]);
           pq2.add(arr[1]);
           System.out.println("in empty");
           continue;
           }
           System.out.println("pq2.peek() = "+pq2.peek()+" arr[0] = "+arr[0]);
           if(pq2.peek()>=arr[0])
           {
            System.out.println("in change");
            int x = pq2.pop();
            int y = Math.max(x,arr[1]);
            pq2.add(y);
           }
           else
           {
            System.out.println("in adding ");
            pq1.add(arr[0]);
            pq2.add(arr[1]);
           }
        }
        ArrayList<int[]> al = new ArrayList<>();
        while (!pq1.isEmpty() && !pq2.isEmpty()) {
            int f = pq1.pop();
            int s = pq2.pop();
            al.add(new int[]{f, s});
        }
        System.out.println(al);
        int[][] result = new int[al.size()][2];
        for (int i = 0; i < al.size(); i++) {
            result[i] = al.get(i);
        }
        return result;
    }
}