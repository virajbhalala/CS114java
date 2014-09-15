import java.util.Random;
/*
 * Implementations of various sorting algorithms, with timing
 * to compare sort times.
 */

public class Sorts {

  public static void main(String[] args) {
    int n = 10000;
    int Repititions = 100;
    Random rm = new Random();
    Integer[] A = new Integer[n];
    Integer[] B = new Integer[n]; // for mergesort


    long start = System.currentTimeMillis();
    for (int rep = 0; rep < Repititions; ++rep) {
      for (int i = 0; i < n; ++i)
        A[i] = rm.nextInt(100);
    }
    long end = System.currentTimeMillis();
    long rt = end - start;
    System.out.println("randomization time = " + rt);

    start = System.currentTimeMillis();
    for (int rep = 0; rep < Repititions; ++rep) {

      // Insert 20 random numbers from 0 to 99
      for (int i = 0; i < n; ++i)
        A[i] = rm.nextInt(100);
      qsort(A, 0, n - 1);
      // mergesort(A, B, 0, n - 1);
      // inssort(A);
      // heapsort(A);
    }
    end = System.currentTimeMillis();
    System.out.println("qsort took " + (end - start - rt) + " millis");


    start = System.currentTimeMillis();
    for (int rep = 0; rep < Repititions; ++rep) {

      // Insert 20 random numbers from 0 to 99
      for (int i = 0; i < n; ++i)
        A[i] = rm.nextInt(100);
      // qsort(A, 0, n - 1);
      mergesort(A, B, 0, n - 1);
      // inssort(A);
      // heapsort(A);
    }
    end = System.currentTimeMillis();
    System.out.println("mergesort took " + (end - start - rt) + " millis");

    start = System.currentTimeMillis();
    for (int rep = 0; rep < Repititions; ++rep) {

      // Insert 20 random numbers from 0 to 99
      for (int i = 0; i < n; ++i)
        A[i] = rm.nextInt(100);
      // qsort(A, 0, n - 1);
      // mergesort(A, B, 0, n - 1);
      inssort(A);
      // heapsort(A);
    }
    end = System.currentTimeMillis();
    System.out.println("insort took " + (end - start - rt) + " millis");

    start = System.currentTimeMillis();
    for (int rep = 0; rep < Repititions; ++rep) {

      // Insert 20 random numbers from 0 to 99
      for (int i = 0; i < n; ++i)
        A[i] = rm.nextInt(100);
      // qsort(A, 0, n - 1);
      // mergesort(A, B, 0, n - 1);
      // inssort(A);
      heapsort(A);
    }
    end = System.currentTimeMillis();
    System.out.println("heapsort took " + (end - start - rt) + " millis");

    start = System.currentTimeMillis();
    for (int rep = 0; rep < Repititions; ++rep) {

      // Insert 20 random numbers from 0 to 99
      for (int i = 0; i < n; ++i)
        A[i] = rm.nextInt(100);
      // qsort(A, 0, n - 1);
      // mergesort(A, B, 0, n - 1);
      // inssort(A);
      // heapsort(A);
      selectsort(A);
    }
    end = System.currentTimeMillis();
    System.out.println("selectsort took " + (end - start - rt) + " millis");

    // Print in decreasing order
    // for (int i = 0; i < n; ++i)
    // System.out.println(A[i]);
  }

  static <E extends Comparable<E>> void selectsort(E[] A) {
    for (int i = 0; i < A.length - 1; i++) { // Select i'th record
      int lowindex = i; // Remember its index
      for (int j = A.length - 1; j > i; j--)
        // Find the least value
        if (A[j].compareTo(A[lowindex]) < 0)
          lowindex = j; // Put it in place
      swap(A, i, lowindex);
    }
  }


  static <E extends Comparable<E>> void qsort(E[] A, int i, int j) { // Quicksort
    int pivotindex = findpivot(A, i, j); // Pick a pivot
    swap(A, pivotindex, j); // Stick pivot at end
    // k will be the first position in the right subarray
    int k = partition(A, i - 1, j, A[j]);
    swap(A, k, j); // Put pivot in place
    if ((k - i) > 1)
      qsort(A, i, k - 1); // Sort left partition
    if ((j - k) > 1)
      qsort(A, k + 1, j); // Sort right partition
  }

  static <E extends Comparable<? super E>> int findpivot(E[] A, int i, int j) {
    return j;
  }

  static <E extends Comparable<E>> int partition(E[] A, int l, int r,
      E pivot) {
    do { // Move bounds inward until they meet
      while (A[++l].compareTo(pivot) < 0)
        ;
      while ((r != 0) && (A[--r].compareTo(pivot) >= 0))
        ;
      swap(A, l, r); // Swap out-of-place values
    } while (l < r); // Stop when they cross
    swap(A, l, r); // Reverse last, wasted swap
    return l; // Return first position in right partition
  }

  static <E extends Comparable<E>> void mergesort(E[] A, E[] temp,
      int l, int r) {
    int mid = (l + r) / 2; // Select midpoint
    if (l == r)
      return; // List has one element
    mergesort(A, temp, l, mid); // Mergesort first half
    mergesort(A, temp, mid + 1, r); // Mergesort second half
    for (int i = l; i <= r; i++)
      // Copy subarray to temp
      temp[i] = A[i];
    // Do the merge operation back to A
    int i1 = l;
    int i2 = mid + 1;
    for (int curr = l; curr <= r; curr++) {
      if (i1 == mid + 1) // Left sublist exhausted
        A[curr] = temp[i2++];
      else if (i2 > r) // Right sublist exhausted
        A[curr] = temp[i1++];
      else if (temp[i1].compareTo(temp[i2]) < 0) // Get smaller
        A[curr] = temp[i1++];
      else
        A[curr] = temp[i2++];
    }
  }

  static <E extends Comparable<E>> void inssort(E[] A) {
    for (int i = 1; i < A.length; i++)
      // Insert i'th record
      for (int j = i; (j > 0) && (A[j].compareTo(A[j - 1]) < 0); j--)
        swap(A, j, j - 1);
  }

  static <E extends Comparable<E>> void heapsort(E[] A) {
    // The heap constructor invokes the buildheap method
    MaxHeap<E> H = new MaxHeap<E>(A);
    for (int i = 0; i < A.length; i++)
      // Now sort
      A[A.length - i - 1] = H.removemax(); // Removemax places max at end
    // of heap
  }

  private static <E extends Comparable<E>> void swap(E[] A, int i, int j) {
    E temp = A[j];
    A[j] = A[i];
    A[i] = temp;
  }
}
