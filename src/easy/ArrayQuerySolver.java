package src.easy;

import java.util.*;

public class ArrayQuerySolver {

    static final int MOD = 1_000_000_007;

    // Your main logic goes here
    public long processQueries(List<Long> A, List<List<Integer>> queries) {
        // TODO: implement logic here
        long totalSum = 0;
        int arrayLength = A.size();
        int queriesSize = queries.size();

        for(int i = 0; i < queriesSize; i++) {
            int type = queries.get(i).get(0);
            int  left = queries.get(i).get(1);
            int  right = queries.get(i).get(2);

            if(type == 1) {
                applyQueries1(A, left, right);
            } else {
                totalSum = (totalSum + applyQueries2(A, left, right)) % MOD;
            }
        }

        return totalSum;
    }

    static void applyQueries1(List<Long> A, int left, int right) {
        long base = A.get(left);

        for(int i = left; i <= right; i++) {
            A.set(i, ((i - left + 1) * base) % MOD);
        }
    }

    static long applyQueries2(List<Long> A, int left, int right) {
        long sum = 0;

        for(int i = left; i <= right; i++) {
            sum =(sum + A.get(i)) % MOD;
        }
        return sum;
    }

    // Main method to simulate input/output like LeetCode test cases
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an input in this format.");
        System.out.println("\n1.First n size of array\n" +
                "2.Value of arrays\n" +
                "3.Size of queries\n" +
                "4.Values of queries\n");
        int n = sc.nextInt();
        List<Long> A = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            A.add(sc.nextLong());
        }

        int q = sc.nextInt();
        List<List<Integer>> queries = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            int type = sc.nextInt();
            int l = sc.nextInt();
            int r = sc.nextInt();
            queries.add(Arrays.asList(type, l, r));
        }

        ArrayQuerySolver solver = new ArrayQuerySolver();
        long result = solver.processQueries(A, queries);
        System.out.println(result);
    }
}
