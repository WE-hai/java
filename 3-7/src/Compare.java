import java.util.Arrays;

public class Compare {
    //定义自定义类型要进行比较：
    //1.需要实现Comparable接口中的compareTo方法---->自然排序的实现方式
    //2.实现比较器Comparator接口中的compare方法--->非自然排序的实现方式

}
class test {
    public static void main(String[] args) {
        int[] arr = {2,3,7,1};
        Arrays.sort(arr);
        Person[] p = {new Person("123","nan",20,"1234567"),new Person("33","nv",21,"78977687")};
    }
}
class Person implements Comparable<Person> {
    public String name;
    public String gender;
    public int age;
    public String ID;

    Person(String name,String gender,int age,String ID) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.ID = ID;
    }

    @Override
    public int compareTo(Person p) {
        int ret = age-p.age;
        if (ret < 0) {
            return -1;
        } else if (ret > 0){
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return name+"--"+gender+"--"+age+"--"+ID;
    }
}