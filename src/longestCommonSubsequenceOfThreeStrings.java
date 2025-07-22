import java.util.Scanner;

public class longestCommonSubsequenceOfThreeStrings {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s1 = input.nextLine();
        String s2 = input.nextLine();
        String s3 = input.nextLine();

        int res = lcsOf3(s1, s2, s3);
        System.out.println(res);
    }

    public static int lcsOf3(String s1, String s2, String s3) {

        //Initializing 3D array of dp;
        int[][][] dp = new int[s1.length() + 1][s2.length() + 1][s3.length() + 1];

        //Iterate over each characters cell and update values
        for(int i = 1; i <= s1.length(); i++){
            for(int j = 1; j <= s2.length(); j++){
                for(int k = 1; k <= s3.length(); k++){

                    //If new common char is encountered then add 1 to diagonally previous
                    //cell and store it in the current cell
                    if(s1.charAt(i - 1) == s2.charAt(j - 1) && s3.charAt(k - 1) == s2.charAt(j - 1)){
                        dp[i][j][k] = 1 + dp[i - 1][j - 1][k - 1];
                    }

                    //else store the max of upper cell and previous left cell
                    else{
                        dp[i][j][k] = Math.max(dp[i][j][k - 1], Math.max(dp[i - 1][j][k], dp[i][j - 1][k]));
                    }
                }
            }
        }

        //return the last cell value of dp
        return dp[dp.length - 1][dp[0].length - 1][dp[0][0].length - 1];
    }
}
