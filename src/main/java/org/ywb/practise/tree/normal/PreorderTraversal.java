package org.ywb.practise.tree.normal;

import org.ywb.practise.tree.TreeNode;
import org.ywb.practise.utils.BSTUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author yuwenbo1
 * @date 2020/10/27 8:18 上午 星期二
 * @since 1.0.0
 * <p>
 * 给定一个二叉树，返回它的前序遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,2,3]
 * 进阶:递归算法很简单，你可以通过迭代算法完成吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
//        ArrayList<Integer> res = new ArrayList<>();
//        preorderTraversalCore(root, res);
        return preorderTraversalWithStack(root);
    }

    private void preorderTraversalCore(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorderTraversalCore(root.left, res);
        preorderTraversalCore(root.right, res);
    }

    private List<Integer> preorderTraversalWithStack(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> trees = new Stack<>();
        trees.push(root);
        while (!trees.isEmpty()) {
            TreeNode node = trees.pop();
            res.add(node.val);
            if(node.right!=null){
                trees.push(node.right);
            }
            if(node.left!=null){
                trees.push(node.left);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode bst = BSTUtils.createBST(new int[]{1, 2, 3});
        List<Integer> integers = new PreorderTraversal().preorderTraversalWithStack(bst);
        integers.forEach(System.out::println);
    }
}
