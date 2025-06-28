package src.easy;

public class MinimumInitialOil {
    public static int minimumInitialOil(int[] A, int C) {
        int currentOil = 0;
        int minOil = 0;

        for (int action : A) {
            if (action == -1) {
                currentOil -= 1;
            } else {
                if (currentOil < C) {
                    currentOil += 1;
                }
            }
            minOil = Math.min(minOil, currentOil);
        }

        return Math.abs(minOil); // this is the minimum X to make oil never go below 0
    }

    public static void main(String[] args) {
        // Case 1
        int[] A1 = {-1, 1, 1};
        int C1 = 3;
        System.out.println(minimumInitialOil(A1, C1)); // Output: 1

        // Case 2
        int[] A2 = {-1, -1, 1};
        int C2 = 2;
        System.out.println(minimumInitialOil(A2, C2)); // Output: 2

        // Case 3
        int[] A3 = {1, 1, 1, 1};
        int C3 = 3;
        System.out.println(minimumInitialOil(A3, C3)); // Output: 0
    }
}

