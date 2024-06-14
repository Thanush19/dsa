class Solution 
{
    public String countAndSay(int n) 
    {
        String digitString = "1";
        if(n == 1)   
        {
            return digitString;
        }
        for(int i = 1; i < n; i ++)
        {
            String temp = digitString;   
            digitString = "";
            int j = 0; 
            char prevDigit = temp.charAt(0);
            int freq = 1;
            int len = temp.length();
            while(j < len)
            {
                prevDigit = temp.charAt(j);
                freq = 0;
                while((j < len) && (temp.charAt(j) == prevDigit))
                {
                    freq ++;
                    j ++;
                }
                digitString = digitString + (freq) + prevDigit;
            }
        }
        return digitString;
        
    }
}