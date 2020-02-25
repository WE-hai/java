import java.util.Stack;

public class BinaryTree {
    //非递归遍历
    public static void preOrder(TreeNode root) {
        //1. 首先访问根元素
        //2. 根元素入栈
        //3. 继续访问左子树的根，返回第1步，直到遇到空，进行第4步
        //4. 取栈顶元素，访问栈顶元素的右子树，返回第1步
        //结束：栈为空 || 访问到的节点为空
        Stack<TreeNode> st = new Stack<>();
        TreeNode curNode = root;
        while (curNode != null || !st.isEmpty()) {
            while (curNode != null) {
                System.out.print(curNode.value+" ");
                st.push(curNode);
                curNode = curNode.left;
            }
            curNode = st.pop();
            curNode = curNode.right;
        }
    }

    public static void inOrder(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode curNode = root;
        while (curNode != null || !st.isEmpty()) {
            while (curNode != null) {
                st.push(curNode);
                curNode = curNode.left;
            }
            curNode = st.pop();
            System.out.print(curNode.value+" ");
            curNode = curNode.right;
        }
    }

    public static void postOrder(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode curNode = root;
        TreeNode prev = null;
        while (curNode != null || !st.isEmpty()) {
            while (curNode != null) {
                st.push(curNode);
                curNode = curNode.left;
            }
            //curNode = st.pop();  //可能有元素访问不到
            curNode = st.peek();
            //判断右子树是否已经访问完
            //1. curNode.right == null : 没有子树
            //2. curNode.right == prev：有子树，并且右子树的根上一次已经访问结束，即右子树访问完成
            if (curNode.right == null || curNode.right == prev) {
                System.out.print(curNode.value + " ");
                prev = curNode;
                st.pop();
                curNode = null;
            } else {
                curNode = curNode.right;
            }
        }
    }
    public static TreeNode buildTree(){
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        root.left = left;
        root.right = right;
        left.left = node4;
        left.right = node5;
        right.left = node6;
        right.right = node7;
        left.left.left = node8;
        return root;
    }
    //递归遍历
    public static void prOder(TreeNode root) {
        if (root != null) {
            System.out.print(root.value + " ");
            prOder(root.left);
            prOder(root.right);
        }
    }

    public static void backOrder(TreeNode root) {
        if (root != null) {
            backOrder(root.left);
            backOrder(root.right);
            System.out.print(root.value+" ");
        }
    }
    public static void main(String[] args) {
        TreeNode root = buildTree();
        prOder(root);
        System.out.println();
        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        backOrder(root);
        System.out.println();
        postOrder(root);
    }
}
