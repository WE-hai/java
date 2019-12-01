import java.util.ArrayList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);

        list.set(0,10);
        list.remove(2);
        list.add(4);

        for (Integer e : list) {
            System.out.println(e);
        }
        System.out.println(list.contains(2));
        int a = list.indexOf(2);
        System.out.println(list);
        System.out.println("get:");
        System.out.println(list.get(1));
        List<Integer> sublist = list.subList(0,3);
        System.out.println("sublist:");
        for (Integer e : sublist) {
            System.out.println(e);
        }

    }
}
