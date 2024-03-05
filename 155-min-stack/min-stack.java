class MinStack {
     Stack <Integer> stack;
     Stack<Integer> minStack;
    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }
  
    public void push(int val) {
        //int max = Integer.MAX_VALUE;
        this.stack.push(val);
        // val = Math.min(val, minStack.isEmpty() ? val : minStack.peek());
        // minStack.push(val);
        
        if(minStack.isEmpty()){
            minStack.push(val);
        }
        else{
            int min = minStack.peek();
            if(val < min){
                minStack.push(val);
            }
            else{
                minStack.push(min);
            }
        }
        

    }
    
    public void pop() {
        this.stack.pop();
        this.minStack.pop();
    }
    
    public int top() {
        return this.stack.peek();
    }
    
    public int getMin() {
        return this.minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */