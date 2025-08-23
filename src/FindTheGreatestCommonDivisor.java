import java.util.Scanner;

public class FindTheGreatestCommonDivisor {
    public static int gcd(int p, int q) {
        if (q == 0) return p;
        return gcd(q, p % q);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        int ans = arr[0];
        for (int i = 1; i < n; i++) {
            ans = gcd(ans, arr[i]);
        }
        System.out.println(ans);
    }
}
