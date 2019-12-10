public class Finally {
    public static int method() {
        try {
            return 10;
        } finally {
            return 20;
        }
    }
    private static void method2() throws Exception {

    }
    private static void method3() {
        try {
            method2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws Exception {
        int a = method();
        method2();
        System.out.println(a);
    }
}
