public class BinarySearchTree<K extends Comparable<K>,V> {
    private static class MyEntry<K,V> {
        K  key;
        V value;
        MyEntry<K,V> left;
        MyEntry<K,V> right;

        public MyEntry(K key,V value) {
            this.key = key;
            this.value = value;
            left = right = null;
        }
    }

    private MyEntry<K,V> root = null;
    private int size = 0;

    public V put(K key,V value) {
        if (root == null) {
            root = new MyEntry<>(key,value);
            size++;
            return null;
        }
        MyEntry<K,V> cur = root;
        MyEntry<K,V> parent = null;
        while (cur != null) {
            parent = cur;
            int r = cur.key.compareTo(key);
            if (r == 0) {
                V oldV = cur.value;
                cur.value = value;
            }else if (r > 0) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        cur = new MyEntry<>(key,value);
        int r = parent.key.compareTo(key);
        if (r > 0) {
            parent.left = cur;
        } else {
            parent.right = cur;
        }
        size++;
        return null;
    }

    public V get(K key) {
        if (root == null) {
            return null;
        }
        MyEntry<K,V> cur = root;
        while (cur != null) {
            int r = cur.key.compareTo(key);
            if (r == 0) {
                return cur.value;
            } else if (r > 0) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return null;
    }

    public V remove(K key) {
        if (root == null) {
            return null;
        }
        MyEntry<K,V> cur = root;
        MyEntry<K,V> parent = null;
        while (cur != null) {
            int r = cur.key.compareTo(key);
            if (r == 0) {
                break;
            } else if (r > 0) {
                parent = cur;
                cur = cur.left;
            } else {
                parent = cur;
                cur = cur.right;
            }
        }
        if (cur == null) {
            return null;
        }
        V oldV = cur.value;
        remove(parent,cur);
        return oldV;
    }

    public void remove(MyEntry<K,V> parent,MyEntry<K,V> cur) {
        if (cur.left == null) {
            if (cur != root) {
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
                if (parent.left == cur) {
                    parent.left = cur.left;
                } else {
                    parent.right = cur.left;
                }
            } else {
                root = cur.left;
            }
        } else {
            parent = cur;
            MyEntry<K,V> next = cur.right;
            while (next.left != null) {
                parent = next;
                next = next.left;
            }
            cur.key = next.key;
            cur.value = next.value;
            if (parent.left == next) {
                parent.left = next.right;
            } else {
                parent.right = next.right;
            }
        }
    }

    public void inOrderInternal(MyEntry<K,V> root) {
        if (root != null) {
            inOrderInternal(root.left);
            System.out.print(root.key+" ---> "+root.value+" ");
            inOrderInternal(root.right);
        }
    }

    public void inOrder() {
        inOrderInternal(root);
        System.out.println();
    }
}
