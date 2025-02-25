package com.example.leetcodemedium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/*Input: root = [1,null,2,null,3,null,4,null,null]
        Output: [2,1,3,null,null,null,4]*/
public class BalanceBST {
    public static class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

  public static void main(String[] s){
      TreeNode  root = new TreeNode(1,null,
              new TreeNode(2,null,new TreeNode(3,null,new TreeNode(4,null,null))));
      balanceBST(root);
  }
    public static  TreeNode balanceBST(TreeNode root) {
        List<TreeNode> listOfNodes = new ArrayList<TreeNode>();
        inOrder(listOfNodes, root );
        TreeNode node =  buildBalancedBST(listOfNodes,0,listOfNodes.size()-1);
        return node;
    }

    public static void inOrder(List<TreeNode>listOfNodes,TreeNode root){
        if(root == null){
            return;
        }
        inOrder(listOfNodes,root.left);
        listOfNodes.add(root);
        inOrder(listOfNodes,root.right);
        root.left =null;
        root.right= null;
    }

    private static TreeNode buildBalancedBST(List<TreeNode> elements, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode node = elements.get(mid);
        node.left = buildBalancedBST(elements, start, mid - 1);
        node.right = buildBalancedBST(elements, mid + 1, end);
        return node;
    }
}
