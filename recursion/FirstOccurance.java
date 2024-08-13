public class FirstOccurance {

    public static int firstOcc(int[] array, int key, int index){
        if(index == array.length){
            return -1;
        }
        if(array[index]  == key){
            return index;
        }
        return firstOcc(array, key, index+1);
    }
    public static void main(String[] args) {
        System.out.println(firstOcc(new int[]{1,2,4,5,2}, 2, 0));
    }
}
