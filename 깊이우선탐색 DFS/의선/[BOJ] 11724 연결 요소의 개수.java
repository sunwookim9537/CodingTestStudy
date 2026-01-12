package dfs;

import java.util.*;

public class Main1 {
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) graph.put(i, new ArrayList<>());


        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        visited = new boolean[n + 1];

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                count++;
                dfs(graph, i);
            }
        }

        System.out.println(count);
        sc.close();
    }

    static void dfs(Map<Integer, List<Integer>> graph, int start) {
        visited[start] = true;

        for (int next : graph.get(start)) {
            if (!visited[next]) {
                dfs(graph, next);
            }
        }
    }
}
