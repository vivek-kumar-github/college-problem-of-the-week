import java.util.Scanner;

public class equalSumPartition {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = input.nextInt();
        }
        System.out.println(solve(arr));
    }
    public static boolean solve(int[] arr){
        int sum = 0;
        for(int x : arr){
            sum += x;
        }
        if((sum & 1) != 0){
            return false;
        }
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for(int num : arr){
            for(int j = target; j >= num; j--){
                dp[j] = dp[j] || dp[j - num];
            }
        }
        return dp[target];
    }
}
