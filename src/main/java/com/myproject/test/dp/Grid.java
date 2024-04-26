package com.myproject.test.dp;

public class Grid {

    public static void main(String[] args) {

    }

    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int column = obstacleGrid[0].length;
        int prev[] = new int[column];


        for (int i = 0; i < row; i++) {
            int temp[] = new int[column];
            for (int j = 0; j < column; j++) {
                if (i == 0 && j == 0)
                    return 1;
                else if (obstacleGrid[i][j] == 1) {
                    temp[j] = 0;
                } else {
                    int val = prev[j] + temp[j - 1];
                    temp[j] = val;
                }
            }
            prev = temp;
        }
        return prev[column - 1];
    }

}
