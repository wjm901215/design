package com.spiderman.dataststructure.week3;

/**
 * 236. 二叉树的最近公共祖先
 *
 * @author SpiderMan
 * @version 1.0.0: com.spiderman.dataststructure.week3.LowestCommonAncestor,v 0.1 2/21/21 9:43 PM Exp $$
 */
public class LowestCommonAncestor {
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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //递归终止条件
        //当越过叶节点，则直接返回 null ；
        //当 root 等于 p, q则直接返回 root；
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }
        //处理当前层逻辑
        //下探到下一层
        //开启递归左子节点，返回值记为 left
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        //开启递归右子节点，返回值记为 right
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        //恢复当前状态
        //当 left 和 right 同时不为空 ：说明 p,q 分列在 root 的 异侧 （分别在 左 / 右子树），因此 root 为最近公共祖先，返回 root ；
        return root;
    }

    private static TreeNode ans;

    public boolean dfs(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return false;
        }
        //在当前节点
        boolean inCurrentNode = root.val == p.val || root.val == q.val;
        //在左节点
        boolean inLeft = dfs(root.left,p,q);
        //在右节点
        boolean inRight = dfs(root.right,p,q);
        if((inLeft && inRight) || (inCurrentNode && (inLeft || inRight))){
            ans = root;
        }
        return inLeft || inRight || inCurrentNode;
    }

    public static void main(String[] args) {
        LowestCommonAncestor test = new LowestCommonAncestor();
        TreeNode leftTree = new TreeNode(5,  new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4)));
        TreeNode rightTree = new TreeNode(1, new TreeNode(0), new TreeNode(8));
        TreeNode root = new TreeNode(3, leftTree, rightTree);
        test.lowestCommonAncestor(root,  new TreeNode(6), new TreeNode(4));
        System.out.println(ans.val);
//        System.out.println(test.lowestCommonAncestor(root,  new TreeNode(7), new TreeNode(8)));


    }
}
