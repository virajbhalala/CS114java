import java.util.ArrayList;
import java.util.LinkedList;

public class CompareLists {

  public static void main(String[] args) {
    ArrayList<Integer> al = new ArrayList<Integer>();
    LinkedList<Integer> ll = new LinkedList<Integer>();

    int n = 100000;

    long start = System.currentTimeMillis();
    System.out.println("Adding elements to ArrayList");
    for (int i = 0; i < n; ++i)
      al.add(new Integer(i));
    long elapsed = System.currentTimeMillis() - start;
    System.out.println("Done in: " + elapsed + " ms.");

    start = System.currentTimeMillis();
    System.out.println("Adding elements to LinkedList");
    for (int i = 0; i < n; ++i)
      ll.add(new Integer(i));
    elapsed = System.currentTimeMillis() - start;
    System.out.println("Done in: " + elapsed + " ms.");

    start = System.currentTimeMillis();
    System.out.println("Removing elements from front of ArrayList");
    while (!al.isEmpty())
      al.remove(0); // remove first element
    elapsed = System.currentTimeMillis() - start;
    System.out.println("Done in: " + elapsed + " ms.");

    start = System.currentTimeMillis();
    System.out.println("Removing elements from front of LinkedList");
    while (!ll.isEmpty())
      ll.remove(); // remove first element
    elapsed = System.currentTimeMillis() - start;
    System.out.println("Done in: " + elapsed + " ms.");

    for (int i = 0; i < n; ++i) {
      al.add(new Integer(i));
      ll.add(new Integer(i));
    }

    start = System.currentTimeMillis();
    System.out.println("Summing elements of ArrayList");
    double sum = 0.0;
    for (int i = 0; i < n; ++i)
      sum += al.get(i);
    elapsed = System.currentTimeMillis() - start;
    System.out.println("Done in: " + elapsed + " ms.");

    start = System.currentTimeMillis();
    System.out.println("Summing elements of LinkedList");
    sum = 0.0;
    for (int i = 0; i < n; ++i)
      sum += ll.get(i);
    elapsed = System.currentTimeMillis() - start;
    System.out.println("Done in: " + elapsed + " ms.");
  }
}