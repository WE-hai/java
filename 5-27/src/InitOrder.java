class A {
    A() {
        System.out.println("A()");
    }

    {
        System.out.println("A.{}");
    }

    static {
        System.out.println("A.static {}");
    }
}

class B extends A {
    B() {
        System.out.println("B()");
    }

    {
        System.out.println("B.{}");
    }

    static {
        System.out.println("B.static {}");
    }
}

public class InitOrder extends B {
    public static void main(String[] args) {
        System.out.println("========================");
        System.out.println("开始");
        System.out.println("========================");
        new B();
        System.out.println("========================");
        new B();
        System.out.println("========================");
        System.out.println("结束");
    }
}