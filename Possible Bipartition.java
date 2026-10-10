import java.util.*;

class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {

        List<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] d : dislikes) {
            int a = d[0];
            int b = d[1];

            graph[a].add(b);
            graph[b].add(a);
        }

        int[] color = new int[n + 1];

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (color[i] != 0) {
                continue;
            }

            color[i] = 1;
            queue.offer(i);

            while (!queue.isEmpty()) {
                int person = queue.poll();

                for (int neighbor : graph[person]) {

                    if (color[neighbor] == 0) {
                        color[neighbor] = -color[person];
                        queue.offer(neighbor);
                    } else if (color[neighbor] == color[person]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
