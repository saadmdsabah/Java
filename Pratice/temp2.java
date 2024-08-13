package Pratice;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class temp2 {

    static ArrayList<Integer> adjList[];
    static boolean visited[];

    // GraphTraversal creation
    @SuppressWarnings("unchecked")
    public static void GraphTraversal(int vertices) {
        adjList = new ArrayList[vertices];
        visited = new boolean[vertices];
        for (int i = 0; i < vertices; i++)
            adjList[i] = new ArrayList<Integer>();
    }

    // Add edges
    public static void addEdge(int src, int dest) {
        adjList[src].add(dest);
        adjList[dest].add(src); // Undirected graph
    }

    public static void BFS(int vertex) {
        @SuppressWarnings({ "unchecked", "rawtypes" })
        Queue<Integer> queue = new LinkedList();
        visited[vertex] = true;
        queue.add(vertex);

        while (queue.size() != 0) {
            vertex = queue.poll();
            System.out.print(vertex + " ");
            for (Integer v : adjList[vertex]) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }
    }

    // DFS algorithm
    public static void DFS(int vertex) {
        visited[vertex] = true;
        System.out.print(vertex + " ");
        for (Integer v : adjList[vertex]) {
            if (!visited[v])
                DFS(v);
        }
    }

    public static void DFS(int node, Stack<Integer> st) {
        visited[node] = true;
        for (Integer v : adjList[node]) {
            if(!visited[v])
                DFS(v, st);
        }
        st.push(node);
    }

    public static void topologicalSort(int vertices) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < vertices; i++) {
            if (!visited[i])
                DFS(i, st);
        }
        while (!st.isEmpty())
            System.out.print(st.pop() + " ");
    }



    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // int vertices = sc.nextInt();
        // int edges = sc.nextInt();
        // GraphTraversal(vertices);

        // int src, dest;
        // for (int i = 0; i < edges; i++) {
        //     src = sc.nextInt();
        //     dest = sc.nextInt();
        //     addEdge(src, dest);
        // }
        // sc.close();
        // vertices = 7
        // edges = 8
        // 0 1
        // 0 2
        // 1 2
        // 1 3
        // 2 4
        // 3 4
        // 3 5
        // 4 6
        // BFS(0);
        // topologicalSort(vertices);
        Stack<Character> stack = new Stack<>();
        System.out.println(stack.peek());
    }
}
