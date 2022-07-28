package Graph.checkCycle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
//https://takeuforward.org/data-structure/detect-a-cycle-in-undirected-graph-breadth-first-search/
public class CheckCycleInGraph {
    public static void main(String[] args) throws IOException {

        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(i, new ArrayList<Integer>());
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(2).add(3);
        adj.get(1).add(3);
        adj.get(2).add(4);

        boolean ans = isCycle(V, adj);
        if (ans)
            System.out.println("Yes");
        else
            System.out.println("No");

    }

    static boolean checkForCycle(ArrayList<ArrayList<Integer>> adj, int s,
                                 boolean vis[]) {
        Queue<Node> q = new LinkedList<>(); //BFS
        q.add(new Node(s, -1));
        vis[s] = true;

        while (!q.isEmpty()) {
            int node = q.peek().first;
            int parent = q.peek().second;
            q.remove();

            for (Integer it : adj.get(node)) {
                if (vis[it] == false) {
                    q.add(new Node(it, node));
                    vis[it] = true;
                } else if (vis[it]==true && parent != it) return true;
            }
        }

        return false;
    }

    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[V];
        Arrays.fill(vis, false);
        for (int i = 0; i < V; i++)
            if (vis[i] == false)
                if (checkForCycle(adj, i, vis))
                    return true;

        return false;
    }
}