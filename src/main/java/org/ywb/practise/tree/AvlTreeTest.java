package org.ywb.practise.tree;
/**
 * @author yuwenbo1
 * @date 2020/11/21 5:51 下午 星期六
 * @since 1.0.0
 */
public class AvlTreeTest {
    public static void main(String[] args) {
        AvlTree<Integer> avlTree = new AvlTree<>();
        for (int i = 0; i < 100; i++) {
            avlTree.insert(i);
        }
        System.out.println(avlTree.height());
        System.out.println(avlTree.contains(3));
        avlTree.delete(3);
        System.out.println(avlTree.contains(3));
    }
}
