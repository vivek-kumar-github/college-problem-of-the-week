import java.util.Scanner;

public class rubySecondHouse {
    public static int minCost(int[][] costs) {
        int n = costs.length;
        int k = costs[0].length;
        int[] prev = new int[k];

        // Initialize prev with costs[0]
        for (int j = 0; j < k; j++) {
            prev[j] = costs[0][j];
        }

        for (int i = 1; i < n; i++) {
            int[] curr = new int[k];

            // Find min1 and min2 in prev
            int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
            int idx1 = -1;
            for (int j = 0; j < k; j++) {
                if (prev[j] < min1) {
                    min2 = min1;
                    min1 = prev[j];
                    idx1 = j;
                } else if (prev[j] < min2) {
                    min2 = prev[j];
                }
            }

            // Fill current row
            for (int j = 0; j < k; j++) {
                curr[j] = costs[i][j] + (j == idx1 ? min2 : min1);
            }

            prev = curr;
        }

        // Get the minimum in the last row
        int ans = Integer.MAX_VALUE;
        for (int val : prev) {
            ans = Math.min(ans, val);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        int[][] arr = new int[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                arr[i][j] = input.nextInt();
            }
        }
        int ans = minCost(arr);
        System.out.println(ans);
    }
}
