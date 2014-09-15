import java.util.ArrayList;
import java.util.*;
public class ArrayListqueue<E> implements Queue<E>{

	
	ArrayList<E> stack;
	
	
	ArrayListqueue() {
		stack =  new ArrayList<E>();
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

	@Override
	public E front() throws EmptyQueueException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void enqueue(E element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E dequeue() throws EmptyQueueException {
		// TODO Auto-generated method stub
		return null;
	}


}