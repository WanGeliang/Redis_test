package Leetcode_JZoffer;

public class JZ64 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}};
        System.out.println(minPathSum(matrix));
    }

    public static int minPathSum(int[][] grid) {
        if (grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        int res = grid[m - 1][n - 1];
        int i = m - 1;
        int j = n - 1;
        int temp = 0;
        while (i >= 0 || j >= 0) {
            if ((i >= 0 && j >= 0) && grid[i][j - 1] >= grid[i - 1][j]) {
                temp = grid[i - 1][j];
                res += temp;
                i--;
            } else if ((i >= 0 && j >= 0 )&& grid[i][j - 1] < grid[i - 1][j]) {
                temp = grid[i][j - 1];
                res += temp;
                j--;
            } else {
                if (i == 0) {
                    j--;
                } else if (j == 0) {
                    i--;
                } else break;
            }
        }
        return res;
    }
}
