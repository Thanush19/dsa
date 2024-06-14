class SummaryRanges {
    TreeSet<int[]> set;
    public SummaryRanges() {
        set  = new TreeSet<int[]>((a, b) -> (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0]);
    }
    
    public void addNum(int value) {
        int[] m = new int[]{value, value};
        if(set.contains(m)){
            return;
        }
        int[] heigh = set.higher(m), low = set.lower(m);
        if(heigh != null && heigh[0] == value + 1 && low != null && low[1] == value - 1){
            // [1, 1], [3, 3]. inseted [2, 2]
            heigh[0] = low[0];
            set.remove(low);
        }else if(heigh != null && heigh[0] == value + 1){
            // [3, 3] insert [2, 2]
            heigh[0] = value;
        }else if(low != null && low[1] == value - 1){
            // [1, 1] insert [2, 2]
            low[1] = value;
        }else if((heigh != null && heigh[0] == value) || (low != null && low[0] <= value && low[1] >= value)){
            // [2, 3] insert [2, 2]
            // [1, 3] insert [2, 2]
            return;
        }else{
            set.add(m);
        }
    } 
    
    public int[][] getIntervals(){
        List<int[]> res = new ArrayList<>();
        for(int[] s: set){
            res.add(s);
        }
        return res.toArray(new int[0][]);
    }
}