class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
         freq={}
         for x in nums:
            freq[x]= freq.get(x,0)+1
         for x in nums:
            if(freq[x]>1) :
                return True
         return False
         
        