package com.spiderman.dataststructure.week3;

/**
 * 104. 二叉树的最大深度
 *
 * @author SpiderMan
 * @version 1.0.0: com.spiderman.dataststructure.week3.MaxDepth,v 0.1 2/22/21 10:56 PM Exp $$
 */
public class MaxDepth {
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

    public int maxDepth(TreeNode root) {
        //递归终止条件
        if (root == null){
            return 0;
        }
        //当前层处理逻辑

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        //下探到下一次
        return Math.max(left,right)+1;
        //恢复当前状态
    }
    public static void main(String[] args) {
        MaxDepth test = new MaxDepth();
        TreeNode leftTree = new TreeNode(1);
        TreeNode rightTree = new TreeNode(2);
        TreeNode root = new TreeNode(3, leftTree, rightTree);
        System.out.println(test.maxDepth(root));


    }
}
