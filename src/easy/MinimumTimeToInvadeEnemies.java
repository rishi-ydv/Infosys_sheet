package src.easy;

import java.util.*;

public class MinimumTimeToInvadeEnemies {

    // Direction vectors for Up, Down, Left, Right
    private static final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static int minTimeToInvade(char[][] grid, int N, int M) {
        Queue<int[]> queue = new LinkedList<>();
        int totalEnemies = 0;

        // Step 1: Push all initial 'A' cells to queue, count total 'E'
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 'A') {
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == 'E') {
                    totalEnemies++;
                }
            }
        }

        if (totalEnemies == 0) return 0; // No enemy to invade
        if (queue.isEmpty()) return -1;  // No army to start invasion

        int time = 0;

        // Step 2: Multi-source BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean invadedThisRound = false;

            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                int x = pos[0], y = pos[1];

                for (int[] dir : directions) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && grid[nx][ny] == 'E') {
                        grid[nx][ny] = 'A'; // Invade enemy
                        queue.add(new int[]{nx, ny});
                        totalEnemies--;
                        invadedThisRound = true;
                    }
                }
            }

            if (invadedThisRound) time++; // Only increase time if at least one invasion occurred
        }

        return totalEnemies == 0 ? time : -1; // If any 'E' remains, return -1
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine().trim());
        int M = Integer.parseInt(sc.nextLine().trim());
        char[][] grid = new char[N][M];

        for (int i = 0; i < N; i++) {
            String line = sc.nextLine().trim();
            grid[i] = line.toCharArray();
        }

        int result = minTimeToInvade(grid, N, M);
        System.out.println("Total Min time to invade is :" + result);
    }
}
