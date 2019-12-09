import java.util.Stack;

public class MinStack {
    Stack<Integer> st;
    Stack<Integer> mst;
    MinStack() {
        st  = new Stack<>();
        mst = new Stack<>();
    }

    public void push(int x) {
        st.push(x);
        if (mst.isEmpty()||x <= mst.peek()) {
            mst.push(x);
        }
    }

    public void pop() {
        int ret = mst.peek();
        if(ret == st.peek()) {
            mst.pop();
        }
        st.pop();
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return mst.peek();
    }
}
