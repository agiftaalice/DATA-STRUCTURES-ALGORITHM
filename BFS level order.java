import java.util.*;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null)
            return ans;

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while (!q.isEmpty()) {

            int size = q.size();

            List<Integer> level = new ArrayList<>();

            while (size-- > 0) {

                TreeNode cur = q.poll();

                level.add(cur.val);

                if (cur.left != null)
                    q.offer(cur.left);

                if (cur.right != null)
                    q.offer(cur.right);
            }

            ans.add(level);
        }

        return ans;
    }
}
