import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Collect {
    public static void main(String[] args) {
        Collection<String> list = new ArrayList<>();
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        list.add("abc");
        list.add("def");
        list.add("java");
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        Object[] array = list.toArray();
        System.out.println(Arrays.toString(array));
        for(String s : list) {
            System.out.println(s);
        }
        list.remove("abc");
        for (String s : list) {
            System.out.println(s);
        }

    }
}
