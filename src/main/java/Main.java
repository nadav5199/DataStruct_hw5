import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        System.out.println("Starting...");
        Integer[] arr = new Integer[]{4124,12,12,235,34,534,1,12,152,32,2535,2,4363,6346,34,634};
        Sort s = new Sort();
        s.quickSortClass(arr);
        System.out.println(Arrays.toString(arr));
    }
}
