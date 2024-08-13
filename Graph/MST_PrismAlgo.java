package Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MST_PrismAlgo {

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

        // First the graph[] has null value so first we need to add a empty arrayList to each and every index them we can go about saving the edges
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1,10));
        graph[0].add(new Edge(0, 2,15));
        graph[0].add(new Edge(0, 3,30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0,15));
        graph[2].add(new Edge(2, 3,50));
        
        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
    }

    public static class Pair implements Comparable<Pair>{
        int node;
        int cost;
        
        Pair(int node, int cost){
            this.node = node;
            this.cost = cost;
        }
        
        public int compareTo(Pair p2){
            return this.cost - p2.cost;
        }

    }

    public static void primsAlgo(ArrayList<Edge> graph[], int V){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[] vis = new boolean[V];
        pq.add(new Pair(0, 0));

        int mstCost = 0; 

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if(!vis[curr.node]){
                vis[curr.node] = true;
                mstCost += curr.cost;

                for(int i=0;i<graph[curr.node].size();i++){
                    Edge e = graph[curr.node].get(i);
                    if(!vis[e.dest]){
                        pq.add(new Pair(e.dest, e.wt));
                    }
                }
            }
        }
        System.out.println("The minimum cost of the graph is : " + mstCost);
    } 

    public static void main(String[] args) {
        // MST(Minimum spanning tree) is a subgraph
        // The edge weight must be minimum
        // There must be no cycles

        int V = 4;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        primsAlgo(graph, V);
    }
}
