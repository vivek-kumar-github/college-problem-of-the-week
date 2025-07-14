import java.util.*;
public class MinInSortedRotatedArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = input.nextInt();
        }

        // SOLVE FOR BRUTE FORCE
        int solve1 = brute(arr, n);
        System.out.println(solve1);

        // SOLVE FOR OPTIMISED APPROACH
        int solve2 = optimised(arr, n);
        System.out.println(solve2);
    }

    // BRUTE FORCE APPROACH
    public static int brute(int[] arr, int n){
        for(int i = 0; i < n - 1; i++){
            if(arr[i + 1] < arr[i]) return arr[i + 1];
        }
        return arr[0];
    }

    //OPTIMISED APPROACH WITH BINARY SEARCH
    public static int optimised(int[] arr, int n){
        int left = 0, right = n - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(arr[mid] < arr[right]){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }
        return arr[left];
    }
}
