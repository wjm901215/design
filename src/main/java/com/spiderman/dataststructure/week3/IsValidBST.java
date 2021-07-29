package com.spiderman.dataststructure.week3;

/**
 * 98. 验证二叉搜索树
 *
 * @author SpiderMan
 * @version 1.0.0: com.spiderman.dataststructure.week3.IsValidBST,v 0.1 2/21/21 3:45 PM Exp $$
 */
public class IsValidBST {
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
    public boolean isValidBST(TreeNode root) {
        return validRecur(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    private boolean validRecur(TreeNode root, long minValue, long maxValue) {
        //递归终止条件
        if (root == null) {
            return true;
        }
        //当前层处理逻辑
        if (root.val >= maxValue || root.val <=minValue) {
            return false;
        }
        //下探到下一层
        boolean validLeft=validRecur(root.left,minValue,root.val);
        boolean validRight=validRecur(root.right,root.val,maxValue);
        return validLeft  && validRight;
        //恢复当前状态
    }

    public static void main(String[] args) {
        IsValidBST test = new IsValidBST();
        TreeNode leftTree = new TreeNode(1,null,null);
        TreeNode rightTree = new TreeNode(4, new TreeNode(3, null, null), new TreeNode(6, null, null));
        TreeNode root = new TreeNode(5, leftTree, rightTree);
        System.out.println(test.isValidBST(root));


    }
}
