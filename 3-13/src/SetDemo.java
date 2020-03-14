import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
    public static void testSet() {
        Set<Integer> set = new TreeSet<>();
        set.add(10);
        set.add(2);
        set.add(1);
        set.add(12);
        //遍历有序
        for (Integer e : set) {
            System.out.print(e+" ");
        }
        System.out.println();
        set.remove(1);
        for (Integer e : set) {
            System.out.print(e+" ");
        }
    }

    public static void main(String[] args) {
        testSet();
    }
}
