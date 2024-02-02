class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        ArrayList<Integer> list=new ArrayList<>();
        String st="123456789";

        for(int i=0;i<9;i++){
            for(int j=i+1;j<=9;j++){
                int val =Integer.parseInt(st.substring(i,j));
                if(val>=low && val<=high){
                    list.add(val);
                    // break;
                }
            }
        }
        Collections.sort(list);
        return list;
        
    }
}