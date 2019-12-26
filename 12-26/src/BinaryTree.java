import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }
}

public class BinaryTree {
    //找最近公共祖先
    public boolean find(TreeNode root,TreeNode node) {
        if(root == null) {
            return false;
        }
        if(root == node) {
            return true;
        }
        if(find(root.left,node)) {
            return true;
        }
        return find(root.right,node);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        boolean pl = false, pr = false, ql = false, qr = false;
        if (root == null) {
            return root;
        }
        if (root == p || root == q) {
            return root;
        }
        //同一边
        if (find(root.left, p)) {
            pl = true;
            pr = false;
        } else {
            pr = true;
            pl = false;
        }
        if (find(root.left, q)) {
            ql = true;
            qr = false;
        } else {
            qr = true;
            ql = false;
        }
        //同一边
        if (pl && ql) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (pr && qr) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }

    public boolean getPath(TreeNode root,TreeNode node,Stack<TreeNode> stack) {
        if(root == null) {
            return false;
        }
        //root入栈
        stack.push(root);
        if(root == node) {
            return true;  //结束
        }
        //判断左右子树是否存在node
        if(getPath(root.left,node,stack)) {
            return true;
        }
        if(getPath(root.right,node,stack)) {
            return true;
        }
        //当前root出栈
        stack.pop();
        return false;
    }
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> path1 = new Stack<>();
        Stack<TreeNode> path2 = new Stack<>();
        getPath(root,p,path1);
        getPath(root,q,path2);
        while(path1.size()!= path2.size()) {
            if(path1.size() > path2.size()) {
                path1.pop();
            } else {
                path2.pop();
            }
        }
        while(path1.size()!=0) {
            if(path1.peek() == path2.peek()) {
                break;
            }else {
                path1.pop();
                path2.pop();
            }
        }
        return path1.peek();
    }

    //二叉搜索树与双向链表
    static TreeNode  prev = null;
    public void _Convert(TreeNode root) {
        if(root == null) {
            return;
        }
        //中序遍历
        _Convert(root.left);
        //处理当前节点
        root.left = prev;
        if(prev != null) {
            prev.right = root;
        }
        prev = root;
        _Convert(root.right);
    }
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null) {
            return null;
        }
        prev = null;
        _Convert(pRootOfTree);
        //返回头，左边的最后一个非空结点
        while(pRootOfTree.left!=null) {
            pRootOfTree = pRootOfTree.left;
        }
        return pRootOfTree;
    }

    //从前序与中序遍历序列构造二叉树
    static int curIdx;
    public TreeNode _buildTree(int[] pre,int[] in,int inS,int inE){
    //inS 是中序遍历起始位置，inE是末位置
    //空树
        if(inS>inE)
            return null;

        int rootValue=pre[curIdx];
        curIdx++;
        TreeNode root=new TreeNode(rootValue);
        //区间中除过根元素，没有孩子节点
        if(inS==inE)
            return root;

        //确定左右子树区间
        int i;
        for(i=inS;i<=inE;i++){
            if(in[i]==rootValue) {
                break;
            }
        }
        //左右子树的区间：
        //左子树：[]inS,i-1]
        //右子树：[i+],inE]
        //构建左右子树
        root.left=_buildTree(pre,in,inS,i-1);
        root.right=_buildTree(pre,in,i+1,inE);

        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        curIdx=0;
        return _buildTree(preorder,inorder,0,preorder.length-1);
    }
    public static void main(String[] args) {

    }
}
