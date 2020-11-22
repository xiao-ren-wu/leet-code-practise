package org.ywb.practise.tree;

/**
 * @author yuwenbo1
 * @date 2020/11/20 4:54 下午 星期五
 * @since 1.0.0
 */
public class AvlTree<T extends Comparable<T>> {

    /**
     * 树的根节点
     */
    private AvlNode root;

    /**
     * 树的高度
     */
    private int height;

    private class AvlNode {
        /**
         * 节点值
         */
        private T data;
        /**
         * 当前节点所在树的高度
         */
        int height;
        /**
         * 左右子树
         */
        private AvlNode left, right;

        AvlNode(T data) {
            left = right = null;
            this.data = data;
            this.height = 0;
        }
    }

    public int height(){
        return root.height;
    }

    private int height(AvlNode avlNode) {
        if (avlNode == null) {
            return -1;
        }
        return avlNode.height;
    }

    /**
     * 左旋
     *       4                2
     *      | \              | \
     *     2   5    --->    1  4
     *    | \              |  | \
     *   1   3            0   3  5
     *  |
     * 0
     *
     * @param avlNode 当前根节点
     * @return 左旋后的当前根节点
     */
    private AvlNode ll(AvlNode avlNode) {
        if (avlNode==null) {
            return null;
        }
        // 获取当前传入二叉树根节点的左儿子
        AvlNode leftNode = avlNode.left;
        // 左旋
        avlNode.left = leftNode.right;
        leftNode.right = avlNode;
        // 重新计算高度
        leftNode.height = Integer.max(this.height(leftNode.left), this.height(leftNode.right))+1;
        avlNode.height = Integer.max(this.height(avlNode), this.height(avlNode))+1;
        // 此时当前二叉树的根节点为刚刚的左儿子
        return leftNode;
    }

    /**
     * 右旋
     *     2                    4
     *    | \                  | \
     *   1   4                 2  5
     *      | \     --->      | \  \
     *     3   5              1  3  6
     *          \
     *           6
     *
     * @param avlNode 当前根节点
     * @return 右旋后的当前根节点
     */
    private AvlNode rr(AvlNode avlNode) {
        if (avlNode==null) {
            return null;
        }
        // 获取当前传入二叉树根节点的右儿子
        AvlNode rightNode = avlNode.right;
        // 右旋
        avlNode.right = rightNode.left;
        rightNode.left = avlNode;
        // 重新计算高度
        rightNode.height = Integer.max(this.height(rightNode.left), this.height(rightNode.right))+1;
        avlNode.height = Integer.max(this.height(avlNode.left), this.height(avlNode.right))+1;
        // 此时当前二叉树的根节点为刚刚的右儿子
        return rightNode;
    }

    /**
     * 左右模式，先右旋，然后左旋
     *        6                 6                 4
     *       / \               / \              /  \
     *      2   7             4   7            2    6
     *     / \      --->     / \     --->     / \  / \
     *    1   4             2   5            1   3 5   7
     *       / \           / \
     *      3   5         1   3
     * @param avlNode 当前根节点
     * @return 旋转后的当前根节点
     */
    private AvlNode lr(AvlNode avlNode){
        if(avlNode==null){
            return null;
        }
        avlNode.left = rr(avlNode.left);
        return rr(avlNode);
    }

    /**
     * 右左模式，先左旋，然后右旋
     *           2                2                   4
     *          / \              / \                /   \
     *         1   6            1  4               2     6
     *            / \   --->      / \       --->  / \   / \
     *           4   7           3   6           1   3 5  7
     *          / \                 / \
     *         3   5               5   7
     *
     * @param avlNode 当前根节点
     * @return 旋转后的根节点
     */
    private AvlNode rl(AvlNode avlNode){
        if(avlNode==null){
            return null;
        }
        avlNode.right = ll(avlNode.right);
        return rr(avlNode);
    }




    /**
     * 删除节点
     *
     * @param data 节点值
     */
    public void delete(T data) {
        root = deleteCore(data, root);
        height = root!=null?root.height:0;
    }

    /**
     * 删除节点核心逻辑
     *
     * @param data 数据
     * @param root 当前节点根节点
     * @return 根节点
     */
    private AvlNode deleteCore(T data, AvlNode root) {
        if (root == null) {
            return null;
        }
        if (root.data.compareTo(data) > 0) {
            // 根节点比删除的节点大，删除的节点在左子树
            root.left = deleteCore(data, root.left);
            // 平衡树
            if (height(root.right) - height(root.left) > 1) {
                // 判断平衡模式
                if (height(root.right.left) > height(root.right.right)) {
                    // RL模式
                    root = rl(root);
                } else {
                    // RR模式
                    root = rr(root);
                }
            }
        } else if (root.data.compareTo(data) < 0) {
            // 根节点比删除的节点小，删除的单节点在右子树
            root.right = deleteCore(data, root.right);
            // 平衡树
            if (height(root.left) - height(root.right) > 1) {
                // 判断平衡模式
                if (height(root.left.right) > height(root.left.left)) {
                    // LR模式
                    root = lr(root);
                } else {
                    // LL模式
                    root = ll(root);
                }
            }
        } else {
            // 当前的根节点即为需要删除的节点

            if (root.left != null && root.right != null) {
                // 左右子树都非空，判断左右子树的高度，选择高度较高的一个

                if (root.left.height > root.right.height) {
                    // 左子树较高，那么从左子树中找到值最大的节点，跟要删除的节点的值(当前的根节点)进行替换，然后删除该节点
                    AvlNode maxNode = finMax(root.left);
                    root.data = maxNode.data;
                    // 删除左子树中值最大的节点
                    root.left = deleteCore(maxNode.data, root.left);
                } else {
                    // 右子树较高，那么从右子树中找到值最小的节点，跟要删除的节点的值(当前的根节点)进行替换，然后删除该节点
                    AvlNode minNode = findMin(root.right);
                    root.data = minNode.data;
                    // 删除右子树中值最小的节点
                    root.right = deleteCore(minNode.data, root.right);
                }

            } else {
                // 选择任意一个非空节点作为根节点返回
                root = root.left != null ? root.left : root.right;
            }

        }
        // 重新计算节点的高度
        if(root!=null){
            root.height = Integer.max(height(root.left), height(root.right)) + 1;
        }
        return root;
    }

    /**
     * 插入节点
     *
     * @param data 节点值
     */
    public void insert(T data) {
        root = insertCore(data, root);
        height = root.height;
    }

    /**
     * 插入节点核心逻辑
     *
     * @param data 数据
     * @param root 当前节点根节点
     * @return 根节点
     */
    private AvlNode insertCore(T data, AvlNode root) {
        if (root == null) {
            return new AvlNode(data);
        }
        if (root.data.compareTo(data) > 0) {
            root.left = insertCore(data, root.left);
            // 是否需要平衡
            if ((height(root.left) - height(root.right) > 1)) {
                if (height(root.left.left)>height(root.left.right)) {
                    // LL情况
                    root = ll(root);
                } else {
                    // LR情况
                    root = lr(root);
                }
            }
        } else if (root.data.compareTo(data) < 0) {
            root.right = insertCore(data, root.right);
            // 是否需要平衡
            if ((height(root.right) - height(root.left) > 1)) {
                if (height(root.right.right)>height(root.right.left)) {
                    // RR情况
                    root = rr(root);
                } else {
                    // RL情况
                    root = rl(root);
                }
            }
        }
        // 重新计算节点高度
        if(root != null){
            root.height = Integer.max(height(root.left), height(root.right)) + 1;
        }
        // 节点和当前root节点相等，直接返回
        return root;
    }

    /**
     * 找到树中最小的值
     *
     * @param root 树的根节点
     * @return min avlNode
     */
    private AvlNode findMin(AvlNode root) {
        return (root == null || root.left == null) ? root : findMin(root.left);
    }

    /**
     * 找到树中最大的值
     *
     * @param root 树的根节点
     * @return max avlNode
     */
    private AvlNode finMax(AvlNode root) {
        return (root == null || root.right == null) ? root : finMax(root.right);
    }

    /**
     * 判断节点是否在二叉树中
     *
     * @param data data
     * @return bool
     */
    public boolean contains(T data){
        AvlNode p = root;
        while (p!=null&&p.data!=data){
            if(p.data.compareTo(data)>0){
                p=p.left;
            }else {
                p=p.right;
            }
        }
        return p!=null&&p.data.compareTo(data)==0;
    }

    /**
     * 前序遍历二叉树
     */
    public void prePrintAvlTree(){
        prePrintAvlTreeCore(this.root);
        System.out.println();
    }

    private void prePrintAvlTreeCore(AvlNode root){
        if (root!=null){
            System.out.print(root.data+", ");
            prePrintAvlTreeCore(root.left);
            prePrintAvlTreeCore(root.right);
        }
    }

    /**
     * 中序遍历二叉树
     */
    public void inPrintAvlTree(){
        inPrintAvlTreeCore(this.root);
        System.out.println();
    }

    private void inPrintAvlTreeCore(AvlNode root){
        if(root!=null){
            inPrintAvlTreeCore(root.left);
            System.out.print(root.data+", ");
            inPrintAvlTreeCore(root.right);
        }
    }


}
