class MyStack {
Queue<Integer>q = new ArrayDeque<>();
int c;
int n;
    public MyStack() {
        c = 0;
        n = q.size();
    }
    public void reverse(){
        if(empty())return;
        for(int i=0;i<q.size()-1;i++){
            q.offer(q.poll());
        }
    }
    
    public void push(int x) {
        q.offer(x);
        reverse();
    }
    
    public int pop() {
        // reverse();
        if(q.isEmpty())return 0;
        
        return q.poll();
    }
    
    public int top() {
        //reverse();
        return q.peek();

    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */