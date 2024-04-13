class Solution {
    public int maximalRectangle(char[][] matrix) {

        int max = 0;

        int m = matrix.length;
        int n = matrix[0].length;

        int arr[] = new int[n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == '0'){
                    arr[j] = 0;
                } else {
                    arr[j] += 1;
                }
            }

            max = Math.max(max, helper(arr));
        }

        return max;
    }

    public int helper(int[] arr){
        Deque<Pair<Integer, Integer>> st = new ArrayDeque<>();

        int max = 0;

        for(int i = 0; i < arr.length; i++){
            int idx = i;

            while(st.size() > 0 && st.peek().getKey() >= arr[i]){
                Pair<Integer, Integer> p = st.pop();

                idx = p.getValue();

                int area = p.getKey()*(i - idx);

                max = Math.max(max, area);
            }

            st.push(new Pair<>(arr[i], idx));
        }

        while(st.size() > 0){
            Pair<Integer, Integer> p = st.pop();

            int area = p.getKey()*(arr.length - p.getValue());

            max = Math.max(max, area);
        }

        return max;
    }
}