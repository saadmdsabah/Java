import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {

  public static void DFS(ArrayList<Integer>[] graph, boolean[] vis, int curr) {
    vis[curr] = true;
    System.out.print(curr + " ");
    for (int i = 0; i < graph[curr].size(); i++) {
      if (!vis[graph[curr].get(i)]) {
        DFS(graph, vis, graph[curr].get(i));
      }
    }
  }

  public static void BFS(ArrayList<Integer>[] graph, int curr){
    boolean[] vis = new boolean[graph.length];
    vis[curr] = true;
    System.out.print (curr + " ");

    Queue<Integer> q = new LinkedList<>();
    q.add(curr);

    while (!q.isEmpty()) {
        int temp = q.remove();
        for(int i : graph[temp]){
            if(!vis[i]){
                System.out.print(i + " ");
                vis[i] = true;
                q.add(i);
            }
        }
    }
  }

  public static void main(String[] args) {
    @SuppressWarnings("unchecked")
    ArrayList<Integer>[] graph = new ArrayList[6];
    for (int i = 0; i < 6; i++) {
      graph[i] = new ArrayList<>();
    }

    graph[0].add(1);
    graph[0].add(2);
    graph[0].add(3);

    graph[1].add(2);
    graph[1].add(3);
    graph[1].add(5);

    graph[2].add(4);
    graph[2].add(5);
    graph[2].add(1);

    graph[3].add(4);
    graph[3].add(5);
    graph[3].add(1);

    graph[4].add(5);
    graph[4].add(3);
    graph[4].add(2);

    graph[5].add(2);
    graph[5].add(3);
    graph[5].add(4);

    boolean[] vis = new boolean[6];
    DFS(graph, vis, 0);
    System.out.println();
    BFS(graph, 0);
  }
}
