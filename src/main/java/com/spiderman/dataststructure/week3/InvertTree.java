package com.spiderman.dataststructure.week3;

import java.util.LinkedList;

/**
 * 226. 翻转二叉树
 *
 * @author SpiderMan
 * @version 1.0.0: com.spiderman.dataststructure.week3.InvertTree,v 0.1 2/21/21 12:27 PM Exp $$
 */
public class InvertTree {
    /**
     * Definition for a binary tree node.
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        //递归的终止条件
        if (root == null) {
            return null;
        }
        //当前层逻辑处理
        final TreeNode left = root.left,right = root.right;
        System.out.println("left:" + (left != null ? left.val : "null") + " right:" + (right != null ? right.val : "null"));
        //下探到下一层
        root.left = invertTree(right);
        root.right = invertTree(left);
        //当前状态重置
        return root;
    }

    public static void main(String[] args) {
        InvertTree test = new InvertTree();
        TreeNode leftTree = new TreeNode(2, new TreeNode(1, null, null), new TreeNode(3, null, null));
        TreeNode rightTree = new TreeNode(7, new TreeNode(6, null, null), new TreeNode(9, null, null));
        TreeNode root = new TreeNode(4, leftTree, rightTree);
        levelOrder(root);
        test.invertTree(root);
        levelOrder(root);


    }

    /**
     * 二叉树层级遍历
     * 1.首先申请一个新的队列，记为queue；
     * 2.将头结点head压入queue中；
     * 3.每次从queue中出队，记为node，然后打印node值，如果node左孩子不为空，则将左孩子入队；如果node的右孩子不为空，则将右孩子入队；
     * 重复步骤3，直到queue为空。
     *
     * @param root
     */
    public static void levelOrder(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.pop();
            System.out.print(root.val + ",");
            if (root.left != null) queue.add(root.left);
            if (root.right != null) queue.add(root.right);
        }
        System.out.println();
    }
}
