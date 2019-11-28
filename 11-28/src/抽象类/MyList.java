package 抽象类;
//抽象类可以有抽象方法，抽象方法必须出现在抽象类或接口中
//抽象类不能构造对象
public interface MyList {
    void pushFront(int element);
    void pushBack(int element);
    void insert(int index,int element);
}

abstract class AbstractList implements MyList {
    protected int size;

    @Override
    public void pushBack(int element) {
        insert(0,element);
    }

    @Override
    public void pushFront(int element) {
        insert(size,element);
    }
}

class MyArrayList extends AbstractList {
    @Override
    public void insert(int index, int element) {

    }
}
