class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer>set=new HashSet<>();
         HashSet<Integer>set2=new HashSet<>();
        int k=0;
        
        for(int i=0;i<nums1.length;i++)
        {
            set.add(nums1[i]);
        }
          for(int i=0;i<nums2.length;i++)
        {
         if(set.contains(nums2[i])){
            set2.add(nums2[i]);
    
        }
        }
        int nums3[]=new int [set2.size()];
        for(int e:set2)
        {
            nums3[k]=e;
            k++;
        }
        return nums3;
        
    }
}