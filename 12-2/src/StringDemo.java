public class StringDemo {
    //String具有不可变性，专门为String类型的对象在内容中开辟空间
    //private final char[] value = new char[10];   //value 不能指向其他对象
    //private final int size;
    //该类不能被继承，属性不允许修改 —— final
    //保证不修改final引用对象内部的属性，不要引用泄露
    //StringBuilder拼接String
    //javap反编译成人类可读文件
    //三个特殊点：1、构造对象有特殊  2、不可变性  3、常量池 （1）JVM
    public static void main(String[] args) {
        String s = "hello";
        s += " ";
        s += "world";
        System.out.println(s);
    }
}
