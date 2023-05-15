import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        System.out.println("Starting...");
        Integer[] arr = new Integer[]{20,12,34,62,34,11};
        Sort s = new Sort();
        s.mergeSortIterative(arr);
        System.out.println(Arrays.toString(arr));
    }
}
