import java.util.Arrays;
import java.util.Random;

public class SortTest {
    public SortTest() {
    }

    public static void main(String[] args) {
        int n = 10000;
        Integer[] arr = new Integer[n];
        Random randomGenerator = new Random();
        Sort sorter = new Sort();

        for(int j = 0; j < arr.length; ++j) {
            arr[j] = randomGenerator.nextInt();
        }

        long startTime = System.currentTimeMillis();
        sorter.quickSortRecitation(arr);
        long endTime = System.currentTimeMillis();
        double duration = (double)(endTime - startTime);
        System.out.println(Arrays.toString(arr));
        System.out.println(duration);
    }
}
