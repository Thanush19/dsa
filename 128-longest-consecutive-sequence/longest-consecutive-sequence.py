class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        st = set(nums)
        maxi=0
        for x in st:
            cnt=0;
            if(x-1 not in st):
                cnt+=1
                p=x
                while(p+1 in st):
                    cnt+=1
                    p=p+1
            maxi = max(cnt,maxi)
        return maxi



        