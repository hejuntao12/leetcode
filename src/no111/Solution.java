package no111;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public int minDepth(TreeNode root) {
        int n = 0;
        Queue<TreeNode> q = new ArrayDeque<>();
        if(root == null) {
            return n;
        }
        q.offer(root);
        while (q.size() > 0) {
            n++;
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                TreeNode currNode = q.poll();
                if(currNode.left == null && currNode.right == null){
                    return n;
                }
                if(currNode.left != null) {
                    q.offer(currNode.left);
                }
                if(currNode.right != null) {
                    q.offer(currNode.right);
                }
            }
        }
        return n;
    }
}
