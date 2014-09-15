/*
 * Numerical experiments to test different
 * expansion/contraction strategies for
 * the ExpandableArray. Add n Integers to
 * the end of the array, and keep track of
 * the elapsed time after multiples of 1000
 * operations.
 */

public class Experiment {

  public static void main(String[] args) {
    ExpandableArray<Integer> a = new ExpandableArray<Integer>();

    int n = 1000000;

    int[] data = new int[n / 1000];
    long start = System.currentTimeMillis();
    for (int i = 0; i < n; ++i) {
      a.addToEnd(i + 1);
      if (i % 1000 == 0) {
        long now = System.currentTimeMillis();
        long elapsed = now - start;
        data[i / 1000] = (int) elapsed;
        // System.out.println(i+" elapsed time: "+elapsed);
      }
    }
    Plot.view(data);
  }
}
