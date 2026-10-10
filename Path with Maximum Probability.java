import java.util.*;

class Solution {
    public double maxProbability(int n, int[][] edges,
                                 double[] succProb,
                                 int start, int end) {

        List<double[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            double p = succProb[i];

            graph[a].add(new double[]{b, p});
            graph[b].add(new double[]{a, p});
        }

        double[] prob = new double[n];
        prob[start] = 1.0;

        PriorityQueue<double[]> pq =
            new PriorityQueue<>((a, b) ->
                Double.compare(b[1], a[1]));

        pq.offer(new double[]{start, 1.0});

        while (!pq.isEmpty()) {
            double[] curr = pq.poll();

            int node = (int) curr[0];
            double probability = curr[1];

            if (probability < prob[node]) {
                continue;
            }

            if (node == end) {
                return probability;
            }

            for (double[] next : graph[node]) {
                int neighbor = (int) next[0];
                double edgeProb = next[1];

                double newProb = probability * edgeProb;

                if (newProb > prob[neighbor]) {
                    prob[neighbor] = newProb;
                    pq.offer(new double[]{neighbor, newProb});
                }
            }
        }

        return 0.0;
    }
}
