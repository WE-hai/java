package finallay;

public class FinalTest {
    final int NUMBER;
    {
        NUMBER = 10;
    }

    final int b;
    FinalTest() {
        b = 20;
    }

    final int c = 30;
}
//final修饰的类无法继承（方法一样）
