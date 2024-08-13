package Graph;

import java.util.ArrayList;

public class creationofgraph_weighted_undirected_adjacencyLIst {

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

        // Edges for node 0
        graph[0].add(new Edge(0, 2,2));

        // Edges for node 1
        graph[1].add(new Edge(1, 2,10));
        graph[1].add(new Edge(1, 3,0));

        // Edges for node 2
        graph[2].add(new Edge(2, 0,2));
        graph[2].add(new Edge(2, 1,1));
        graph[2].add(new Edge(2, 3,-1));

        // Edges for node 3
        graph[3].add(new Edge(3, 1,-1));
        graph[3].add(new Edge(3, 2,0));
    }
    public static void main(String[] args) {
        int V = 4;
        // Defining the graph ADJACENCY LIST
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];

        // Creating the graph
        createGraph(graph);

        // Print Neighbours
        for(int i=0;i<graph[2].size();i++){
            Edge e = graph[2].get(i);
            System.out.println(e.dest + "," + e.wt);
        }
    }
}
