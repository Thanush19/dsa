class Solution {
    public int removeDuplicates(int[] nums) {
      int idx=1; //index is 1 as 0th element is always unique
      int dup=1; //for the duplicate count
      for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]){ //if previous element equals the current element
                dup++;              //so increase the dup count.
            }else{
                dup=1;       //if not duplicate then make the count of dup again 1 
                             //as we got another unique value
            }
            if(dup<3){        //Since we need only 2 same values can come together so dup count should be less than 3
                nums[idx]=nums[i];  //if dup is less than 3 just update the values of the array
                idx++;
            }
        }  
        return idx; //it will return the finall array having atmost 2 duplicates of each elements
    }
}