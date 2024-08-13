package DynamicProgramming.CatalanNumber;

public class CatalanNumber {

    public static int CatalanNumberRecursion(int number){
        if(number == 0 || number == 1){
            return 1;
        }
        int temp = 0;
        for(int i=0; i<number; i++){
            temp += CatalanNumberRecursion(i)*CatalanNumberRecursion(number-i-1);
        }
        return temp;
    }

    public static int CatalanNumberMemoization(int number, int[] dp){
        if(number == 0 || number == 1){
            return 1;
        }
        if(dp[number] != -1){
            return dp[number];
        }
        int temp = 0;
        for(int i=0; i<number; i++){
            temp += CatalanNumberMemoization(i, dp)*CatalanNumberMemoization(number-i-1, dp);
        }
        dp[number] = temp;
        return temp;
    }

    public static int CatalanNumberTabulation(int number){
        int[] dp = new int[number + 1];
        dp[0] = dp[1] = 1;
        for(int i=2; i<=number; i++){
            for(int j=0; j<i; j++){
                dp[i] += dp[j]*dp[i-j-1];
            }
        }
        return dp[number];
    }
    public static void main(String[] args) {
        int number = 10;
        int[] dp = new int[number + 1];
        dp[0] = dp[1] = 1;
        for(int i=2; i<=number; i++){
            dp[i] = -1;
        }

        System.out.println(CatalanNumberRecursion(number));
        System.out.println(CatalanNumberMemoization(number, dp));
        System.out.println(CatalanNumberTabulation(number));
    }
}
