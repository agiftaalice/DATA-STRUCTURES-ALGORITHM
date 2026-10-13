import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] a) {
        List<Integer> ans = new ArrayList<>();
        int top = 0, bottom = a.length - 1;
        int left = 0, right = a[0].length - 1;

        while (top <= bottom && left <= right) {
            for (int c = left; c <= right; c++) ans.add(a[top][c]);
            top++;

            for (int r = top; r <= bottom; r++) ans.add(a[r][right]);
            right--;

            if (top <= bottom)
                for (int c = right; c >= left; c--) ans.add(a[bottom][c]);
            bottom--;

            if (left <= right)
                for (int r = bottom; r >= top; r--) ans.add(a[r][left]);
            left++;
        }
        return ans;
    }
}
