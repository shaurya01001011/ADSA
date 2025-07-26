import java.util.Scanner;

public class mergesort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements:");
        int n = sc.nextInt();
        int[] Arr = new int[n];
        System.out.println("Enter" + n + "Elements");
        for (int i = 0; i < n; i++) {
            Arr[i] = sc.nextInt();
        }
        System.out.println("Original array:");
        printArray(Arr);
        mergesort(Arr, 0, n - 1);
        System.out.println("Sorted Array:");
        printArray(Arr);
        sc.close();


    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

    }


    public static void mergesort(int[] A, int lo, int hi) {
        if (lo < hi) {
            int mid = (lo + hi) / 2;
            mergesort(A, lo, mid);
            mergesort(A, mid + 1, hi);
            merge(A, lo, mid, hi);
        }
    }


    public static void merge(int[] A, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        int k = 0;
        int[] B = new int[hi - lo + 1];

        while (i <= mid && j <= hi) {
            if (A[i] <= A[j]) {
                B[k++] = A[i++];

            } else {
                B[k++] = A[j++];
            }
        }
        //copy all remaining element fron A[i]to B[i]
        while (i <= mid) {
            B[k++] = A[i++];
        }
        //copy all remaining element fron A[j] to B[j]
        while (j <= hi) {
            B[k++] = A[j++];
        }
        for (i = lo, k = 0; i <= hi; i++, k++) {
            A[i] = B[k];
        }
    }
}
