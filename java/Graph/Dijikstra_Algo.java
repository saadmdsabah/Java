package Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijikstra_Algo {

    static class Edge {
        int scr;
        int dest;
        int wt;

        Edge(int scr, int dest, int wt){
            this.scr = scr;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){

        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1,2));
        graph[0].add(new Edge(0, 2,4));

        graph[1].add(new Edge(1, 3,7));
        graph[1].add(new Edge(1, 2,1));

        graph[2].add(new Edge(2, 4,3));
        
        graph[3].add(new Edge(3, 5,1));

        graph[4].add(new Edge(4, 3,2));
        graph[4].add(new Edge(4, 5,5));
    }

    public static class Pair implements Comparable<Pair> {
        int node;
        int dist;

        Pair(int node, int dist){
            this.node = node;
            this.dist = dist;
        }

        @Override
        public int compareTo(Pair p2){
            return this.dist - p2.dist;
        }
    }

    public static void dijistrasAlgo(ArrayList<Edge> graph[], int scr, int V){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] dist = new int[V];
        for(int i=0;i<V;i++){
            if(i!=scr){
                dist[i] = Integer.MAX_VALUE;
            }
        }
        boolean[] vis = new boolean[V];

        pq.add(new Pair(scr, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if(!vis[curr.node]){
                vis[curr.node] = true;

                for(int i=0;i<graph[curr.node].size();i++){
                    Edge e = graph[curr.node].get(i);
                    int u = e.scr;
                    int v = e.dest;
                    if(dist[u] + e.wt < dist[v]){
                        dist[v] = dist[u] + e.wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }

        for(int i : dist){
            System.out.print(i + "  ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        // Does not work for negative weights
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        dijistrasAlgo(graph, 0, V);
    }
}