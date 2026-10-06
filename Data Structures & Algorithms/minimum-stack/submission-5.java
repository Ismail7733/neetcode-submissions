class MinStack {

    private int min;
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
        min = Integer.MIN_VALUE;
    }
    
    public void push(int val) {
        stack.push(val);

        if (minStack.empty() || val <= min) {
            min = val;
            minStack.push(val);
        }
    }
    
    public void pop() {
        int val = stack.pop();

        if (val == min) {
            minStack.pop();
            
            if (! minStack.empty()) {
                min = minStack.peek();
            } 
            else {
                min = Integer.MIN_VALUE;
            }
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
