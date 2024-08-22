class Solution {
    public int findComplement(int n) {
        String b = Integer.toBinaryString(n);
        char[] ch = b.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char c: ch){
            if(c=='1'){
                c='0';

            }
            else{
                c='1';
            
            }
            sb.append(c);

        }
        return Integer.parseInt(sb.toString(),2);
        
    }
}