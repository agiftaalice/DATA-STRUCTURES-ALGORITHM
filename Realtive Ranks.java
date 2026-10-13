import java.util.*;

class Solution {
    public String[] findRelativeRanks(int[] score) {
        Integer[] idx = new Integer[score.length];
        for (int i = 0; i < score.length; i++) idx[i] = i;

        Arrays.sort(idx, (a, b) -> Integer.compare(score[b], score[a]));

        String[] ans = new String[score.length];
        for (int i = 0; i < idx.length; i++) {
            String r = i == 0 ? "Gold Medal" :
                       i == 1 ? "Silver Medal" :
                       i == 2 ? "Bronze Medal" : String.valueOf(i + 1);
            ans[idx[i]] = r;
        }
        return ans;
    }
}
