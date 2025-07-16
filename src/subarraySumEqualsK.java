import java.util.*;

public class subarraySumEqualsK {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = input.nextInt();
        }
        int k = input.nextInt();

        //SOLVE FOR BRUTE FORCE
        int ans1 = brute(arr, n, k);
        System.out.println(ans1);

        //SOLVE FOR OPTIMISED APPROACH
        int ans2 = optimised(arr, k);
        System.out.println(ans2);
    }

    //BRUTE FORCE APPROACH
    public static int brute(int[] arr, int n, int k){
        int ans = 0;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum = 0;
            for(int j = i ; j < n; j++){
                sum += arr[j];
                if(sum == k) ans++;
            }
        }
        return ans;
    }

    //OPTIMISED APPROACH USING HASHMAP
    public static int optimised(int[] arr, int k){
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int curr = 0;
        for(int i : arr){
            curr += i;
            res += map.getOrDefault(curr - k, 0);
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }
        return res;
    }
}
