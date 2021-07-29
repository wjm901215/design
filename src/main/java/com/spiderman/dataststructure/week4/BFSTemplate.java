package com.spiderman.dataststructure.week4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 总体说明
 * <p>具体说明</p>
 *
 * @author SpiderMan
 * @version 1.0.0: com.spiderman.dataststructure.week4.BFSTemplate,v 0.1 2/28/21 3:03 PM Exp $$
 */
public class BFSTemplate {
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
     * 广度优先遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> allResults = new ArrayList<>();
        if (root == null) {
            return allResults;
        }
        //使用队列进行维护，先进先出特性
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        //循环遍历队列
        while (!nodes.isEmpty()) {
            //将当前层size记录
            int size = nodes.size();
            List<Integer> results = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                //弹出队列数据
                TreeNode node = nodes.poll();
                //将弹出到队列数据加入到集合中
                results.add(node.val);
                //如果当前节点左子节点有值则加入到队列中
                if (node.left != null) {
                    nodes.add(node.left);
                }
                //如果当前节点右子节点有值则加入到队列中
                if (node.right != null) {
                    nodes.add(node.right);
                }
            }
            //将当前层集合加入到allResults中
            allResults.add(results);
        }
        return allResults;
    }


    /**
     * 深度优先遍历
     *
     * @param root 根节点
     * @return
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> allResults = new ArrayList<>();
        if (root == null) {
            return allResults;
        }
        travel(root, 0, allResults);
        return allResults;
    }

    /**
     * dfs
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
        TreeNode leftTree = new TreeNode(2,  new TreeNode(3), new TreeNode(4));
        TreeNode rightTree = new TreeNode(5, null, new TreeNode(6));
        TreeNode root = new TreeNode(1, leftTree, rightTree);
        BFSTemplate bfsTemplate = new BFSTemplate();
        bfsTemplate.levelOrder(root).forEach(tt-> {
            tt.stream().forEach(num->{
                System.out.print(num+",");
            });
            System.out.println();
        });
    }
}
