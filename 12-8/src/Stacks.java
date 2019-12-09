import java.util.Arrays;

public class Stacks {
    private int[] array;
    private int size;

    public Stacks(int n) {
        array = new int[n];
        size = 0;
    }

    public void push(int value) {
        if (size == array.length) {
            array = Arrays.copyOf(array,2*size);
        }
        array[size++] = value;
    }
    public void pop() {
        if(size > 0) {
            --size;
        }
    }
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
        Stacks sts = new Stacks(3);
        System.out.println(sts.size());
        System.out.println(sts.empty());
        sts.push(1);
        sts.push(2);
        sts.push(3);
        sts.push(4);
        System.out.println(sts.size());
        System.out.println(sts.empty());
        System.out.println(sts.peek());
        while(sts.size()>0) {
            System.out.println(sts.peek());
            sts.pop();
        }

    }
}
