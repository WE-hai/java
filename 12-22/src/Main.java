import java.util.Scanner;

class TreeNode {
    char c;
    TreeNode left;
    TreeNode right;

    TreeNode(char c) {
        this.c = c;
    }
}

public class Main {
    static int i = 0;
    public static TreeNode buildTree(String s) {
        if (s.charAt(i) != '#') {
            TreeNode root = new TreeNode(s.charAt(i));
            i++;
            root.left = buildTree(s);
            i++;
            root.right = buildTree(s);
            return root;
        }
        return null;
    }

    public static void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.c+" ");
            inOrder(root.right);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s =scanner.nextLine();
        TreeNode root = buildTree(s);
        inOrder(root);
        System.out.println();
    }
}
