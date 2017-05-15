import java.util.Arrays;

/**
 * Created by rrr on 2017/5/13.
 */
public class Sort {


    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int middle = getMiddle(arr, low, high);
            quickSort(arr, low, middle - 1);
            quickSort(arr, middle + 1, high);
        }
    }

    public static int getMiddle(int[] arr, int low, int high) {
        int tmp = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= tmp) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] <= tmp) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = tmp;
        return low;
    }

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            int minValue = arr[i];
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < minValue) {
                    min = j;
                    minValue = arr[j];
                }
            }
            swap(arr, i, min);
        }
    }

    public static void insertSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int tmp = arr[i];
            int j = 0;
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] > tmp) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = tmp;
        }
    }

    public static void shellSort(int[] arr) {
        int increment = arr.length;
        for (int i = increment / 2; i > 0; i /= 2) {
            for (int j = i; j < arr.length; j++) {
                int tmp = arr[j];
                int k = 0;
                for (k = j; k >= i && arr[k] < arr[k - i]; k -= i) {
                    arr[k] = arr[k - i];
                }
                arr[k] = tmp;
            }
        }
    }

    public static void mergeSort(int[] arr, int low, int high) {
        int middle = (high + low) / 2;
        if (low < high) {
            mergeSort(arr, low, middle);
            mergeSort(arr, middle + 1, high);
            merge(arr, low, middle, high);
        }
    }

    public static void merge(int[] arr, int low, int middle, int high) {
        int[] tmp = new int[high - low + 1];
        int t = low;
        int s = middle + 1;
        int k = 0;
        while (t <= middle && s <= high) {
            if (arr[t] < arr[s]) {
                tmp[k++] = arr[t++];
            } else {
                tmp[k++] = arr[s++];
            }
        }
        while (t <= middle) {
            tmp[k++] = arr[t++];
        }
        while (s <= high) {
            tmp[k++] = arr[s++];
        }
        for (int i = 0; i < tmp.length; i++) {
            arr[low + i] = tmp[i];
        }
    }

    public static void heapSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            adjust(arr, arr.length - 1 - i);
            swap(arr, 0, arr.length - 1 - i);
        }
    }

    public static void adjust(int[] arr, int lastIndex) {
        int index = (lastIndex - 1) / 2;
        for (int i = index; i >= 0; i--) {
            int k = i;
            while (k < lastIndex) {
                int l = 2 * k + 1;
                int biggest = k;
                if (l <= lastIndex) {
                    if (arr[biggest] < arr[l]) {
                        biggest = l;
                    }
                    if (l + 1 <= lastIndex) {
                        if (arr[biggest] < arr[l + 1]) {
                            biggest = l + 1;
                        }
                    }
                }
                if (k != biggest) {
                    swap(arr, k, biggest);
                    k = biggest;
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 1995, 101, 6, 70, 2, 1, 35, 26};
        //bubbleSort(arr);
        //quickSort(arr, 0, arr.length - 1);
        //selectSort(arr);
        //insertSort(arr);
        //shellSort(arr);
        //mergeSort(arr, 0, arr.length - 1);
        heapSort(arr);
        print(arr);
    }

}
