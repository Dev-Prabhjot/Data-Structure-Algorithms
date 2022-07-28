package Graph;

public class NoOfIslands {

    //   https://leetcode.com/problems/number-of-islands/

    //Find count of componenets in undirected Graph

    public static void main(String args[]) {

        //Grid input
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(numIslands(grid));

        //Graph input


    }

    public static int numIslands(char[][] isConnected) {
        if (isConnected == null || isConnected.length == 0)
            return 0;

        boolean[][] vis = new boolean[isConnected.length][isConnected[0].length];

        int count = 0;

        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[0].length; j++) {
                if (vis[i][j] == false && isConnected[i][j] == '1') {
                    findConnectedCity(vis, isConnected, i, j);
                    count++;
                }
            }
        }

        return count;
    }


    public static void findConnectedCity(boolean[][] vis, char[][] isConnected, int i, int j) {
        if (i < 0 || i >= isConnected.length || j < 0 || j >= isConnected[0].length || vis[i][j] || isConnected[i][j] == '0')
            return;

        vis[i][j] = true;

        findConnectedCity(vis, isConnected, i - 1, j);
        findConnectedCity(vis, isConnected, i + 1, j);
        findConnectedCity(vis, isConnected, i, j - 1);
        findConnectedCity(vis, isConnected, i, j + 1);

    }

}
