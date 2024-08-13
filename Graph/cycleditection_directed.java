package Graph;

import java.util.ArrayList;

public class cycleditection_directed {

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

        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 0));
    }

    public static boolean isCyclic(ArrayList<Edge> graph[],boolean[] vis, int curr, boolean[] rec){
        vis[curr] = true;
        rec[curr] = true;
        
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(rec[e.dest]){
                return true;
            }else if(!vis[e.dest]){
                if(isCyclic(graph, vis, e.dest, rec)){
                    return true;
                }
            }
        }
        rec[curr] = false;
        return false;
    }

    

    public static void main(String[] args) {
        int V = 4;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        // if the graph is connected
        System.out.println(isCyclic(graph, new boolean[V], 0, new boolean[V]));

        // if not connected
        boolean[] vis = new boolean[V];
        boolean[] rec = new boolean[V];
        for(int i=0;i<V; i++){
            boolean cycle = isCyclic(graph, vis, i, rec);
            if(cycle){
                System.out.println(cycle);
                break;
            }
        }
    }
}
