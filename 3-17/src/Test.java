public class Test {
    public static void test1() {
        BinarySearchTree<String,String> bst = new BinarySearchTree<>();
        String ret = bst.put("wei","1389744");
        System.out.println(ret);
        ret = bst.put("wei","1111");
        System.out.println(ret);
        ret = bst.put("zhao","2222");
        System.out.println(ret);
        ret = bst.put("gu","33333");
        System.out.println(ret);
        ret = bst.put("zhao","0000");
        System.out.println(ret);
    }

    public static void test2() {
        BinarySearchTree<Integer,Integer> bst = new BinarySearchTree<>();
        bst.put(2,1);
        bst.put(4,1);
        bst.put(1,1);
        bst.put(6,1);
        bst.put(3,1);
        bst.put(5,1);
        bst.inOrder();
    }

    public static void test3() {
        BinarySearchTree<Integer,Integer> bst = new BinarySearchTree<>();
        bst.put(7, 7);
        bst.put(8, 8);
        bst.put(3, 3);
        bst.put(4, 4);
        bst.put(1, 1);
        bst.put(2, 2);
        bst.put(5, 5);
        bst.put(6, 6);
        bst.inOrder();
        Integer ret = bst.remove(10);
        System.out.println(ret);
        bst.inOrder();
        ret = bst.remove(5);
        System.out.println(ret);
        bst.inOrder();
        ret = bst.remove(5);
        System.out.println(ret);
        bst.inOrder();
        ret = bst.remove(7);
        System.out.println(ret);
        bst.inOrder();
    }

    public static void main(String[] args) {
        test1();
        System.out.println();
        test2();
        System.out.println();
        test3();
    }
}
