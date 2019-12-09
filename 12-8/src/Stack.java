import java.util.Arrays;

public class Stack {
    private int[] array;
    private int size;

    public Stack(int n) {
        array = new int[n];
        size = 0;
    }
    //尾插
    public void push(int val) {
        //检查容量
        if(size == array.length) {
            array = Arrays.copyOf(array,2*size);
        }
        array[size++] = val;
    }
    //尾删
    public void pop() {
        if (size > 0) {
            --size;
        }
    }
    //栈顶元素
    public int peek() {
        return array[size-1];
    }
    public int size() {
        return size;
    }
    public boolean empty() {
        return size == 0;
    }

    public static void main(String[] args) {
        Stack st = new Stack(2);
        System.out.println(st.size());
        System.out.println(st.empty());
        st.push(1);
        st.push(2);
        st.push(3);
        System.out.println(st.size());
        System.out.println(st.empty());
        System.out.println(st.peek());
    }
}
