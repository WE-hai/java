import java.util.Comparator;

public class Test implements Comparable<Test> {
    //****String,Arrays,List,Map记住课件中的方法
    //对象比较：
    //1、==          比较引用是否指向同一个对象
    //2、equals      比较内容是否相同，不要求是同一对象（要覆写equals）
    //3、compareTo   比较内容的大小（一般不进行非空比较） Comparable（interface）
    //4、comparator  比较器 compare（）

    public String ISBN;
    public String title;
    public String author;
    public int price;

    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }
        if (!(obj instanceof Test)) {
            return false;
        }
        Test test = (Test)obj;
        return this.ISBN.equals(test.ISBN);
    }
    public int compareTo(Test o) {
        return this.price - o.price;

    }
    public static void main(String[] args) {
        Test test1 = new Test();
        test1.ISBN = "001";
        test1.author = "a";
        test1.title = "A";
        test1.price = 10;
        Test test2 = new Test();
        test2.ISBN = "001";
        test2.author = "a";
        test2.title = "A";
        test2.price = 10;
        System.out.println(test1.equals(test2));
        System.out.println(test1.compareTo(test2));
        Comparator<Test> t = new TestComparator();
        System.out.println(t.compare(test1,test2));
    }
}
