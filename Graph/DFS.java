package Graph;

import java.util.ArrayList;

public class DFS {

    static class Edge {
        int scr;
        int dest;
        Edge(int scr, int dest){
            this.scr = scr;
            this.dest = dest;
        }
    }
    

    public static void createGraph(ArrayList<Edge> graph[]){

        // First the graph[] has null value so first we need to add a empty arrayList to each and every index them we can go about saving the edges
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        
        graph[3].add(new Edge(3, 5));

        graph[5].add(new Edge(5, 4));

        graph[6].add(new Edge(4, 3));
    }

    public static void dfs_connected(ArrayList<Edge> graph[],boolean[] vis,int curr){
        System.out.print(curr + " ");
        vis[curr] = true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if (vis[e.dest] == false) {
                dfs_connected(graph, vis, e.dest);
            }
        }
    }

    public static void dfs_disconnected(ArrayList<Edge> graph[],boolean[] vis,int curr){
        System.out.print(curr + " ");
        vis[curr] = true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if (vis[e.dest] == false) {
                dfs_disconnected(graph, vis, e.dest);
            }
        }
    }
    public static void main(String[] args) {
        int V = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        // for connected
        dfs_connected(graph, new boolean[V], 0);
        System.out.println();

        // for disconnected
        boolean vis[] = new boolean[V];
        for(int i=0;i<V;i++){
            if(vis[i] == false){
                dfs_disconnected(graph, vis, i);
            }
        }
    }
}
