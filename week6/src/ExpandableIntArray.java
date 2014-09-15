/*
 * Maintains an array of ints. If the array is full and
 * we add a new element to the end of the array, the array 
 * is replaced by a larger one and the old elements copied
 * over.
 */

public class ExpandableIntArray {
  private int[] a;
  private int size;
  private final int INITIAL_SIZE = 5;
  private int count = 0;

  /** Constructor creates an empty array of initial size. */
  ExpandableIntArray() {
    a = new int[INITIAL_SIZE];
    size = INITIAL_SIZE;
  }
  public void add(int i, int k){
	  
	  //call extent() at the beginning to increase array size
	  count=count+10;
	  extend();
	  
	  //call extend() using for loop depending upon what index you want insert the number
	  for (int l=a.length;l<i;l=l+10){
	  count=count+10;
	  extend();
	  }
	  
	  //shifting numbers to right of the i
	  for(int j = a.length-1; j > i; j--)
	  {
	   a[j] = a[j-1];
	   
	  }
	  
	  //putting k in index i
	  a[i] = k;
	  
	 }
	 public void remove(int i){
	  
	  //bring all element after i to one index left
	  for(int j=i; j<a.length-2;j++){
	   a[j]= a[j+1];
	  }
	  
	  //makes last element=0 so there won't be duplicate of last number
	  a[a.length-1]=0;
	 }
  /**
   * Add int to end of list, extending array if necessary. This is the only
   * method that may call extend().
   */
  public void addToEnd(int i) {
    if (count == a.length)
      extend();
    a[count] = i;
    ++count;
  }

  public int size() {
    return count;
  }

  public boolean isEmpty() {
    return count == 0;
  }

  /**
   * For simplicity, in the following we ignore error checking for valid
   * indexes.
   */
  public int get(int i) {
    return a[i];
  }

  public int set(int i, int k) {
    int t = a[i];
    a[i] = k;
    return t;
  }

  private void extend() {
    int[] b = new int[10 + a.length];
    for (int i = 0; i < a.length; ++i)
      b[i] = a[i];
    a = b;
  }

  public String toString() {
    String s = "[";
    for (int i = 0; i < count; i++) {
      if (i > 0)
        s += ", "; // separate entries by commas
      s += a[i];
    }
    return s + "]";
  }
}
