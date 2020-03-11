import java.util.Arrays;
import java.util.Comparator;

class Person implements Comparable<Person> {
    int age;
    String name;

    public Person(int age,String name) {
        this.age = age;
        this.name = name;
    }

    /*
    compare:
    返回值 < 0 ：表示当前对象小于被比较的对象
    返回值
     */
    @Override
    public int compareTo(Person o) {
        return age-o.age;
    }

    @Override
    public String toString() {
        return name+"--->"+age;
    }
}
class Per implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.age-o2.age;
    }
}

class Pers implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return 0;
    }
}
public class CompareDemo {
    public static void test1() {
        Person[] arr = {new Person(20,"wei"),new Person(21,"zhao"),new Person(19,"gu")};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr,new Per());
        System.out.println(Arrays.toString(arr));

    }

    public static void bubbleSort(Person[] arr) {
        int end = arr.length;
        while (end > 0) {
            boolean flag = true;
            for (int i = 1;i < arr.length;i++) {
                if (arr[i-1].compareTo(arr[i]) > 0) {
                    swap(arr,i-1,i);
                    flag = false;
                }
            }
        }

    }

    public static void swap(Person[] arr, int i, int i1) {
    }

    public static void main(String[] args) {
        test1();
    }
}
