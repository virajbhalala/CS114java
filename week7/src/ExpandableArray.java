
public class ExpandableArray<E> {
  private E[] a;
  private int size;
  private final int INITIAL_SIZE = 10;
  private int count = 0;

  /** Constructor creates an empty array of initial size. */
  ExpandableArray() {
    //a =  new E[INITIAL_SIZE]; would like to do this, but Java won't allow
    a = (E[]) new Object[INITIAL_SIZE]; // compiler may complain, but ok.
    size = INITIAL_SIZE;
  }

  /**
   * Add object to end of list, extending array if necessary. This is the only
   * method that may call extend().
   */
  public void addToEnd(E o) {
    if (count == a.length)
      extend();
    a[count] = o;
    ++count;
  }

  /** Return index if o is present, else -1. */
  public int indexOf(E o) {
    for (int i = 0; i < count; ++i)
      if (a[i].equals(o))
        return i;
    return -1;
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
  public E get(int i) {
    return a[i];
  }

  public E set(int i, E o) {
    E t = a[i];
    a[i] = o;
    return t;
  }

  /** Add object to index i, making room by shifting to right. */

  public void add(int i, E o) {
    if ((i == 0) && this.isEmpty())
      addToEnd(o);
    else {
      addToEnd(a[count - 1]); // this deals with extend if necessary
      for (int j = count; j > i; j--)
        a[j] = a[j - 1];
      a[i] = o;
    }
  }

  public E remove(int i) {
    E t = a[i];
    for (int j = i; j < count - 1; ++j)
      a[j] = a[j + 1];
    --count;
    return t;
  }

  public int contains(E o) {
    for (int i = 0; i < count; ++i)
      if (a[i].equals(o))
        return i;
    return -1;
  }

  private void extend() {
    // E[] b = (E[]) new Object[2 * a.length];
    E[] b = (E[]) new Object[2 * a.length];
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
