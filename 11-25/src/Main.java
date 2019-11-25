public class Main {
    public static void main(String[] args) {
        Animal person = new Human();
        person.scream();
        System.out.println(person instanceof Human);
        //向下转型判断instanceof  强转  错误的向下转型不是编译错误，是运行错误
        System.out.println(person.getNumberOfLegs());
    }
}
