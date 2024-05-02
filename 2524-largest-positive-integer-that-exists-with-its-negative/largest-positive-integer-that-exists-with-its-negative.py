from typing import List

class Solution:
    def findMaxK(self, nums: List[int]) -> int:
        st = set()
        for x in nums:
            if x < 0:
                st.add(x)
        
        max_positive = float('-inf')  # Initialize max_positive to negative infinity
        for x in nums:
            if x > 0 and x > max_positive and -x in st:
                max_positive = x
        
        if max_positive == float('-inf'):  # If no suitable positive integer is found, return -1
            return -1
        return max_positive
