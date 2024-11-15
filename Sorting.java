public class Sorting {

  //        -
  // {1,2,3,4,5,6,7,8}
  public static void merge(int[] arr, int start, int mid, int end) {
    int[] temp = new int[end - start];
    int i = start, j = mid;
    int index = 0;
    while (i < mid && j < end) {
      if (arr[i] < arr[j]) {
        temp[index++] = arr[i];
        i++;
      } else {
        temp[index++] = arr[j];
        j++;
      }
    }
    while (i < mid) {
      temp[index++] = arr[i];
      i++;
    }

    while (j < end) {
      temp[index++] = arr[j];
      j++;
    }
    index = 0;
    for (i = start; i < end; i++) {
      arr[i] = temp[index++];
    }
  }

  public static int pivotCalc(int[] arr, int start, int end) {
    int pivot = arr[end - 1]; // Choosing the last element as pivot
    int i = start;

    for (int j = start; j < end - 1; j++) {
      if (arr[j] < pivot) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
        i++;
      }
    }

    // Place pivot in its correct position
    int temp = arr[i];
    arr[i] = pivot;
    arr[end - 1] = temp;

    return i; // Return the final pivot position
  }

  public static void quick(int[] arr, int start, int end) {
    if (start >= end - 1) {
      return;
    }
    int pivot = pivotCalc(arr, start, end);
    quick(arr, start, pivot);
    quick(arr, pivot + 1, end);
  }

  public static void divide(int[] arr, int start, int end) {
    if (start >= end - 1) {
      return;
    }
    int mid = (start + end) / 2;
    divide(arr, start, mid);
    divide(arr, mid, end);
    merge(arr, start, mid, end);
  }

  public static void bubbleSort(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[i] > arr[j]) {
          int temp = arr[j];
          arr[j] = arr[i];
          arr[i] = temp;
        }
      }
    }
  }

  public static void selectionSort(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      int min = i;
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[j] < arr[min]) {
          min = j;
        }
      }
      int temp = arr[i];
      arr[i] = arr[min];
      arr[min] = temp;
    }
  }

  public static void insertionSort(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      int current = arr[i];
      int j = i - 1;
      while (j >= 0 && arr[j] > current) {
        arr[j + 1] = arr[j];
        j--;
      }
      arr[j + 1] = current;
    }
  }

  public static void main(String[] args) {
    int[] arr = { 1, 4, -1, 2, 69, 45, 5, 3, 7, 6, 8, 10 };
    // divide(arr, 0, arr.length);
    quick(arr, 0, arr.length);
    // bubbleSort(arr);
    // selectionSort(arr);
    // insertionSort(arr);
    for (int i : arr) {
      System.out.print(i + " ");
    }
  }
}
