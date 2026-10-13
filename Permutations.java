import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, new boolean[nums.length], new ArrayList<>(), ans);
        return ans;
    }

    void backtrack(int[] a, boolean[] used, List<Integer> cur, List<List<Integer>> ans) {
        if (cur.size() == a.length) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < a.length; i++)
            if (!used[i]) {
                used[i] = true;
                cur.add(a[i]);
                backtrack(a, used, cur, ans);
                cur.remove(cur.size() - 1);
                used[i] = false;
            }
    }
}
