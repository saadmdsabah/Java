public class LastOccurance {

    public static int LastOcc(int[] array, int key, int index){
        if(index == -1){
            return -1;
        }
        if(array[index] == key){
            return index;
        }
        return LastOcc(array, key, index-1);
    }
    public static void main(String[] args) {
        System.out.println(LastOcc(new int[]{1,2,3,45,2,3}, 2, 5));
    }
}
