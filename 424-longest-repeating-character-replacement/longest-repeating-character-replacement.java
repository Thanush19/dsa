class Solution 
{
  public int characterReplacement(String s, int k) 
  {
      // O(n) time | O(1) space
      int[] counter = new int[26];
      int res = 0;
      
      int left = 0, right = 0;
      int mostFrequentCharCount = 0;
      
      while(right < s.length())
      {
          counter[s.charAt(right) - 'A'] += 1;
          mostFrequentCharCount = Math.max(mostFrequentCharCount, counter[s.charAt(right) - 'A']);
          
          if(right - left + 1 - mostFrequentCharCount > k)
          {
              // current window is invalid if the condition meets so we move left pointer forward
              counter[s.charAt(left) - 'A'] -= 1;
              left++; 
          }
          res = Math.max(res, right - left + 1);
          right++;
      }
      return res;
  }
}