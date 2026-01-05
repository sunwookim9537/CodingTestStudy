package bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1 {
    static int[][] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        graph = new int[n+1][n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v1 = Integer.parseInt(st.nextToken());
            graph[u][v1] = graph[v1][u] = 1;
        }
        visited = new boolean[n+1];
        dfs(v);
        System.out.println();

        visited = new boolean[n + 1];
        bfs(v);


    }

    public static void dfs(int v) {
        visited[v] = true;
        System.out.print(v+" ");

        if(v== graph.length){
            return;
        }
        for (int i = 1; i < graph.length; i++) {
            if (graph[v][i] == 1 && visited[i] == false) {
                dfs(i);
            }
        }
    }

    public static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visited[v] = true;
        System.out.print(v + " ");

        while (!q.isEmpty()) {
            int tmp = q.poll();
            for (int i = 1; i < graph.length; i++) {
                if (graph[tmp][i] == 1 && visited[i] == false) {
                    q.add(i);
                    visited[i] = true;
                    System.out.print(i + " ");
                }
            }
        }
    }
}
