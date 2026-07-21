class StockSpanner {

    Stack<int[]> stack;
    int index;

    public StockSpanner() {
        stack = new Stack<>();
        index = 0;
    }

    public int next(int price) {

        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            stack.pop();
        }

        int span;

        if (stack.isEmpty()) {
            span = index + 1;
        } else {
            span = index - stack.peek()[1];
        }

        stack.push(new int[]{price, index});
        index++;

        return span;
    }
}