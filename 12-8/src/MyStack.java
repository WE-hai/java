import java.util.LinkedList;
import java.util.Queue;

//collection:List, Queue
//Set:HashSet, TreeSet
//Map:HashMap,TreeMap
//栈：后进先出  入栈：push   获取栈顶元素：top    出栈：pop（栈顶）
//队列：先进先出   入队列：offer   获取队首元素：peek  出队列：poll

//用队列实现stack
public class MyStack {
    Queue<Integer> que;
    public MyStack() {
        que = new LinkedList<>();
    }

    public void push(int x) {
        que.offer(x);
    }

    public int pop() {
        int sz = que.size();
        while(sz > 1) {
            que.offer(que.poll());
            --sz;
        }
        return que.poll();
    }

    public int top() {
        int sz = que.size();
        while(sz > 1) {
            que.offer(que.poll());
            --sz;
        }
        int ret = que.poll();
        que.offer(ret);
        return ret;
    }

    public boolean empty() {
        return que.isEmpty();
    }

    public static void main(String[] args) {
        MyStack st = new MyStack();
        st.push(1);
        st.push(2);
        st.push(3);
        System.out.println(st);
    }
}
