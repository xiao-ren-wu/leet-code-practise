package org.ywb.practise.utils;

import org.ywb.practise.tree.TreeNode;

/**
 * @author yuwenbo1
 * @date 2020/10/20 10:17 下午 星期二
 * @since 1.0.0
 * 二叉搜索树工具类
 */
@SuppressWarnings("all")
public class BSTUtils {
    /**
     * 创建二叉搜索树
     *
     * @param valArr int[]
     * @return tree root
     */
    public static TreeNode createBST(int[] valArr) {
        if (valArr == null || valArr.length == 0) {
            return null;
        }
        TreeNode root = null, p = null, c = null, tail = null;
        for (int val : valArr) {
            p = new TreeNode(val);
            if (root == null) {
                root = p;
            } else {
                c = root;
                while (c != null) {
                    tail = c;
                    c = c.val > p.val ? c.left : c.right;
                }
                if (tail.val > p.val) {
                    tail.left = p;
                } else {
                    tail.right = p;
                }
            }
        }
        return root;
    }

    public static void prePrint(TreeNode root) {
        if (root != null) {
            System.out.println(root.val + " ");
            prePrint(root.left);
            prePrint(root.right);
        }
    }

    public static void postPrint(TreeNode root) {
        if (root != null) {
            postPrint(root.left);
            postPrint(root.right);
            System.out.print(root.val + " ");
        }
    }

    public static void midPrint(TreeNode root) {
        if (root != null) {
            midPrint(root.left);
            System.out.print(root.val + " ");
            midPrint(root.right);
        }
    }
}
