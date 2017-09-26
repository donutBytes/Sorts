/*
Alexander Bickham
9/26/17
Project #1
 */

package Sort;

public class Sorts
{
    //returns true only if a is sorted from smallest to largest values
    public static boolean isSorted( int[] a) {
        int last = 0;
        for(int i = 0; i < a.length; i++) {
            if(a[i] < a[last]){
                return false;
            }
            last = i;
        }
        return true;
    }


    /* --------------------MergeSort --------------------*/

    //merges sorted slices a[i.. j] and a[j + 1 …  k] for 0<=  i <=j < k < a.length
    public static void merge ( int[] arr,  int left, int right , int end)  {
        int n1 = right - left + 1;
        int arrayL[] = new int[n1];
        for(int i = 0; i < n1; i++) {
            arrayL[i] = arr[left + i];
        }

        int n2 = end - right;
        int arrayR[] = new int[n2];
        for(int i = 0; i < n2; i++) {
            arrayR[i] = arr[right + 1 + i];
        }

        int i = 0, j = 0;
        int index = left;
        while(i < n1 && j < n2) {
            if(arrayL[i] <= arrayR[j]) {
                arr[index++] = arrayL[i++];
            }
            else {
                arr[index++] = arrayR[j++];
            }
        }
        while(i < n1) {
            arr[index++] = arrayL[i++];
        }
        while(j < n2) {
            arr[index++] = arrayR[j++];
        }
    }

    //sorts  a[ i .. k]  for 0<=i <= k < a.length
    public static void mergeSort(int[] a,  int i ,  int k)  {
        if(i < k) {
            int m = (i + k)/2;
            mergeSort(a,i,m);
            mergeSort(a,m+1,k);
            merge(a,i,m,k);
        }
    }

    //Sorts the array a using mergesort
    //Driver Method
    public static void  mergeSort(int[] a ) {
        mergeSort(a,0, a.length-1);
    }


    /* ----------   QuickSort ---------------------------------------------- */

    //Implements in-place partition from text. Partitions subarray s[a..b] into s[a..l-1] and s[l+1..b] // so that all elements of  s[a..l-1] are less than each element in s[l+1..b]
    public static int partition(int[] s,  int a , int b )  {
        int pivot = s[b];
        int left = a, right = b-1;
        while(left <= right) {
            while(left <= right && s[left] <= pivot) {
                left += 1;
            }
            while(right >= left && s[right] >= pivot) {
                right -= 1;
            }
            if(left < right) {
                swap(s, left, right);
            }
        }
        swap(s,left,b);
        return left;
    }

    private static void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    //quick sorts subarray a[i..j]
    public static void quickSort(int[] a, int i, int j) {
        if(i < j) {
            int pivot = partition(a,i,j);
            quickSort(a,i,pivot-1);
            quickSort(a,pivot+1,j);
        }
    }

    //quick sorts array a
    //Driver Method
    public static void quickSort( int[] a) {
        quickSort(a,0,a.length-1);
    }

    /*----- Main Method for primitive testing -----*/
    public static void main(String args[]) {
        int array[] = { 34, 67, 23, 19, 122, 300, 2, 5, 17, 18, 5, 4,  3,  19, -40, 23  };
        int unsortedMerge[] = array.clone();
        int unsortedQuick[] = array.clone();

        /* Testing MergeSort */
        System.out.println("\nIsSort = " + isSorted(unsortedMerge));
        for(int i = 0; i < unsortedMerge.length; i++) {
            System.out.print(unsortedMerge[i] + ",");
        }

        System.out.println("\n\nStarting mergeSort");
        mergeSort(unsortedMerge);
        System.out.println("Ending mergeSort\n");

        System.out.println("IsSort = " + isSorted(unsortedMerge));
        for(int i = 0; i < unsortedMerge.length; i++) {
            System.out.print(unsortedMerge[i] + ",");
        }


        System.out.println("\n\n*********************************");


        /* Testing QuickSort */
        System.out.println("\nIsSort = " + isSorted(unsortedQuick));
        for(int i = 0; i < unsortedQuick.length; i++) {
            System.out.print(unsortedQuick[i] + ",");
        }

        System.out.println("\n\nStarting quickSort");
        quickSort(unsortedQuick);
        System.out.println("Ending quickSort\n");

        System.out.println("IsSort = " + isSorted(unsortedQuick));
        for(int i = 0; i < unsortedQuick.length; i++) {
            System.out.print(unsortedQuick[i] + ",");
        }
        System.out.println("\n\n*********************************");
    }

}