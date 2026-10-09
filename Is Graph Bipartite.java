import java.util.*;

class Solution {
    public boolean isBipartite(int[][] g) {
        int n = g.length;
        int[] color = new int[n];

        for (int i = 0; i < n; i++) {
            if (color[i] == 0) {
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                color[i] = 1;

                while (!q.isEmpty()) {
                    int u = q.poll();

                    for (int v : g[u]) {
                        if (color[v] == 0) {
                            color[v] = -color[u];
                            q.offer(v);
                        } else if (color[v] == color[u]) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}
