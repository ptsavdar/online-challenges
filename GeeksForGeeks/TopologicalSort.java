package GeeksForGeeks;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSort {
    public static int[] topoSort(ArrayList<Integer> graph[], int N) {
        boolean[] visited = new boolean[N];

        Stack<Integer> sorted = new Stack<>();
        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                DFS(i, graph, visited, sorted);
            }
        }
        int idx = 0;
        int[] toposort = new int[N];
        while (!sorted.isEmpty()) {
            toposort[idx] = sorted.pop();
            idx++;
        }

        return toposort;
    }

    public static void DFS(int v, ArrayList<Integer> adj[], boolean visited[], Stack<Integer> sorted)
    {
        visited[v] = true;
        for (int i:adj[v]) {
            if(!visited[i]) {
                DFS(i, adj, visited, sorted);
            }
        }
        sorted.push(v);
    }


}
