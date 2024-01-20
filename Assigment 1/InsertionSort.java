import java.util.Random;

public class InsertionSort {
   
    void sort(int arr[])
    {
        int n = arr.length;
        
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
}

 class test2 {
    public static void main(String[] args) {
        int[] sizes = {10, 50, 100, 1000 , 10000};
        Random rand = new Random();

        for (int size : sizes) {
            int[] randomArray = rand.ints(size, 0, 50).toArray();

            long insertionSortStartTime = System.nanoTime();
            InsertionSort test1 = new InsertionSort();
            test1.sort(randomArray.clone());
            long insertionSortEndTime = System.nanoTime();
            double insertionSortRuntime = (insertionSortEndTime - insertionSortStartTime) / 1e9;
            
            System.out.println("Array Size: " + size);
            System.out.println("InsertionSort Runtime: " + insertionSortRuntime + " seconds");
            System.out.println("--".repeat(15));
        }
    }
}
 