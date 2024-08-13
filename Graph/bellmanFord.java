package Graph;

import java.util.ArrayList;

public class bellmanFord {

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

        graph[1].add(new Edge(1, 2,-4));

        graph[2].add(new Edge(2, 3,2));
        
        graph[3].add(new Edge(3, 4,4));

        graph[4].add(new Edge(4, 1,-1));
    }

    public static void bellmanFordAlgo(ArrayList<Edge> graph[], int scr, int V){
        int[] dist = new int[V];
        for(int i=0;i<V;i++){
            if(i!=scr){
                dist[i] = Integer.MAX_VALUE;
            }
        }

        for(int k=0;k<V-1;k++){
            for(int i=0;i<V;i++){
                for(int j=0;j<graph[i].size();j++){
                    Edge e = graph[i].get(j);
                    int u = e.scr;
                    int v = e.dest;
                    
                    if(dist[u] != Integer.MIN_VALUE && dist[u] + e.wt < dist[v]){
                        dist[v] = dist[u] + e.wt;
                    }
                }
            }
        }

        for(int i=0;i<V;i++){
            for(int j=0;j<graph[i].size();j++){
                Edge e = graph[i].get(j);
                int u = e.scr;
                int v = e.dest;
                
                if(dist[u] != Integer.MIN_VALUE && dist[u] + e.wt < dist[v]){
                    System.out.println("Negative cycle present");
                }
            }
        }

        for(int i : dist){
            System.out.print(i + "  ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Does not work for negative weight cycles
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        bellmanFordAlgo(graph, 0, V);
    }
}
