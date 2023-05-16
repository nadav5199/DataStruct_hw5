import java.util.Random;

public class timeTest {
    private int size;

    public long testMergeIt (int size){
        this.size = size;
        Integer[] arr = new Integer[this.size];
        long startTime, endTime;
        double duration;
        Random randomGenerator = new Random();
        Sort<Integer> sorter = new Sort<Integer>();
        for (int j = 0; j < this.size; j++){
            arr[j] = randomGenerator.nextInt();
        }
        startTime = System.currentTimeMillis();
        sorter.mergeSortIterative(arr);
        endTime = System.currentTimeMillis();
        duration = ((double) (endTime - startTime));
        return duration;
    }

    public long testMergeRecur (int size){
        this.size = size;
        Integer[] arr = new Integer[this.size];
        long startTime, endTime;
        double duration;
        Random randomGenerator = new Random();
        Sort<Integer> sorter = new Sort<Integer>();
        for (int j = 0; j < this.size; j++){
            arr[j] = randomGenerator.nextInt();
        }
        startTime = System.currentTimeMillis();
        sorter.mergeSortRecursive(arr);
        endTime = System.currentTimeMillis();
        duration = ((double) (endTime - startTime));
        return duration;
    }

    public long testRadix (int size, int base){
        this.size = size;
        Integer[] arr = new Integer[this.size];
        long startTime, endTime;
        double duration;
        Random randomGenerator = new Random();
        Sort<Integer> sorter = new Sort<Integer>();
        for (int j = 0; j < this.size; j++){
            arr[j] = randomGenerator.nextInt();
        }
        startTime = System.currentTimeMillis();
        Sort.radixSort(arr, base);
        endTime = System.currentTimeMillis();
        duration = ((double) (endTime - startTime));
        return duration;
    }  
    
    public long testQuickClass (int size){
        this.size = size;
        Integer[] arr = new Integer[this.size];
        long startTime, endTime;
        double duration;
        Random randomGenerator = new Random();
        Sort<Integer> sorter = new Sort<Integer>();
        for (int j = 0; j < this.size; j++){
            arr[j] = randomGenerator.nextInt();
        }
        startTime = System.currentTimeMillis();
        sorter.quickSortClass(arr);
        endTime = System.currentTimeMillis();
        duration = ((double) (endTime - startTime));
        return duration;
    }
    
    public long testQuickRec (int size){
        this.size = size;
        Integer[] arr = new Integer[this.size];
        long startTime, endTime;
        double duration;
        Random randomGenerator = new Random();
        Sort<Integer> sorter = new Sort<Integer>();
        for (int j = 0; j < this.size; j++){
            arr[j] = randomGenerator.nextInt();
        }
        startTime = System.currentTimeMillis();
        sorter.quickSortRecitation(arr);
        endTime = System.currentTimeMillis();
        duration = ((double) (endTime - startTime));
        return duration;
    }
}
