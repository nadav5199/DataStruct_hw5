import java.util.Arrays;
import java.util.Random;

import static java.util.Arrays.sort;

public class SortTest {
    public static void main(String[] args) {
        int n = 10000;
        int Numiter = 100;
        Random randomGenerator = new Random();
        Sort<Integer> sorter = new Sort<Integer>();
        int[][] durationList = new int[6][Numiter];
        int[] avg = new int[6];
        Integer[] arr = new Integer[n];
        for (int k = 0; k < Numiter; k++) {
            for (int j = 0; j < arr.length; ++j) //initialize the array
            {
                arr[j] = randomGenerator.nextInt();
            }
            for (int i = 0; i < 6; i++) //choose the algo
            {
                switch (i) {
                    case 0://mergeSortRecursive
                    {
                        Integer[] Copy = new Integer[arr.length];
                        for (int j = 0; j < arr.length; ++j) {//initialize the array
                            Copy[j] = arr[i];
                        }
                        long startTime = System.currentTimeMillis();
                        sorter.mergeSortRecursive(Copy);
                        long endTime = System.currentTimeMillis();
                        int duration = (int) (endTime - startTime);
                        durationList[i][k] = duration;
                    }
                    case 1://mergeSortIterative
                    {
                        Integer[] Copy = new Integer[arr.length];
                        for (int j = 0; j < arr.length; ++j) {//initialize the array
                            Copy[j] = arr[i];
                        }
                        long startTime = System.currentTimeMillis();
                        sorter.mergeSortIterative(Copy);
                        long endTime = System.currentTimeMillis();
                        int duration = (int) (endTime - startTime);
                        durationList[i][k] = duration;
                    }
                    case 2://quickSortClass
                    {
                        Integer[] Copy = new Integer[arr.length];
                        for (int j = 0; j < arr.length; ++j) {//initialize the array
                            Copy[j] = arr[i];
                        }
                        long startTime = System.currentTimeMillis();
                        sorter.quickSortClass(Copy);
                        long endTime = System.currentTimeMillis();
                        int duration = (int) (endTime - startTime);
                        durationList[i][k] = duration;
                    }
                    case 3://quickSortRecitation
                    {
                        Integer[] Copy = new Integer[arr.length];
                        for (int j = 0; j < arr.length; ++j) {//initialize the array
                            Copy[j] = arr[i];
                        }
                        long startTime = System.currentTimeMillis();
                        sorter.quickSortRecitation(Copy);
                        long endTime = System.currentTimeMillis();
                        int duration = (int) (endTime - startTime);
                        durationList[i][k] = duration;
                    }
                    case 4://Arrays.sort
                    {
                        int[] Copy = new int[arr.length];
                        for (int j = 0; j < arr.length; ++j) {//initialize the array
                            Copy[j] = arr[j];
                        }
                        long startTime = System.currentTimeMillis();
                        Arrays.sort(Copy);
                        long endTime = System.currentTimeMillis();
                        int duration = (int) (endTime - startTime);
                        durationList[i][k] = duration;
                    }
                    case 5://radix
                    {
                        int[] Copy = new int[arr.length];
                        for (int j = 0; j < arr.length; ++j) {//initialize the array
                            Copy[j] = arr[j];
                        }
                        long startTime = System.currentTimeMillis();
                        Sort.radixSort(Copy, cBase(n));
                        long endTime = System.currentTimeMillis();
                        int duration = (int) (endTime - startTime);
                        durationList[i][k] = duration;
                    }

                }
            }
        }

    }

    public static int cBase(int n) {
        switch (n) {
            case 10000:
                return (int) Math.pow(2, 10);
            case 50000:
                return (int) Math.pow(2, 15);
            case 100000:
                return (int) Math.pow(2, 16);
            case 500000:
                return (int) Math.pow(2, 17);
            case 1000000:
                return (int) Math.pow(2, 18);
        }
        return n;
    }
}
