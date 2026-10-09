class Solution {
    
    int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return ans;
    }

    int height(TreeNode n) {
        
        if (n == null)
            return 0;

        int l = height(n.left);
        int r = height(n.right);

        ans = Math.max(ans, l + r);

        return 1 + Math.max(l, r);
    }
}
