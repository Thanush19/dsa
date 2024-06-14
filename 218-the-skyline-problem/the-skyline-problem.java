class BuildingPoint implements Comparable<BuildingPoint>{
    int x;
    boolean isStart;
    int height;
    
    @Override
    public int compareTo(BuildingPoint o){
        if(this.x != o.x) return this.x - o.x;
        else return (this.isStart ? -this.height : this.height) - (o.isStart ? -o.height : o.height);
    }
}

class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        BuildingPoint[] bP = new BuildingPoint[buildings.length*2];
        int index = 0;
        
        for(int building[] : buildings){
            bP[index] = new BuildingPoint();
            bP[index].x = building[0];
            bP[index].isStart = true;
            bP[index].height = building[2];
            
            bP[index+1] = new BuildingPoint();
            bP[index+1].x = building[1];
            bP[index+1].isStart = false;
            bP[index+1].height = building[2];
            index+=2;
        }
        
        Arrays.sort(bP);
        
        TreeMap<Integer,Integer> queue = new TreeMap<>();
        queue.put(0,1);
        int pMaxHeight = 0;
        List<List<Integer>> ans = new ArrayList<>();
        
        for(BuildingPoint buildingPoint : bP){
            if(buildingPoint.isStart){
                queue.compute(buildingPoint.height,(key,value) -> {
                    if(value!=null){
                        return value+1;
                    }
                    return 1;
                });
            }
            else{
                queue.compute(buildingPoint.height,(key,value) -> {
                    if(value == 1){
                        return null;
                    }
                    return value-1;
                });
            }
            
            int cMaxHeight = queue.lastKey();

            if(pMaxHeight != cMaxHeight){
                List<Integer> list = new ArrayList<>();
                list.add(buildingPoint.x);
                list.add(cMaxHeight);
                pMaxHeight = cMaxHeight;
                ans.add(list);
            }
            
        }
        return ans;
    }
}