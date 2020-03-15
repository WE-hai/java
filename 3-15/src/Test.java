public class Test {
    public static void main(String[] args) {
        BinarySearchTree btree = new BinarySearchTree();
        btree.insert(4);
        btree.insert(1);
        btree.insert(3);
        btree.insert(8);
        btree.insert(6);
        btree.insert(5);
        btree.insert(12);
        btree.inOrder();

        btree.remove(5);
        btree.inOrder();
    }
}
