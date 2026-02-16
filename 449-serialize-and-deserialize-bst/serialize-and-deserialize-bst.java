/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;

public class Codec {

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }
    
    private void preorder(TreeNode root, StringBuilder sb) {
        if(root == null) return;
        sb.append(root.val).append(",");
        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    public TreeNode deserialize(String data) {
        if(data.isEmpty()) return null;
        
        String[] values = data.split(",");
        Queue<Integer> queue = new LinkedList<>();
        
        for(String val : values) {
            queue.offer(Integer.parseInt(val));
        }
        
        return build(queue, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private TreeNode build(Queue<Integer> queue, int min, int max) {
        if(queue.isEmpty()) return null;
        
        int val = queue.peek();
        if(val < min || val > max) return null;
        
        queue.poll();
        TreeNode root = new TreeNode(val);
        
        root.left = build(queue, min, val);
        root.right = build(queue, val, max);
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;