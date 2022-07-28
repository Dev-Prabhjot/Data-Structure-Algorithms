package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class DFS {

    public static void main(String args[]) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // adding new arraylists to 'adj' to add neighbour nodes
        for (int i = 0; i < 6; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(1).add(2);
        adj.get(1).add(3);
        adj.get(1).add(4);
        adj.get(1).add(5);
        adj.get(2).add(4);
        adj.get(2).add(1);
        adj.get(3).add(1);
        adj.get(4).add(1);
        adj.get(4).add(2);
        adj.get(5).add(1);


        ArrayList<Integer> ans = dfsOfGraph(5, adj);
        printAns(ans);
    }

    public static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V + 1];
        Arrays.fill(visited, false);
        ArrayList<Integer> storedfs = new ArrayList<>();

        //If you are starting from node 2, then i should start from 2.
        for (int i = 1; i <= V; i++) {
            if (visited[i] == false) {
                dfs(i, visited, adj, storedfs);
            }
        }

        return storedfs;
    }

    public static void dfs(int node, boolean vis[], ArrayList<ArrayList<Integer>>
            adj, ArrayList<Integer> storedfs) {
        //Add to list or print popped node
        storedfs.add(node);
        //marking current node as visited
        vis[node] = true;

        //getting neighbour nodes
        for (Integer it : adj.get(node)) {
            if (vis[it] == false) {
                dfs(it, vis, adj, storedfs);
            }
        }
    }

    static void printAns(ArrayList<Integer> ans) {
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }

}
