package 接口;
//接口之间可以继承，一个类也可以实现多个接口

//类  单继承 一个类
//类  多实现 多个接口
//接口  多继承 多个接口

public interface MyList {

    void pushFront(int element);
    void pushBack(int element);
    void popFront();
    void popBack();

    int get(int index);
    void set(int index,int element);
}
