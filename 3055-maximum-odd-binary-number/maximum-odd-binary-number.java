class Solution {
    public String maximumOddBinaryNumber(String s) {
     char[] ch=s.toCharArray();
    Arrays.sort(ch);
    return new StringBuilder("1"+(new String(ch)).substring(0, s.length()-1)).reverse().toString();
        }
    
    
}