class MyCircularQueue {
int[] arr;
int s;
int c;
int front = 0;
int rear = -1;
    public MyCircularQueue(int k) {
        arr = new int[k];
        s = 0;
        c = k;
    }
    public boolean isEmpty() {
        return s==0;
    }
    
    public boolean isFull() {
        return c==s;
    }
    public boolean enQueue(int value) {
        if(isFull())return false;
        rear = (rear+1)%c;
        arr[rear] = value;
        s++;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty())return false;
        front = (front+1)%c;
       s--;
        return true;
    }
    
    public int Front() {
        if(isEmpty())return -1;
        return arr[front];
    }
    
    public int Rear() {
         if(isEmpty())return -1;
        return arr[rear];
    }
    
    
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */