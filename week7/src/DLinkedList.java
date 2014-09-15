 /**
  * Doubly linked list of DLNodes.
  */

public class DLinkedList<E extends Comparable> {
  protected DLNode<E> header, trailer;  // sentinels
  protected int size;    // number of elements
  /** Creates an empty list. */
  public DLinkedList() {  // initialize an empty list
    header = new DLNode<E>();
    trailer = new DLNode<E>();
    header.setNext(trailer);  // make header point to trailer
    trailer.setPrev(header);  // make trailer point to header
    size = 0;
  }
    
/** 
 * Return the size of the list, that is the number of elements it has. 
 * @return  Number of elements in the list
 */
  public void reverse(){
	  
	  DLNode <E> temp= header; 
	   header=trailer; 
	   trailer=temp; 
	  DLNode<E> p=header; 
	  //insertion sorting
	  while(p!=null)
	    { 
		  //saves next value in temp so it is not lost
	      temp=p.getNext(); 
	      p.setNext(p.getPrev()); 
	      p.setPrev(temp); 
	      p=p.getNext();
	    }
  }
  public int size() {   
    return size;
  }
    
/** 
 * This function returns true if and only if the list is empty 
 * @return  true if the list is empty, false otherwise
 */
  public boolean isEmpty() {    
    if (size == 0)
      return true;
    return false;
  }

/** 
 * Inspect the first element without modifying the list.
 * @return The first element in the sequence
 */    
  public E getFirst() throws EmptyListException {  
    if (isEmpty())
      throw new EmptyListException("List is empty.");
    return header.getNext().getElement();
  }
 
  public E getLast() throws EmptyListException { 
    if (isEmpty())
      throw new EmptyListException("List is empty.");
    return trailer.getPrev().getElement();
  }
  
  public DLNode<E> getFirstNode() { 
    return header.getNext();
  }
  
  public boolean hasSuccessor(DLNode<E> n){
    if(n.getNext() == trailer)
      return false;
    else return true;
  }

  public DLNode<E> getPrev(DLNode<E> v) throws IllegalArgumentException { 
    if (v == header) throw new IllegalArgumentException("can't move back from header");
    return v.getPrev();
  }

  public DLNode<E> getNext(DLNode<E> v) throws IllegalArgumentException { 
    if (v == trailer) throw new IllegalArgumentException("can't move past trailer");
    return v.getNext();
  }

  public void addAfter(DLNode<E> v, DLNode<E> z) {  
    DLNode<E> w = v.getNext();
    z.setPrev(v);
    z.setNext(w);
    w.setPrev(z);
    v.setNext(z);
  }

  public void addFirst(DLNode<E> v) {  
    addAfter(header, v);
  }

  public void addLast(E o) {  
    DLNode<E> secondtolast = trailer.getPrev();
    DLNode<E> last = new DLNode<E>(o, secondtolast, trailer);
    secondtolast.setNext(last);
    trailer.setPrev(last);
    size++;
  }

  public void remove(DLNode<E> v) {
    DLNode<E> u = v.getPrev();
    DLNode<E> w = v.getNext();
    w.setPrev(u);
    u.setNext(w);
    v.setPrev(null);
    v.setNext(null);
    size--;
   }

  public String toString() {
    String s = "[";
    DLNode<E> v = header.getNext();
    while(v != trailer) {
      s += v.getElement();
      v = v.getNext();
      if(v != trailer)
	s += ", ";
    }
    s += "]";
    return s;
  }

}
