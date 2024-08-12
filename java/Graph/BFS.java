package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

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

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));
        
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6, 5));
    }

    // For connected graph means all teh nodes of the graph are interconnected by atleast one edge
    public static void bfs_connected(ArrayList<Edge> graph[], int V){
        Queue<Integer> q = new LinkedList<>(); 
        boolean vis[] = new boolean[V];
        q.add(0);

        while (!q.isEmpty()) {
            int curr = q.remove();
            if(vis[curr] == false){
                System.out.print(curr + " ");
                vis[curr] = true;

                for(int i=0;i<graph[curr].size();i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
    }

    // When the graph is disconnected and we want to do BFS
    public static void bfs_disconnected(ArrayList<Edge> graph[], int V,boolean[] vis,int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            int curr = q.remove();
            if(vis[curr] == false){
                System.out.print(curr + " ");
                vis[curr] = true;

                for(int i=0;i<graph[curr].size();i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int V = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        // for connected graphs
        bfs_connected(graph, V);
        
        // For disconnected graphs
        boolean vis[] = new boolean[V];
        for(int i=0;i<V;i++){
            if(vis[i] == false){
                bfs_disconnected(graph, V, vis, i);
            }
        }
    }
}
