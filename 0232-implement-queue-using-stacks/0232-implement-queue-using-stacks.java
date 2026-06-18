import java.util.*;

class MyQueue {

    private Stack<Integer> st1;
    private Stack<Integer> st2;

    public MyQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }
    
    public void push(int x) {
        // Move all elements from st1 to st2
        while (!st1.isEmpty()) {
            st2.push(st1.pop());
        }

        // Push new element into st1
        st1.push(x);

        // Move everything back to st1
        while (!st2.isEmpty()) {
            st1.push(st2.pop());
        }
    }
    
    public int pop() {
        return st1.pop();
    }
    
    public int peek() {
        return st1.peek();
    }
    
    public boolean empty() {
        return st1.isEmpty();
    }
}