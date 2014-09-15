
import java.util.ArrayList;

public class Experiment {

  public static void main(String[] args) {

    int n;
    int k = 50; // experiment size
    int REP = 10;

    int[] data = new int[k];
    for (int i = 0; i < k; ++i) {
      n = (i + 1) * 1000;
      // ArrayList<Integer> A = new ArrayList<Integer>(n);
      Integer[] A = new Integer[n];
      for (int j = 0; j < n; ++j)
        A[j] = j;
     
      long start = System.currentTimeMillis();
      for (int rep = 0; rep < REP; ++rep) {
        Sorts.shuffleArray(A);
        Sorts.sort1(A);
      }
      long now = System.currentTimeMillis();
      long elapsed = now - start;
      data[i] = (int) elapsed;
    }
    Plot.view(data);
    //for(int i=0;i<k;++i)
      //System.out.println(data[i]);
  }
}
