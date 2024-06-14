class Solution {
    public List<Integer> grayCode(int n) {
        // if(n==0)return new ArrayList<>();
        List<Integer> crnt=new ArrayList<>(Arrays.asList(0,1));
        if(n==1)return crnt;
        crnt=grayCode(n-1);
        List<Integer> ret=new ArrayList<>();
        int add=(int)Math.pow(2,n-1);
        for(int i=crnt.size()-1;i>-1;i--){
            crnt.add(crnt.get(i)+add); 
        }
        return crnt;        
    }
}