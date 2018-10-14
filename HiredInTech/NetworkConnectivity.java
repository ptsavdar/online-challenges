package HiredInTech;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NetworkConnectivity {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int s = sc.nextInt();
        Graph g = new Graph(n);
        while(m-- > 0) {
            Graph.addEdge(g, sc.nextInt(), sc.nextInt());
        }
        System.out.println(Graph.countReachableNodes(g, s));
        sc.close();
    }

    private static class Graph {
        List<List<Integer>> edges;
        int[] degree;
        int nvertices;

        private Graph(int n) {
            this.edges = new ArrayList<>(n + 1);
            for (int i = 0; i <= n; i++) {
                edges.add(new ArrayList<>());
            }
            this.nvertices = n;
            this.degree = new int[n + 1];
        }

        private static void addEdge(Graph g, int from, int to) {
            g.edges.get(from).add(to);
            g.edges.get(to).add(from);
            g.degree[from]++;
            g.degree[to]++;
        }

        private static int countReachableNodes(Graph g, int from) {
            boolean[] visited = new boolean[g.nvertices + 1];
            return dfs(g, from, visited, -1);
        }

        private static int dfs(Graph g, int from, boolean[] visited, int count) {
            visited[from] = true;
            for (Integer edge : g.edges.get(from)) {
                if (!visited[edge]) {
                    count = dfs(g, edge, visited, count);
                }
            }

            return count + 1;
        }


    }
}
