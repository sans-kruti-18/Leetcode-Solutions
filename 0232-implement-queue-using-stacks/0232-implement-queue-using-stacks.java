import java.util.Stack;

class MyQueue {
    private Stack<Integer> input;
    private Stack<Integer> output;

    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }
    
    public void push(int x) {
        while (!input.isEmpty()) {
            output.push(input.pop());
        }
        input.push(x);
        while (!output.isEmpty()) {
            input.push(output.pop());
        }
    }
    
    public int pop() {
        if (input.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return input.pop();
    }
    
    public int peek() {
        if (input.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return input.peek();
    }
    
    public boolean empty() {
        return input.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
