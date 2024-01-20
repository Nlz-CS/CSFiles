import java.util.Random;

public class MergeSort {
 
    void merge(int arr[], int l, int m, int r)
    {
       
        int n1 = m - l + 1;
        int n2 = r - m;
        int L[] = new int[n1];
        int R[] = new int[n2];
 
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
 
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    void sort(int arr[], int l, int r)
    {
        if (l < r) {
            int m = l + (r - l) / 2;

            sort(arr, l, m);
            sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }
}
 class Test {
    public static void main(String[] args) {
        int[] sizes = {10, 50, 100, 1000 , 10000};
        Random rand = new Random();

        for (int size : sizes) {
            int[] randomArray = rand.ints(size, 0, 50).toArray();

            long mergeSortStartTime = System.nanoTime();
            MergeSort test1 = new MergeSort();
            test1.sort(randomArray.clone(), 0, size - 1);
            long mergeSortEndTime = System.nanoTime();
            double mergeSortRuntime = (mergeSortEndTime - mergeSortStartTime) / 1e9;
            System.out.println("MergeSort Runtime: " + mergeSortRuntime + " seconds");
            System.out.println("Array Size: " + size);
            System.out.println("--".repeat(15));
        }
    }
}
