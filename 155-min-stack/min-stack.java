class MinStack {
    Stack<Integer> st = new Stack<>();
    Stack<Integer> st2 = new Stack<>();

    public MinStack() {

    }

    public void push(int val) {
        st.push(val);

        if (st2.isEmpty() || val <= st2.peek()) {
            st2.push(val);
        }
    }

    public void pop() {
        if (st.isEmpty()) return;

        if (st.peek().equals(st2.peek())) {
            st2.pop();
        }

        st.pop();
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return st2.peek();
    }
}