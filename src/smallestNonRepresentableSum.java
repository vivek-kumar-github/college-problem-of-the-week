import java.util.Scanner;

public class smallestNonRepresentableSum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = input.nextInt();
        }
        System.out.println(solve(arr));
    }
    public static int solve(int[] arr){
        int res = 1;
        for(int nums : arr){
            if(nums > res){
                return res;
            }else{
                res += nums;
            }
        }
        return res;
    }
}
