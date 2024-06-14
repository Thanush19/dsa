class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> list=new ArrayList<>(); 
    List<Integer>currlist=new ArrayList<>(); 
       HashMap<Integer,Integer> map=new HashMap<>();
    helper(nums,list,currlist,map); 
    return list;
    } 

    public static void helper(int []nums,List<List<Integer>> list, List<Integer> currlist,HashMap<Integer,Integer> map){
               
               if(currlist.size()==nums.length){ 
                   if(!list.contains(currlist)){
                   list.add(new ArrayList<>(currlist));
                   }
                   return ;
               }  

               for(int j=0;j<nums.length;j++){ 
                   if(!map.containsKey(j)){
                        map.put(j,1);
                        currlist.add(nums[j]); 
                        helper(nums,list,currlist,map);
                        currlist.remove(currlist.size()-1);
                        map.remove(j);
                   }
               }


    }
}