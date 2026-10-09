import java.util.*;

class Solution {
    public boolean validPath(int n, int[][] edges, int s, int d) {

        List<Integer>[] g = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }

        boolean[] seen = new boolean[n];

        Queue<Integer> q = new LinkedList<>();

        q.offer(s);
        seen[s] = true;

        while (!q.isEmpty()) {

            int u = q.poll();

            if (u == d)
                return true;

            for (int v : g[u]) {

                if (!seen[v]) {
                    seen[v] = true;
                    q.offer(v);
                }
            }
        }

        return false;
    }
}
