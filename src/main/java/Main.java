import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        System.out.println("Starting...");
        int[] arr = new int[]{1,5,45,44,23,15};
        Sort s = new Sort();
        Sort.radixSort(arr,6);
        System.out.println(Arrays.toString(arr));
    }
}
