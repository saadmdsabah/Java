package Pratice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class praticeGraph {

    static ArrayList<Integer>[] graph;
    static boolean visited[];

    @SuppressWarnings("unchecked")
    public static void createGraph(int vertices){
        graph = new ArrayList[vertices];
        visited = new boolean[vertices];
        for(int i=0; i<vertices; i++){
            graph[i] = new ArrayList<>();
        }
    }

    public static void addEdge(int scr, int dest){
        graph[scr].add(dest);
        graph[dest].add(scr); //For Undirected Graph
    }

    public static void DFS(int vertex){
        visited[vertex] = true;
        System.out.print(vertex + " ");
        for(int i : graph[vertex]){
            if(!visited[i]){
                DFS(i);
            }
        }
    }

    public static void BFS(int vertex){
        Queue<Integer> q = new LinkedList<>();
        visited[vertex] = true;
        q.add(vertex);
        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");
            for(int i : graph[curr]){
                if(!visited[i]){
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        int vertices = 7;
        @SuppressWarnings("unused")
        int edges = 8;
        createGraph(vertices);
        addEdge(0, 1);
        addEdge(0, 2);
        addEdge(1, 2);
        addEdge(1, 3);
        addEdge(2, 4);
        addEdge(3, 4);
        addEdge(3, 5);
        addEdge(4, 6);
        // DFS(0);
        System.out.println();
        BFS(0);
    }
}
