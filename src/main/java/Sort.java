
public class Sort<T extends Comparable<T>> {
    private int threshold = 2;

    public Sort() {
    }
    public void mergeSortIterative(T[] array) {
        int len=1;
        while (len < array.length) {
            int i=0;
            while (i < array.length) {
                int L2=i+len;
                int R2=i+(2*len)-1;
                if (L2 >= array.length) {
                    break;
                }
                if (R2 >= array.length) {
                    R2 = array.length - 1;
                }
                merge(array,i,L2-1,R2);
                i=i+(2*len);
            }
            len*=2;
        }
    }
    public void mergeSortRecursive(T[] array) {
        this.mergeSortRecursive(array, 0, array.length - 1);
    }

    private void mergeSortRecursive(T[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            this.mergeSortRecursive(array, left, mid);
            this.mergeSortRecursive(array, mid + 1, right);
            this.merge(array, left, mid, right);
        }

    }

    public void merge(T[] arr, int left, int mid, int right) {
        int leftLength = mid - left + 1;
        int rightLength = right - mid;
        Object[] leftArr = new Object[leftLength];
        Object[] rightArr = new Object[rightLength];

        int l;
        for(l = 0; l < leftLength; ++l) {
            leftArr[l] = arr[left + l];
        }

        for(l = 0; l < rightLength; ++l) {
            rightArr[l] = arr[mid + 1 + l];
        }

        l = 0;
        int r = 0;

        int k;
        for(k = left; l < leftLength && r < rightLength; ++k) {
            T leftValue = (T) leftArr[l];
            T rightValue = (T) rightArr[r];
            if (leftValue.compareTo(rightValue) <= 0) {
                arr[k] = leftValue;
                ++l;
            } else {
                arr[k] = rightValue;
                ++r;
            }
        }

        while(l < leftLength) {
            arr[k] = (T) leftArr[l];
            ++l;
            ++k;
        }

        while(r < rightLength) {
            arr[k] = (T) rightArr[r];
            ++r;
            ++k;
        }

    }
    public static void radixSort(int[] array, int base) {
        int max = findMax(array);
        int d = 1;

        for(int i = 0; max / d > 0; ++i) {
            countSort(array, base, d);
            d *= 10;
        }

    }

    private static int findMax(int[] arr) {
        int max = 0;

        for(int i = 0; i < arr.length; ++i) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        return max;
    }

    public static void countSort(int[] arr, int base, int d) {
        int[] count = new int[base];
        int[] output = new int[arr.length];

        int i;
        for(i = 0; i < arr.length; ++i) {
            ++count[arr[i] / d % 10];
        }

        for(i = 1; i < count.length; ++i) {
            count[i] += count[i - 1];
        }

        for(i = 0; i < count.length; ++i) {
            if (count[i] > 0) {
                int var10002 = count[i]--;
            }
        }

        for(i = arr.length - 1; i >= 0; --i) {
            output[count[arr[i] / d % 10]] = arr[i];
            --count[arr[i] / d % 10];
        }

        for(i = 0; i < arr.length; ++i) {
            arr[i] = output[i];
        }

    }

    public void quickSortRecitation(T[] arr) {
        this.quickSortRecitation(arr, 0, arr.length - 1);
    }

    public void quickSortRecitation(T[] arr, int p, int r) {
        if (r - p > this.threshold) {
            int q = this.partitionClass(arr, p, r);
            this.quickSortRecitation(arr, p, q - 1);
            this.quickSortRecitation(arr, q + 1, r);
        } else {
            this.simpleSort(arr, p, r);
        }

    }

    private int partitionRecitation(T[] arr, int p, int r) {
        T x = arr[r];
        int i = p;

        for(int j = p; j < r; ++j) {
            if (arr[j].compareTo(x) < 0 || arr[j].equals(x)) {
                ++i;
                this.swap(arr, i, j);
            }
        }

        this.swap(arr, i + 1, r);
        return i + 1;
    }

    public void quickSortClass(T[] arr) {
        this.quickSortClass(arr, 0, arr.length - 1);
    }

    public void quickSortClass(T[] arr, int p, int r) {
        if (r - p > this.threshold) {
            int q = this.partitionClass(arr, p, r);
            this.quickSortClass(arr, p, q - 1);
            this.quickSortClass(arr, q + 1, r);
        } else {
            this.simpleSort(arr, p, r);
        }

    }

    public void simpleSort(T[] arr, int p, int r) {
        for(int i = p; i < r; ++i) {
            for(int j = i + 1; j <= r; ++j) {
                if (arr[i].compareTo(arr[j]) > 0) {
                    this.swap(arr, i, j);
                }
            }
        }

    }

    private int partitionClass(T[] arr, int p, int r) {
        T x = arr[r];
        int j = r - 1;
        int i = p;

        while(true) {
            while(arr[i].compareTo(x) >= 0 || i > r) {
                if (j >= 0) {
                    while(arr[j].compareTo(x) > 0 && j >= p) {
                        --j;
                    }
                }

                if (i >= j) {
                    this.swap(arr, j + 1, r);
                    return j + 1;
                }

                this.swap(arr, i, j);
            }

            ++i;
        }
    }

    private void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void setNaiveSortThreshold(int threshold) {
        this.threshold = threshold;
    }
}
