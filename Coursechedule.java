import java.util.*;

class Solution {
    public boolean canFinish(int n, int[][] pre) {
        List<Integer>[] g = new ArrayList[n];
        int[] in = new int[n];

        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }

        for (int[] p : pre) {
            g[p[1]].add(p[0]);
            in[p[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (in[i] == 0) {
                q.offer(i);
            }
        }

        int count = 0;

        while (!q.isEmpty()) {
            int u = q.poll();
            count++;

            for (int v : g[u]) {
                if (--in[v] == 0) {
                    q.offer(v);
                }
            }
        }

        return count == n;
    }
}
