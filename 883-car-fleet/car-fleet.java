class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double[] timeneed = new double[target];
        for (int i = 0;i<position.length;i++){
            timeneed[position[i]] = (double)(target - position[i]) / speed[i];
        }
        ArrayList<Double> timeNoneZero = new ArrayList<>();
        for (int i = 0;i<target;i++){
            if (timeneed[i] != 0.0) timeNoneZero.add(timeneed[i] );
        }
        int ans = position.length;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0;i<timeNoneZero.size();i++){
            while (!stack.isEmpty() && timeNoneZero.get(i) >= timeNoneZero.get(stack.peekLast())) {
                stack.removeLast();
                ans--;
            }
            stack.addLast(i);

        }

        return ans;

    }
}