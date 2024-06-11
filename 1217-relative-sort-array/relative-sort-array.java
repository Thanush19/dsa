class Solution {
    class Pair{
        int e,idx;
        Pair(int i , int j){
            e=i;
            idx=j;
        }
    }
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
       PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.idx - b.idx);
        for (int i = 0; i < arr2.length; i++) {
            pq.offer(new Pair(arr2[i], i));
        }

        // Map to count occurrences of elements in arr1
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : arr1) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // List to store the result in the relative order
        List<Integer> resultList = new ArrayList<>();

        // Add elements from arr2 according to their counts in arr1
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int element = pair.e;
            int count = countMap.get(element);
            for (int i = 0; i < count; i++) {
                resultList.add(element);
            }
            countMap.remove(element); // Remove added elements
        }

        // Add remaining elements that were not in arr2
        List<Integer> remainingElements = new ArrayList<>();
        for (int key : countMap.keySet()) {
            int count = countMap.get(key);
            for (int i = 0; i < count; i++) {
                remainingElements.add(key);
            }
        }
        // Sort the remaining elements and add to the result
        Collections.sort(remainingElements);
        resultList.addAll(remainingElements);

        // Convert resultList to array
        int[] result = new int[resultList.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = resultList.get(i);
        }

        return result;




        
    }
}