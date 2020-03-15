public class BinarySearchTree {
    public static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
            left = right = null;
        }
    }

    private TreeNode root = null;
    public TreeNode find(int value) {
        if (root == null) {
            return null;
        }
        TreeNode cur = root;
        while (cur != null) {
            if (cur.value == value) {
                return cur;
            } else if (cur.value > value) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return null;
    }

    public boolean insert(int value) {
        if (root == null) {
            root = new TreeNode(value);
            return true;
        }
        TreeNode cur = root;
        TreeNode parent = null;
        while (cur != null) {
            parent = cur;
            if (cur.value == value) {
                return false;
            } else if (cur.value > value) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        cur = new TreeNode(value);
        if (parent.value > cur.value) {
            parent.left = cur;
        } else {
            parent.right = cur;
        }
        return true;
    }

    public void inOrder() {
        inOrderInteral(root);
        System.out.println();
    }

    private void inOrderInteral(TreeNode root) {
        if (root != null) {
            inOrderInteral(root.left);
            System.out.print(root.value+" ");
            inOrderInteral(root.right);
        }
    }

    public void remove(TreeNode parent,TreeNode cur) {
        if (cur.left == null) {
            if (cur != null) {
                if (parent.left == cur) {
                    parent.left = cur.right;
                } else {
                    parent.right = cur.right;
                }
            } else {
                root = cur.right;
            }
        } else if (cur.right == null) {
            if (cur != root) {
                if (parent.left == null) {
                    parent.left = cur.left;
                } else {
                    parent.right = cur.left;
                }
            } else {
                root = cur.left;
            }
        } else {
            parent = cur;
            TreeNode next = cur.left;
            while (next.right != null) {
                parent = next;
                next = next.right;
            }
            cur.value = next.value;
            if (parent.left == next) {
                parent.left = next.left;
            } else {
                parent.right = next.left;
            }
        }
    }

    public boolean remove(int value) {
        if (root == null) {
            return false;
        }
        TreeNode cur = root;
        TreeNode parent = null;
        while (cur != null) {
            if (cur.value == value) {
                break;
            } else if (cur.value > value) {
                parent = cur;
                cur = cur.left;
            } else {
                parent = cur;
                cur = cur.right;
            }
        }
        if (cur == null) {
            return false;
        }
        remove(parent,cur);
        return true;
    }
}
