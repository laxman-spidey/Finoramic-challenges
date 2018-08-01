/**
 * Definition for binary tree */
//   class TreeNode {
//       int val;
//       TreeNode left;
//       TreeNode right;
//       TreeNode(int x) {
//       val = x;
//       left=null;
//       right=null;
//       }
//   }
 
public class Solution {
    ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
    
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) {
        //start traversing
        givenSum = B;
        traverse(A);
        return paths;
    }
    
    Stack<Integer> path = new Stack<Integer>();
    private int sum = 0;
    private int givenSum;
    
    public void traverse(TreeNode node) {
        path.push(node.val);
        sum += node.val;
            
        if(node.left != null) {
            // System.out.println("Traversing: " + node.val+", sum = " + sum +" --  going left");    
            traverse(node.left);
        }
        if(node.right != null) {
            traverse(node.right);
            // System.out.println("Traversing: " + node.val+", sum = " + sum +" --  going right");    
        }
        if(sum == givenSum) {
            if(node.left == null && node.right == null) {
                pushToAnswerArray(path);
            }
        }
        int poppedValue = path.pop();
        sum -= poppedValue;
    }
    
    private void pushToAnswerArray(Stack<Integer> stack) {
        // System.out.println("pushToAnswerArray");
        ArrayList list = new ArrayList<Integer>();
        list.addAll(stack);
        paths.add(list);
    }
    
}
