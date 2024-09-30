public class t{
    public static void main(String[] args) {
        int[] arr = {3,4,16};

        int count = 0;
        int value = 6;
        for(int i=0; i<arr.length; i++){
            if(arr[i] <= 5){
                for(int j=i; j<arr.length; j++){
                    if(arr[i] + arr[j] <= value){
                        count++;
                    }else{
                        break;
                    }
                }
            }
        }
        System.out.println(count);
    }
}