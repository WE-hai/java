import java.util.List;

public class MyArrayList<E> {
    private E[] array;
    private int size;

    //泛型想象为类型替换即可
    //泛型发生在编译期间，不在运行期间，知道类型擦除
    MyArrayList() {
       //array =
        size = 0;

    }
}
