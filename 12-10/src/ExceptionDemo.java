import java.util.ArrayList;

public class ExceptionDemo {
    //String/Arrays/List/Map/Set的常用方法熟练掌握（重要参数），手写出来
    //抛出异常（throw异常类型的引用），捕获异常（try{可能会产生异常的语句；可能是方法调用}catch{可自行抛出}）
    //异常的继承链Throwable，子类尽量在上，Exception(父)
    //定义异常：继承自Exception,RuntimeException
    //try{ }finally{ }
    public static void main(String[] args) {
        try{
            new ArrayList<Integer>().get(0);
        } catch(RuntimeException e) {
            throw new MyException("Exception",e);
        } catch(Exception e) {
            System.out.println("Exception");
        }
    }
}
