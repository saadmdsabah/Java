public class PowerOfNumberOptimized {

    public static int PowerOfNumber(int number, int power, int ans){
        if(power == 0){
            return ans;
        }
        if((power & 1) != 0){
            ans = ans*number;
        }
        power = power>>1;
        number = number*number;
        return PowerOfNumber(number, power, ans);
    }
    public static void main(String[] args) {
        System.out.println(PowerOfNumber(5, 4, 1));
    }   
}
