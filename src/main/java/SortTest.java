import java.util.Arrays;
import java.util.Random;

import static java.util.Arrays.sort;

public class SortTest {
    public static void main(String[] args) {


        int[] size = new int[]{10000, 50000, 100000, 500000, 1000000};//array for sizes
        String[] algo = new String[]{"mergeSortIterative:", "mergeSortRecursive:", "quickSortClass:", "quickSortRecitation:", "java's sort:", "radixSort:"};
        int n = 100000;
        int Numiter = 250;
        int sort = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                int[][] durationList = durationList(size[j], Numiter, i);
                double[] avg = getAvg(durationList);
                double[] div = getDiv(durationList);
                switch (i) {
                    case 0:
                        System.out.println("for random array of size " + size[j] + ":");
                        break;
                    case 1:
                        System.out.println("for sorted array of size " + size[j] + ":");
                        break;
                    case 2:
                        System.out.println("for reverse sorted array of size " + size[j] + ":");
                        break;
                }//how the array is sorted and the size
                for (int k = 0; k < 6; k++) {
                    System.out.println(algo[k] + " avg: " + avg[k] + " , diviation: " + div[k]);
                }
            }

        }
    }


    public static double[] getAvg(int[][] arr) {
        double[] avg = new double[6];
        for (int i = 0; i < 6; i++) {
            avg[i] = avg(arr, i);
        }
        return avg;
    }

    public static double[] getDiv(int[][] arr) {
        double[] div = new double[6];
        for (int i = 0; i < 6; i++) {
            div[i] = div(arr, i, avg(arr, i));
        }
        return div;
    }

    public static Integer[] random(int size) {
        Integer[] arr = new Integer[size];
        Random randomGenerator = new Random();
        for (int j = 0; j < arr.length; j++) //initialize the array
        {
            arr[j] = randomGenerator.nextInt(Integer.MAX_VALUE);
        }
        return arr;
    }

    public static Integer[] sorted(int size) {
        Integer[] arr = random(size);
        Arrays.sort(arr);
        return arr;
    }

    public static Integer[] reverse(int size) {
        Integer[] arr = sorted(size);
        Integer[] reverse = new Integer[size];
        for (int i = 0; i < arr.length; i++) {
            reverse[i] = arr[arr.length - i - 1];
        }
        return reverse;
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

    public static int[][] durationList(int size, int Numiter, int sort) {
        Sort<Integer> sorter = new Sort<Integer>();
        sorter.setNaiveSortThreshold(500);
        int[][] durationList = new int[6][Numiter];
        int[] avg = new int[6];
        Integer[] arr = new Integer[size];
        for (int k = 0; k < Numiter; k++) {
            switch (sort)//how to sort the array
            {
                case 0:
                    arr = random(size);
                    break;
                case 1:
                    arr = sorted(size);
                    break;
                case 2:
                    arr = reverse(size);
                    break;
            }
            for (int i = 0; i < 6; i++) //choose the algo
            {
                switch (i) {
                    case 0://mergeSortRecursive
                    {
                        Integer[] Copy = new Integer[arr.length];
                        for (int j = 0; j < arr.length; ++j) {//initialize the array
                            Copy[j] = arr[j];
                        }
                        long startTime = System.currentTimeMillis();
                        sorter.mergeSortRecursive(Copy);
                        long endTime = System.currentTimeMillis();
                        int duration = (int) (endTime - startTime);
                        durationList[i][k] = duration;
                        break;
                    }
                    case 1://mergeSortIterative
                    {
                        Integer[] Copy = new Integer[arr.length];
                        for (int j = 0; j < arr.length; ++j) {//initialize the array
                            Copy[j] = arr[j];
                        }
                        long startTime = System.currentTimeMillis();
                        sorter.mergeSortIterative(Copy);
                        long endTime = System.currentTimeMillis();
                        int duration = (int) (endTime - startTime);
                        durationList[i][k] = duration;
                        break;
                    }
                    case 2://quickSortClass
                    {

                        Integer[] Copy = new Integer[arr.length];
                        for (int j = 0; j < arr.length; ++j) {//initialize the array
                            Copy[j] = arr[j];
                        }
                        try {
                            long startTime = System.currentTimeMillis();
                            sorter.quickSortClass(Copy);
                            long endTime = System.currentTimeMillis();
                            int duration = (int) (endTime - startTime);
                            durationList[i][k] = duration;
                            break;
                        } catch (StackOverflowError e) {
                            System.err.println("ouch!");
                            continue;
                        }
                    }
                    case 3://quickSortRecitation
                    {
                        try {
                            Integer[] Copy = new Integer[arr.length];
                            for (int j = 0; j < arr.length; ++j) {//initialize the array
                                Copy[j] = arr[j];
                            }
                            long startTime = System.currentTimeMillis();
                            sorter.quickSortRecitation(Copy);
                            long endTime = System.currentTimeMillis();
                            int duration = (int) (endTime - startTime);
                            durationList[i][k] = duration;
                            break;
                        } catch (StackOverflowError e) {
                            System.err.println("ouch!");
                            continue;
                        }
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
                        break;
                    }
                    case 5://radix
                    {
                        int[] Copy = new int[arr.length];
                        for (int j = 0; j < arr.length; ++j) {//initialize the array
                            Copy[j] = arr[j];
                        }
                        long startTime = System.currentTimeMillis();
                        Sort.radixSort(Copy, cBase(size));
                        long endTime = System.currentTimeMillis();
                        int duration = (int) (endTime - startTime);
                        durationList[i][k] = duration;

                    }

                }
            }
        }
        return durationList;
    }

    public static double avg(int[][] arr, int row) {
        long sum = 0;
        for (int i = 0; i < arr[0].length; i++) {
            sum += arr[row][i];
        }
        return ((double) sum / arr[row].length);
    }

    public static double div(int[][] arr, int row, double avg) {
        double sum = 0;
        for (int i = 0; i < arr[0].length; i++) {
            sum += Math.pow((avg - arr[row][i]), 2);
        }
        return Math.sqrt((double) sum / arr[row].length);
    }
}
