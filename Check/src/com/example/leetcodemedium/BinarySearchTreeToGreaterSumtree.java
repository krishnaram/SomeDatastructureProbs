package com.example.leetcodemedium;

public class BinarySearchTreeToGreaterSumtree {


    // Definition for a binary tree node.
      public class TreeNode {
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
      /*
      BinarySearchTreeToGreaterSumtree
      Input: root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
       */
    public static void main(String[] s) {
        /*Node
        System.out.println("Sample test passing is valid BinarySearchTreeToGreaterSumtree: " +
                (bstToGst(new int[]{0,0,0,1,0,1,1,0},3) == 3)  + "\r\n");;*/
    }
        public TreeNode bstToGst(int[] arr) {
            /*TreeNode root = new TreeNode();
                    for(int i:arr){
                        root.val =
                    }*/
            //bstToGstWithSum( root,0);
            return null;
        }

    public static int bstToGstWithSum(TreeNode root,int sum) {
        if(root == null){
            return sum;
        }
        if(root.left == null && root.right == null){
            root.val= root.val+sum;
            return root.val;
        }
        sum = bstToGstWithSum(root.right,sum);
        root.val = root.val+ sum;
        sum = bstToGstWithSum(root.left,root.val);
        return sum;
    }

        public static  int[][] construct2DArray(int[] original, int m, int n) {
            if((m*n) == original.length){
                int[][] array2D = new int[m][n];
                int row =0;
                int col  =0;
                for(int i=0;i<original.length;i++){
                    array2D[row][col] = original[i];
                    col++;
                    if(col==n){
                        row++;
                        col=0;
                    }
                }

                return array2D;
            }
            return new int[0][0];
        }


}
