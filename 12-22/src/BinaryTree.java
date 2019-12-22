import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    Node left;
    Node right;
    int value;

    public Node(int value) {
        this.value = value;
    }
}

public class BinaryTree {
    public Node find(Node root,int value) {   //查找结点
        if (root == null) {
            return root;
        }
        if (root.value == value) {
            return root;
        }
        Node node = find(root.left,value);
        if (node != null) {
            return node;
        }
        return find(root.right,value);
    }
    public void inOrder(Node root, List<Integer> list) {    //List保存，中序遍历
        if (root != null) {
            inOrder(root.left,list);
            list.add(root.value);
            inOrder(root.right,list);
        }
    }
    public List<Integer> inorderTraversal(Node root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root,list);
        return list;
    }
    //判断树相同
    public boolean isSame(Node root1,Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        return root1.value == root2.value &&
            isSame(root1.left,root2.left) && isSame(root1.right, root2.right);

    }
    //判断子树与树相同
    public boolean isPartSame(Node root1,Node root2) {
        if (isSame(root1,root2)) {
            return true;
        }
        if (isPartSame(root1.left,root2)) {
            return true;
        }
        return isPartSame(root1.right,root2);
    }

    //求二叉树的最大深度
    public int maxDepth(Node root) {
        //return root == null ? 0 : Math.max(maxDepth(root.left),maxDepth(root.right))+1;
        if (root == null) {
            return 0;
        } else {
           return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
        }
    }
    //平衡
    public int getHeight(Node root) {
        return root == null ? 0 : Math.max(getHeight(root.left),getHeight(root.right))+1;
    }
    public boolean isBalance(Node root) {
        if (root == null) {
            return true;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.abs(left - right) < 2 && isBalance(root.left) && isBalance(root.right);
    }

    //镜像对称
    public boolean _isSymmetric(Node left,Node right) {
        if(left == null && right == null) {
            return true;
        }
        if(left == null || right == null) {
            return false;
        }
        return left.value == right.value && _isSymmetric(left.left,right.right) && _isSymmetric(left.right,right.left);
    }
    public boolean isSymmetric(Node root) {
        if(root == null) {
            return true;
        }
        return _isSymmetric(root.left,root.right);
    }

    //层次遍历
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> mat = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> rownode = new ArrayList<>();
            while (size > 0) {
                Node topnode = queue.poll();
                rownode.add(topnode.value);
                if (topnode.left != null) {
                    queue.offer(topnode.left);
                }
                if (topnode.right != null) {
                    queue.offer(topnode.right);
                }
                --size;
            }
            mat.add(rownode);
        }
        return mat;
    }

    //层次遍历
    public static void IeverOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            Node topnode = queue.poll();
            System.out.println(topnode.value);
            if (topnode.left != null) {
                queue.offer(topnode.left);
            }
            if (topnode.right != null) {
                queue.offer(topnode.right);
            }
        }
    }

    //判断是否完全二叉树
    public static boolean isCompleteTree(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            Node topnode = queue.poll();
            if (topnode == null) {
                break;
            }
            queue.offer(topnode.left);
            queue.offer(topnode.right);
        }
        while (!queue.isEmpty()) {
            Node topnode = queue.poll();
            if (topnode != null) {
                return false;
            }
        }
        return true;
    }

    public static Node buildTree1() {
        Node root = new Node(1);
        Node left = new Node(2);
        Node right = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);
        Node node6 = new Node(7);
        Node node7 = new Node(8);
        root.left = left;
        root.right = right;
        left.left = node3;
        left.right = node4;
        right.left = node5;
        right.right = node6;
        left.left.right = node7;

        return root;
    }

    public static Node buildTree2() {
        Node root = new Node(1);
        Node left = new Node(2);
        Node right = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);
        Node node6 = new Node(7);
        Node node7 = new Node(8);
        root.left = left;
        root.right = right;
        left.left = node3;
        left.right = node4;
        right.left = node5;
        right.right = node6;
        left.left.left = node7;

        return root;
    }

    public static void main(String[] args) {
        Node root1 = buildTree1();
        IeverOrder(root1);
        System.out.println(isCompleteTree(root1));
        Node root2 = buildTree2();
        IeverOrder(root2);
        System.out.println(isCompleteTree(root2));

    }
}
