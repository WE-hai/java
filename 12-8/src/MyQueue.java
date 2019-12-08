import java.util.Stack;

public class MyQueue {
    Stack<Integer> st1;
    Stack<Integer> st2;

    MyQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }

    public void push(int x) {
        st1.push(x);
    }

    public int pop() {
        if (st2.isEmpty()) {
            int sz = st1.size();
            for(int i = 0;i < sz;i++){    //st1.size()变化
                st2.push(st1.pop());
            }
        }
        return st2.pop();
    }

    public int peek() {
        if (st2.isEmpty()) {
            int sz = st1.size();
            for(int i = 0;i < sz;i++) {
                st2.push(st1.pop());
            }
        }
        int ret = st2.peek();
        return ret;
    }

    public boolean empty() {
        return st1.isEmpty() && st2.isEmpty();
    }
}
