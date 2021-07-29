package com.spiderman.dataststructure.week4;

import com.spiderman.dataststructure.week3.LowestCommonAncestor;

import java.util.ArrayList;
import java.util.List;

/**
 * 总体说明
 * <p>具体说明</p>
 *
 * @author SpiderMan
 * @version 1.0.0: com.spiderman.dataststructure.week4.DFSTemplate,v 0.1 2/28/21 2:09 PM Exp $$
 */
public class DFSTemplate {
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

    /**
     * 深度优先遍历模版
     *
     * @param root 根节点
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> allResults = new ArrayList<>();
        if (root == null) {
            return allResults;
        }
        travel(root, 0, allResults);
        return allResults;
    }

    /**
     * 递归函数
     *
     * @param root 当前节点
     * @param level 递归深度
     * @param results 结果集
     */
    private void travel(TreeNode root, int level, List<List<Integer>> results) {
        //每个层级都创建一个集合，用于存放当前层级数据
        if (results.size() == level) {
            results.add(new ArrayList<>());
        }
        //往当前层级加数据
        results.get(level).add(root.val);
        //当前root节点left不为null
        if (root.left != null) {
            //下探到下一层级
            travel(root.left, level + 1, results);
        }
        //当前root节点right不为null
        if (root.right != null) {
            //下探到下一层级
            travel(root.right, level + 1, results);
        }
    }

    public static void main(String[] args) {
        TreeNode leftTree = new TreeNode(5,  new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4)));
        TreeNode rightTree = new TreeNode(1, new TreeNode(0), new TreeNode(8));
        TreeNode root = new TreeNode(3, leftTree, rightTree);
        DFSTemplate dfsTemplate = new DFSTemplate();
        dfsTemplate.levelOrder(root).forEach(tt-> {
            tt.stream().forEach(num->{
                System.out.print(num+",");
            });
            System.out.println();
        });
    }

}
