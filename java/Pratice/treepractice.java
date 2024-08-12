package Pratice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class treepractice {

    public static class Edge {
        int scr;
        int dest;
        public Edge(int s, int d){
            this.scr = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph, int V){
        for(int i=0; i<V; i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 4));

        graph[2].add(new Edge(2, 3));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 3));
    }

    public static void bfs(ArrayList<Edge>[] graph, int V){
        boolean[] vis = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while (!q.isEmpty()) {
            int curr = q.remove();
            if(vis[curr] == false){
                vis[curr] = true;
                System.out.print(curr + " ");
                for(int i=0; i<graph[curr].size(); i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void bfs(ArrayList<Edge>[] graph, int V, boolean[] vis, int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            int curr = q.remove();
            if(vis[curr] == false){
                vis[curr] = true;
                System.out.print(curr + " ");
                for(int i=0; i<graph[curr].size(); i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge>[] graph, int V, boolean[] vis, int curr){
        if(vis[curr]){
            return;
        }
        System.out.print(curr + " ");
        vis[curr] = true;
        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            dfs(graph, V, vis, e.dest);
        }
    }

    public static void main(String[] args) {
        int V = 5;
        @SuppressWarnings({"unchecked"})
        ArrayList<Edge>[] graph = new ArrayList[V];
        boolean vis[] = new boolean[V];
        createGraph(graph, V);
        bfs(graph, V);
        System.out.println();
        for(int i=0; i<V; i++){
            bfs(graph, V, vis, i);
        }
        System.out.println();
        dfs(graph, V, vis, 0);
    }
}
