package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    public static void main(String args[]) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(2).add(4);
        adj.get(4).add(2);


        ArrayList<Integer> ans = bfsOfGraph(5, adj);
        printAns(ans);


    }

    public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {

        boolean[] visited = new boolean[V + 1];
        Arrays.fill(visited, false);
        ArrayList<Integer> bfs = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (visited[i] == false){

                Queue<Integer> queue=new LinkedList<>();
                queue.add(i);
                visited[i]=true;

                while(!queue.isEmpty()){

                    Integer vertex=queue.poll();
                    bfs.add(vertex);

                for(Integer it: adj.get(i))
                {
                    if(visited[it]==false)
                    {
                        visited[it]=true;
                        queue.add(it);
                    }
                }
                }
            }
        }

        // Code here
        return bfs;
    }

    static void printAns(ArrayList<Integer> ans) {
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }
}
