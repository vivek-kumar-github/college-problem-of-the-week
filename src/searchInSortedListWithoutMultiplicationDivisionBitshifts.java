import java.util.Scanner;

public class searchInSortedListWithoutMultiplicationDivisionBitshifts {
    public static int div(int n , int d){
        int res = 0;
        while(n >= d){
            res++;
            n -= d;
        }
        return res;
    }
    public static boolean binarySearch(int[] arr, int x){
        int low = 0, high = arr.length - 1;
        while(low <= high){
            int mid = low + div((high - low), 2);
            if (arr[mid] == x) return true;
            else if (arr[mid] > x){
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        int x = input.nextInt();
        System.out.println(binarySearch(arr, x));
    }
}
