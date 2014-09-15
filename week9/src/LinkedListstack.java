import java.util.LinkedList;

public class LinkedListstack<E> implements Stack<E>{

	
	LinkedList<E> stack;
	
	
	LinkedListstack() {
		stack =  new LinkedList<E>();
	}
	
	public boolean isEmpty(){
		return stack.isEmpty();
	}

	public int size(){
		return stack.size();
	}

	public void push(E c){
		stack.add(c);
	}

	public E pop() throws EmptyStackException {
		if(isEmpty())
			throw new EmptyStackException("Stack is empty.");
		return stack.remove(stack.size()-1);
	}
	public E top() throws EmptyStackException {
		if(isEmpty())
			throw new EmptyStackException("Stack is empty.");
		return stack.get(stack.size()-1);
	}


}