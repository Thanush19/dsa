class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;//string the length
        int[] freq = new int[1001];//creating a frequency array to count the no of citations for each no of papers , papers are counted as index.
        int max = Integer.MIN_VALUE;//max value will determine the begining of the array traversal
        for(int c : citations){
            //here c represents the no of papers
          freq[c]++;//storing the value of citations for each paper in their respective frequency table
          max=Math.max(c,max);//getting the max citated value
        }
        int count_citations = 0;//initialising the citations to zero
        int i = max;//starts from the max value since there are no more citations left
        for(;i>=0;i--){
        count_citations+=freq[i];//counting the citations from the frequency table to the
        if(count_citations>=i)break;//since we are travelling from max to min value of papers this line fulfills maximum value of h-index (papers) the given researcher has published at least h papers that have each been cited at least h times.
        }
        return i;//returning the h-index
    }
}