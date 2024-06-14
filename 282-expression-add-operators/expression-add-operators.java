class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> ans =new ArrayList<>();
        if(num.length()==1){
            if((int)(num.charAt(0)-'a')==target){
                ans.add(num);
            }
            return ans;
        }
        char[] a=num.toCharArray();
        get(ans,0,num.length(),a,target,0,0,new StringBuilder(),0);
        return ans;
    }
   
   static void get(List<String> ans, int start, int n,char[] a, long t, long curr, long last,StringBuilder s,int size){
    if(start==n){
        if(curr==t){
            ans.add(s.toString());
        }
        return;
    }
      StringBuilder str=new StringBuilder();
      for(int i=start;i<n;i++){
       if(i!=start && a[start]=='0')break;
        str.append(a[i]);
        long f=Long.parseLong(str.toString());
        if(start==0){
            get(ans,i+1,n,a,t,f,f,str,i+1);
        }else{
            s.append('+');
            s.append(str.toString());
      get(ans,i+1,n,a,t,curr+f,f,s,size+1+i-start+1);
            s.deleteCharAt(size);
            s.insert(size,'-');
      get(ans,i+1,n,a,t,curr-f,-f,s,size+1+i-start+1);
            s.deleteCharAt(size);
            s.insert(size,'*'); 
      get(ans,i+1,n,a,t,curr+(last*(f-1)),last*f,s,size+1+i-start+1);
            s.delete(size,s.length());
      }
      }
      return;
   }
    

}